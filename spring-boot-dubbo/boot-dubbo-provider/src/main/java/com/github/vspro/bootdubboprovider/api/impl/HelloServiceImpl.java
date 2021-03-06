package com.github.vspro.bootdubboprovider.api.impl;

import com.github.vspro.api.IHelloService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;


@Service
@Component
public class HelloServiceImpl implements IHelloService {

    @Override
    public String sayHi(String to) {
        return "Hi: " + to;
    }
}
