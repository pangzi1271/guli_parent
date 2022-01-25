package com.atguigu.oss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Description
 * @Author 老胖
 * @Date 22/01/2022 8:13 am
 */

@SpringBootApplication
@ComponentScan(basePackages = {"com.atguigu"})
public class OssApplication {

    public static void main(String[] args) {
        SpringApplication.run(OssApplication.class, args);
    }
}
