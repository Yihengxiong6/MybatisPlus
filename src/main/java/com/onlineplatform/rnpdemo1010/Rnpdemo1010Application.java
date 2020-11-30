package com.onlineplatform.rnpdemo1010;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.onlineplatform.rnpdemo1010.mapper")
public class Rnpdemo1010Application {

    public static void main(String[] args) {

        SpringApplication.run(Rnpdemo1010Application.class, args);
    }

}
