package com;

import tk.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.mapper")
public class SqliteApplication {
    private Logger logger = LoggerFactory.getLogger(SqliteApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(SqliteApplication.class,args);
    }
}
