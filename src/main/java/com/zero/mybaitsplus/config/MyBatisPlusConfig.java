package com.zero.mybaitsplus.config;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author zero
 * @Description //MybatisPlus的配置类
 * @Date 14:20 2020/5/19
 * @Param
 * @return
**/
@Configuration
public class MyBatisPlusConfig {

    //乐观锁version的配置类
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor(){
        return new OptimisticLockerInterceptor();
    }

    //mybatisPlus分页的配置类 拦截器 返回一个逻辑处理对象
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return  new PaginationInterceptor();
    }

}
