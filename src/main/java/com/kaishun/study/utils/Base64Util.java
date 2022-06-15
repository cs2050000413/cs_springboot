package com.kaishun.study.utils;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * ClassName:    Base64Utils
 * Package:    com.kaishun.study.utils
 * Description:
 * Datetime:    2020/4/24   14:21
 * Author:   kaishun.zhou
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
public class Base64Util {

    // 加密
    public static String encode(String str) {
        byte[] b = null;
        String s = null;
        try {
            b = str.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (b != null) {
            s = Base64.getEncoder().encodeToString(b);
        }
        return s;
    }

    // 解密
    public static  String decode(String s) {
        byte[] b = null;
        String result = null;
        if (s != null) {
            try {
                b = Base64.getDecoder().decode(s);
                result = new String(b, "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }



}

