package com.github.vspro.bootdubbozkconfigprovider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo(scanBasePackages = "com.github.vspro.bootdubbozkconfigprovider.api.impl")
public class BootDubboZkconfigProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootDubboZkconfigProviderApplication.class, args);
    }

}
