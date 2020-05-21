package com.zero.mybaitsplus.domaim;

import com.baomidou.mybatisplus.annotation.*;
import com.zero.mybaitsplus.enums.SexEnum;
import com.zero.mybaitsplus.enums.StatusEnum;
import lombok.Data;

import java.util.Date;

/**
 * @Author zero
 * @Description //可用到的mybatis的注解
 * 1.@TableName(value = "表名") 类名不对应表名时使用
 * 2.@TableId(value="") 设置主键的生成策略，8种，常用的5种
 *      value:主键名字不一样的时候使用
 * 3. @TableField(value = "数据库列名",select = false)
 *     value 属性名不对应列名的时候使用
 *     select 表示是否查询该字段
 * 3.1 @TableField(exist = false)
 *      exist 表示是否为数据库字段 false，
 *      如果实体类中的成员变量在数据库中没有对应的字段，
 *      则可以使用 exist，VO、DTO  添加了后会忽略本部查询这字段
 * 3.2  @TableField(fill = FieldFill.INSERT)
 *      fill 表示是否自动填充，将对象存入数据库的时候，
 *      由 MyBatis Plus 自动给某些字段赋值，
 *      create_time、update_time，可用于自动添加时间和修改时间
 * 4. @Version 标记乐观锁，通过version字段来保证数据的安全性，
 *      修改数据的时候会以version作为条件，条件成立的时候才会修改成功
 *      使用version需要添加配置类
 *      保证多个请求执行的时候数据的安全性，不让多个请求同时修改数据
 *      version成功后加一，其他的请求version条件就不成立了
 * 5. @TableLogic   逻辑删除 数据库也添加相应字段，设置默认为0
 *      yml也要配置逻辑删除的信息
 *      删除之后数据库并不会实际删除这信息
 * @Date 9:07 2020/5/19
 * @Param
 * @return
**/
@Data
//@TableName(value = "user")
public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;
//    @TableField(value = "name")
    private String name;
    private Integer age;
    //无关字段 测试注解用
    @TableField(exist = false)
    private String shabi;
    //添加时间 创建时间
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    //修改时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    //乐观锁
    @Version
    private Integer version;
    //枚举类型测试 这里的变量名status一定要和数据库对应
    private StatusEnum status;
    //第二种枚举方法测试 实现接口 性别的枚举
    private SexEnum sex;
    //逻辑删除！
    @TableLogic
    private Integer deleted;
}
