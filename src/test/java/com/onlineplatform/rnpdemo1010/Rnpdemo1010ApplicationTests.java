package com.onlineplatform.rnpdemo1010;

import com.onlineplatform.rnpdemo1010.entity.User;
import com.onlineplatform.rnpdemo1010.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
        newUser.setName("lucy");
        newUser.setAge(12);
        newUser.setEmail("lucy@gmail.com");
        int insert = userMapper.insert(newUser);
        System.out.println(insert);
    }

}
