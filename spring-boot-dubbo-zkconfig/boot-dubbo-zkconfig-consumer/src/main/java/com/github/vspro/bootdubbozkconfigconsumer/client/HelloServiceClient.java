package com.github.vspro.bootdubbozkconfigconsumer.client;


import com.github.vspro.zk.api.IHelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

@Component
public class HelloServiceClient {


    @Reference
    private IHelloService iHelloService;


    public void doSayHi() {
        String result = iHelloService.sayHi("Qiao");
        System.out.println(result);
    }

    public void doGetWxConfig() {
        String result = iHelloService.getWxConfig();
        System.out.println(result);
    }
}
