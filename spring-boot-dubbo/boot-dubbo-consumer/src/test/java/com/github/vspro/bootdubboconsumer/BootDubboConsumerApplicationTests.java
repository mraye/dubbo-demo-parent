package com.github.vspro.bootdubboconsumer;

import com.github.vspro.bootdubboconsumer.client.HelloServiceClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootDubboConsumerApplicationTests {

    @Test
    public void contextLoads() {
    }


    @Autowired
    private HelloServiceClient helloServiceClient;

    @Test
    public void sayHiTest(){
        helloServiceClient.doSayHi();
    }

}
