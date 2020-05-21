package com.zero.mybaitsplus.handle;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author zero
 * @Description //自动添加时间的处理器
 * 自动填充时间处理器
 * 需要实现接口MetaObjectHandler，并且实现方法
 * 需要数据库中有时间字段 createTime updateTime
 * metaObject 传输对象
 * 记得添加注解 @Component
 * @Date 9:48 2020/5/19
 * @Param
 * @return
**/
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
   //第一次添加
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createTime",new Date(),metaObject);
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }
    //更新
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }
}
