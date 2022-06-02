package com.xcloud.helloworld;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableDubbo
@ServletComponentScan
@EnableDiscoveryClient
@SpringBootApplication
public class XHelloWorldProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(XHelloWorldProviderApplication.class, args);
    }

}
