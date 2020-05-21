package com.zero.mybaitsplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zero.mybaitsplus.domaim.User;
import com.zero.mybaitsplus.enums.SexEnum;
import com.zero.mybaitsplus.enums.StatusEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author 测试类，下面mapper标红不影响运行
 * @Description //TODO
 * @Date 13:27 2020/5/18
 * @Param
 * @return
**/

@SpringBootTest
class UserMapperTest {

    @Autowired
    private UserMapper mapper;

    /**
     * @Author zero
     * @Description //这个输出方式是java新特性
     * System.out::println
     * @Date 13:28 2020/5/18
     * @Param []
     * @return void
    **/


    //不加任何条件直接查询
    @Test
    void test(){
        mapper.selectList(null).forEach(System.out::println);
       List<User> list =  mapper.selectList(null);
//        for (User a: list) {
//            System.out.println(a);
//        }
        //查询加条件要创建Wrapper的对象，封装查询信息
        //.eq 比较  .lt 小于  .or 或条件
    }

    //条件查询 比较查询 eq.("查询的列","内容")
    @Test
    void QueryEq(){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("name","梦梦奈");
        mapper.selectList(wrapper);
    }

    //条件查询 比较查询 多条件查询 吧把多个条件放到Map集合里 allEq.(map)
    @Test
    void QueryAlleq(){
        QueryWrapper wrapper = new QueryWrapper();
        Map<String,String> map = new HashMap<>();
        map.put("name","梦梦奈");
        map.put("age","14");
        wrapper.allEq(map);
        mapper.selectList(wrapper);
    }

    //条件查询 比较查询 小于  lt.("要比较的列","比较的参数") 查询小于30岁的人
    // .gt  是大于   ge    大于等于
    @Test
    void QueryLt(){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.lt("age","30");
        mapper.selectList(wrapper);
    }

    //条件查询 不等判断 ne("要比较的列","比较的参数") 查找名字不是梦梦奈的用户
    @Test
    void QueryNe(){
        QueryWrapper wrapper = new QueryWrapper();
       wrapper.ne("name","梦梦奈");
        mapper.selectList(wrapper);
    }

    //条件查询 模糊查询 like("要查询的列","模糊查询的参数") 带有小字的都会被查出
    @Test
    void QueryLike(){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.like("name","小");
        mapper.selectList(wrapper);
    }

    //条件查询 模糊查询 likeLeft("要查询的列","模糊查询的参数") likeRight一样
    //相当于 like '%小' 在左边加了个百分号 查询以小结尾的
    @Test
    void QueryLikeLeft(){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.likeLeft("name","小");
        mapper.selectList(wrapper);
    }

    //条件查询 联合查询 inSql("要查询的列","添加的sql语句");  可多个
    @Test
    void QueryIn(){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.inSql("id","select id from user where id > 2");
        wrapper.inSql("name","select name from user where name = '梦梦奈'");
        mapper.selectList(wrapper);
    }

    //条件查询 排序查询 升序 orderByAsc("要排序的列"); 按年龄进行升序
    //having("id > 4"); 可以添加条件，直接写就行
    //orderByDesc("age"); 降序
    @Test
    void QueryOrderByAsc(){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.orderByAsc("age");
        wrapper.having("id > 4");
        mapper.selectList(wrapper).forEach(System.out::println);
    }

    //条件查询 统计查询 selectCount(wrapper); 查询年龄大于10的人数统计
    @Test
    void selectCount(){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.gt("age","10");
        System.out.println(mapper.selectCount(wrapper));
    }

    //id 查询
    @Test
    void SelectById(){
       User user =  mapper.selectById(4);
        System.out.println(user);
    }

    //条件查询 主键查询    selectBatchIds("集合") 查询主键是4,5,6的用户
    @Test
    void SelectBatchIds(){
        mapper.selectBatchIds(Arrays.asList(4,5,6)).forEach(System.out::println);
    }

    //map只能做等值判断，逻辑判断还是要用wrapper
    //条件查询 多条件查询    selectByMap(map)    将查询条件封装到Map集合里 在上班的男性
    @Test
    void SelectByMap() {
        Map<String,Object> map = new HashMap<>();
        map.put("sex",SexEnum.MAN);
        map.put("status", StatusEnum.WORK);
        mapper.selectByMap(map).forEach(System.out::println);
    }

    //条件查询 将查询到的结果集保存到Map集合中   selectMaps(wrapper); 返回的信息也以键值对来返回
    @Test
    void SelectMaps() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.gt("age","10");
        mapper.selectMaps(wrapper).forEach(System.out::println);
    }

    //条件查询 分页查询，开发常用 需要注册分页bean selectPage(page,warpper条件);
    @Test
    void SelectPage() {
        Page<User> page = new Page<>(1,2);
        Page<User> result = mapper.selectPage(page,null);
        System.out.println(result.getSize());//得到每页大小
        System.out.println(result.getTotal());//得到记录数
        result.getRecords().forEach(System.out::println);//得到对象
    }

    //条件查询 分页查询 selectMapsPage(page,条件) 这边返回的分页是以Map的形式返回
    @Test
    void SelectMapsPage() {
        Page<Map<String, Object>> page = new Page<>(1, 2);
        mapper.selectMapsPage(page, null).getRecords().forEach(System.out::println);
    }

    //条件查询 id查询 selectObjs(wrapper) 只会返回一个id集合
    @Test
    void SelectObjs(){
        mapper.selectObjs(null).forEach(System.out::println);
    }

    //条件查询 查询单个 selectOne(wrapper);
    @Test
    void SelectOne(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("id","1");
        mapper.selectOne(wrapper);
    }

    //自定义查询 联合查询 手写SQL 在mapper层，自己看
    @Test
    void SelectPro(){
        mapper.productList(1).forEach(System.out::println);
    }

    //添加测试
    @Test
    void save(){
        User user = new User();
        user.setName("李小明");
        user.setAge(10);
        mapper.insert(user);
    }

    //修改
    @Test
    void update(){
        User user = mapper.selectById(6);
//        user.setName("妹子");
//        user.setSex(SexEnum.WOMAN);
        user.setAge(14);
        mapper.updateById(user);
    }

    //删除 根据id
    @Test
    void deleted(){
        mapper.deleteById(7);
        //删除，根据条件   delete(wrapper条件);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name","111");
        mapper.delete(wrapper);
    }

    //删除 多id deleteBatchIds(Arrays.asList(...)); 传个数组
    @Test
    void deleteIds(){
        mapper.deleteBatchIds(Arrays.asList(1,2,3));
    }

    //删除，吧条件放进Map里面
    @Test
    void deleteByMap(){
        Map<String , Object> map = new HashMap<>();
        map.put("name","111");
        map.put("id","55");
        mapper.deleteByMap(map);
    }

    //修改

}