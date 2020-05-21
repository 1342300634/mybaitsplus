package com.zero.mybaitsplus.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;

/**
 * @Author 枚举的第二种实现方法，实现接口 IEnum<Integer>
 *     需要实现方法返回code
 * 性别的枚举
 * @Description //TODO
 * @Date 15:46 2020/5/19
 * @Param
 * @return
**/
public enum SexEnum implements IEnum<Integer> {
    MAN(1,"男性"),
    WOMAN(0,"女性");

    SexEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Integer code;
    private String msg;

    @Override
    public Integer getValue() {
        return this.code;
    }
}
