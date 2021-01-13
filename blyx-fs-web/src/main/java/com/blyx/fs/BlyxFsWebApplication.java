package com.blyx.fs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.blyx.fs.infrastructrue.mapper")
public class BlyxFsWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlyxFsWebApplication.class, args);
    }

}
