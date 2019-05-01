package com.github.vspro.bootdubbozkconfigconsumer;

import com.github.vspro.bootdubbozkconfigconsumer.client.HelloServiceClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootDubboZkconfigConsumerApplicationTests {

    @Test
    public void contextLoads() {
    }


    @Autowired
    private HelloServiceClient helloServiceClient;

    @Test
    public void sayHiTest() {
        helloServiceClient.doSayHi();
    }

    @Test
    public void getWxConfigTest() {
        helloServiceClient.doGetWxConfig();
    }
}
