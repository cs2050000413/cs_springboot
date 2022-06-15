package com.kaishun.study.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * ClassName:    SmsAccessKeyID
 * Package:    com.kaishun.study.config
 * Description:
 * Datetime:    2020/3/1   16:45
 * Author:   zhoukaishun
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
@Component
@ConfigurationProperties(prefix="smsconfigure")
@Data
public class SmsConfigure {

    private String regionId;

    private String accessKeyID;

    private String accessKeySecret;
    /**
     * 签名
     */
    private String signName;
    /**
     * 模板
     */
    private String templateCode;
}
