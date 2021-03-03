package com.yeb.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.yeb.server.mapper")
@SpringBootApplication
public class YebApplication {

    public static void main(String[] args) {

        SpringApplication.run(YebApplication.class,args);

    }
}
