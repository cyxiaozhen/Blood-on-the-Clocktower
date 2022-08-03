package com.xs.botc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @email m18670240103@163.com
 * @author: xz
 * @date: 2022/8/2 周二
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.xs.botc.mapper"})
public class BloodOnTheClocktowerApplication {
    public static void main( String[] args ) {
        SpringApplication.run(BloodOnTheClocktowerApplication.class, args);
    }
}
