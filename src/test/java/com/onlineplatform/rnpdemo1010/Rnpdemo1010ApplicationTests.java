package com.onlineplatform.rnpdemo1010;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.onlineplatform.rnpdemo1010.entity.User;
import com.onlineplatform.rnpdemo1010.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class Rnpdemo1010ApplicationTests {

    // query all the data in user
    @Autowired
    private UserMapper userMapper;


    @Test
    public void findAll() {
        System.out.println(("----- selectAll method test ------"));
        //UserMapper 中的 selectList() 方法的参数为 MP 内置的条件封装器 Wrapper
        //所以不填写就是无任何条件
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    public void addUser() {
        User newUser = new User();
        newUser.setName("dd");
        newUser.setAge(24);
        newUser.setEmail("dd@gmail.com");
        int insert = userMapper.insert(newUser);
        System.out.println(insert);
    }

    @Test
    public void testOptimisticLock() {
        User user = userMapper.selectById(1333555759815249921L);
        user.setAge(26);
        int row = userMapper.updateById(user);
        System.out.println(row);
    }

    @Test
    public void updateUser() {
        User updatedUser = new User();
        updatedUser.setId(2L);
        updatedUser.setAge(3); //只需要id的值和要更新的age的值
        int row = userMapper.updateById(updatedUser);
        System.out.println(row);
    }


    @Test
    public void testSelectBatchIds() {
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        users.forEach(System.out::println);
    }

    @Test
    public void testPagination() {
        // 1. 创建page对象
        // 传入两个参数，当前页和每页显示记录数
        Page<User> page = new Page<>(1, 3);
        userMapper.selectPage(page, null);
        System.out.println(page.getCurrent());
        System.out.println(page.getRecords());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());

        System.out.println(page.hasNext());
        System.out.println(page.hasPrevious());
    }

    @Test
    public void testLogicDeletion() {
        int result = userMapper.deleteById(1333575782974464002L);
        System.out.println(("----- deletebyId test ------"));
        System.out.println(result);
    }

    @Test
    public void testComplexQuery() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        // ge、gt、le、lt、isNull、isNotNull: greater/equal greater less/equal less
//        wrapper.ge("age", 20);


        // eq ne: equal and not equal
//        wrapper.eq("name", "george");

        // between
//        wrapper.between("age", 20, 30);

        // like 模糊查询
//        wrapper.like("name", "g");

        // orderBy、orderByDesc、orderByAsc
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);


    }

}
