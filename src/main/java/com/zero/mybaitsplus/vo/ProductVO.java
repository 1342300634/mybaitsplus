package com.zero.mybaitsplus.vo;

import lombok.Data;

/**
 * @Author chengpunan
 * @Description //mybatisPlus的联合查询，可以结合VO来用
 * 这里是联合user表和Product表的VO
 * 想要联合查出user表的name和id
 * @Date 10:20 2020/5/20
 * @Param
 * @return
**/
@Data
public class ProductVO {
    private Integer category;
    private Integer count;
    private String description;
    private Integer userId;
    //user表的name，他映射在手写mapper时完成 在mapper层
    private String username;
}
