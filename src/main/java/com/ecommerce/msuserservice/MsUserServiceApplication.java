package com.ecommerce.msuserservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class MsUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsUserServiceApplication.class, args);
    }

}
