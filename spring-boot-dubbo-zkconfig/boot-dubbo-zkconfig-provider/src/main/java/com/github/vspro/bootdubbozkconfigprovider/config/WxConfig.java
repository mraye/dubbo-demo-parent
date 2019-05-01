package com.github.vspro.bootdubbozkconfigprovider.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "wechat.oauth2")
@Configuration
@Data
public class WxConfig {

    private String appId;

    private String appSecret;

}
