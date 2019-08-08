package com.aaa.microcredit;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.aaa.microcredit.dao")
@EnableTransactionManagement //开启事务
public class MicrocreditApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicrocreditApplication.class, args);
    }

}
