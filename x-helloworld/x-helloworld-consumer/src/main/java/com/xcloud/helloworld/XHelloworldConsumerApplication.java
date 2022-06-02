package com.xcloud.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@ServletComponentScan
@EnableDiscoveryClient
@SpringBootApplication
public class XHelloworldConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(XHelloworldConsumerApplication.class, args);
    }

}
