package com.kaishun.study.utils;

import com.kaishun.study.config.JWTConfig;
import com.kaishun.study.enums.ResultEnum;
import com.kaishun.study.exception.SystemException;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

/**
 * ClassName:    JwtTokenUtil
 * Package:    com.kaishun.study.utils
 * Description:
 * Datetime:    2020/4/24   14:00
 * Author:   kaishun.zhou
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
public class JwtTokenUtil {

    private static Logger log = LoggerFactory.getLogger(JwtTokenUtil.class);

    public static final String AUTH_HEADER_KEY = "Authorization";

    public static final String TOKEN_PREFIX = "Bearer ";


    /**
     * @description 解析jwt
     * @author kaishun.Zhou
     * @date 2020/4/24 14:03
     */
    public static  Claims parseJWT(String jsonWebToken, String base64Security) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(DatatypeConverter.parseBase64Binary(base64Security))
                    .parseClaimsJws(jsonWebToken).getBody();
            return claims;
        } catch (ExpiredJwtException eje) {
            log.error("===== Token过期 =====", eje);
            throw new SystemException(ResultEnum.PERMISSION_TOKEN_EXPIRED);
        } catch (Exception e){
            log.error("===== token解析异常 =====", e);
            throw new SystemException(ResultEnum.PERMISSION_TOKEN_INVALID);
        }
    }
    
    /**
     * @description 构建jwt
     * @author kaishun.Zhou
     * @date 2020/4/24 14:08
     */
    public static  String createJWT(String userId, String username, String role) {
        try {
            // 使用HS256加密算法
            SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

            long nowMillis = System.currentTimeMillis();
            Date now = new Date(nowMillis);

            //生成签名密钥
            byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(JWTConfig.base64Secret);
            Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

            //userId是重要信息，进行加密下
            String encryId = Base64Util.encode(userId);

            //添加构成JWT的参数
            JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JWT")
                    // 可以将基本不重要的对象信息放到claims
                    .claim("role", role)
                    .claim("userId", encryId)
                    .setSubject(username)           // 代表这个JWT的主体，即它的所有人
                    .setIssuer(JWTConfig.clientId)              // 代表这个JWT的签发主体；
                    .setIssuedAt(new Date())        // 是一个时间戳，代表这个JWT的签发时间；
                    .setAudience(JWTConfig.name)       // 代表这个JWT的接收对象；
                    .signWith(signatureAlgorithm, signingKey);
            //添加Token过期时间
            int TTLMillis = JWTConfig.expiresSecond;
            if (TTLMillis >= 0) {
                long expMillis = nowMillis + TTLMillis;
                Date exp = new Date(expMillis);
                builder.setExpiration(exp)  // 是一个时间戳，代表这个JWT的过期时间；
                        .setNotBefore(now); // 是一个时间戳，代表这个JWT生效的开始时间，意味着在这个时间之前验证JWT是会失败的
            }

            //生成JWT
            return builder.compact();
        } catch (Exception e) {
            log.error("签名失败", e);
            throw new SystemException(ResultEnum.PERMISSION_SIGNATURE_ERROR);
        }
    }

    /**
     * @description 从token中获取用户名
     * @author kaishun.Zhou
     * @date 2020/4/24 14:09
     */
    public static String getUsername(String base64Security){
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if(servletRequestAttributes == null){
            return "JAVA";
        }
        HttpServletRequest httpServletRequest = servletRequestAttributes.getRequest();
        String authHeader = httpServletRequest.getHeader(JwtTokenUtil.AUTH_HEADER_KEY);
        if("Bearer null".equals(authHeader)){
            return "JAVA";
        }
        String token = authHeader.substring(7);
        Claims claims = parseJWT(token, base64Security);
        return claims.getSubject();
    }
    
    /**
     * @description 从token中获取用户ID
     * @author kaishun.Zhou
     * @date 2020/4/24 14:18
     */
    public static String getUserId(String base64Security){
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest httpServletRequest = servletRequestAttributes.getRequest();
        String authHeader = httpServletRequest.getHeader(JwtTokenUtil.AUTH_HEADER_KEY);
        if("Bearer null".equals(authHeader)){
            return "JAVA";
        }
        String token = authHeader.substring(7);
        Claims claims = parseJWT(token, base64Security);
        String userId = claims.get("userId", String.class);
        return Base64Util.decode(userId);
    }

    /**
     * @description 是否已过期
     * @author kaishun.Zhou
     * @date 2020/4/24 14:18
     */
    public static boolean isExpiration(String token, String base64Security) {
        return parseJWT(token, base64Security).getExpiration().before(new Date());
    }

}
