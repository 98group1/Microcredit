package com.aaa.microcredit;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.aaa.microcredit.dao")
public class MicrocreditApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicrocreditApplication.class, args);
    }

}
