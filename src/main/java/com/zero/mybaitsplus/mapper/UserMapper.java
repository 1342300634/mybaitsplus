package com.zero.mybaitsplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zero.mybaitsplus.domaim.User;
import com.zero.mybaitsplus.vo.ProductVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author zero
 * @Description //mybatisPlus的手动Mapper层，需要继承BaseMapper<T></>的类，
 * 其中的泛型T是该Mapper的实体类对象
 * @Date 13:09 2020/5/18
 * @Param
 * @return
**/
public interface UserMapper extends BaseMapper<User> {

    //手写SQL查询 传进一个id来查询
    @Select("select p.*,u.name userName from product p,user u where p.user_id = u.id and u.id = #{id}")
    List<ProductVO> productList(Integer id);
}
