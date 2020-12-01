package com.onlineplatform.rnpdemo1010.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.onlineplatform.rnpdemo1010.entity.User;
import org.springframework.stereotype.Repository;

// create a mapper for mybatis to manipulate user this entity
@Repository
public interface UserMapper extends BaseMapper<User> {
}
