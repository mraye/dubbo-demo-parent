package com.github.vspro.bootdubbozkconfigprovider.api.impl;

import com.github.vspro.bootdubbozkconfigprovider.config.WxConfig;
import com.github.vspro.zk.api.IHelloService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Service(interfaceClass = IHelloService.class, protocol = {"rest", "dubbo"})
@Component
public class HelloServiceImpl implements IHelloService {

    @Autowired
    private WxConfig wxConfig;

    @Override
    public String sayHi(String to) {
        return "Hi: " + to;
    }

    @Override
    public String getWxConfig() {
        return "[appId: " + wxConfig.getAppId() + ", appSecret: " + wxConfig.getAppSecret() + "]";
    }
}
