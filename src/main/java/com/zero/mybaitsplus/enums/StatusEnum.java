package com.zero.mybaitsplus.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * @Author zero
 * @Description //枚举类型
 * 枚举类型通常两个参数，一个int类型，一个String类型 ，用来描述状态
 * 当数据库返回1，就可以显示上班
 * @Date 15:10 2020/5/19
 * @Param
 * @return
**/
public enum StatusEnum {
    //以;为结尾，其中用，分割
    WORK(1,"上班"),
    REST(0,"休息");


    StatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    //让mybatisPlus读取到枚举
    @EnumValue
    private Integer code;
    private String msg;
}
