package com.qianfen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author hxq
 * @version 1.0
 * @date 2023/9/7 14:12 星期四
 */
//配置mybatis的包扫描器
@MapperScan(value = "com.qianfen.mapper")
@SpringBootApplication
public class SpringBoot03Application {

    public static void main(String[] args)   {
        SpringApplication.run(SpringBoot03Application.class, args);
    }
}
