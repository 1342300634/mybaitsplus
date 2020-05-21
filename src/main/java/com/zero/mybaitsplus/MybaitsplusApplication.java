package com.zero.mybaitsplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @Author zero
 * @Description //mybatisplus的启动类需要加上@MapperScan()的注解
 * 括号里面的是Mapper的地址
 * @Date 13:22 2020/5/18
 * @Param
 * @return
**/
@SpringBootApplication
@MapperScan("com.zero.mybaitsplus.mapper")
public class MybaitsplusApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybaitsplusApplication.class, args);
    }

}
