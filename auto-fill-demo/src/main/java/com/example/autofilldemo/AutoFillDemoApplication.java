package com.example.autofilldemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 * @author qzz
 */
@SpringBootApplication
@MapperScan("com.example.autofilldemo.dao")
public class AutoFillDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutoFillDemoApplication.class, args);
    }

}
