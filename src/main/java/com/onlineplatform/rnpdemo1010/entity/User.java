package com.onlineplatform.rnpdemo1010.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Getter
@Setter
public class User {

    // configure the method to generate primary key
    @TableId(type = IdType.ID_WORKER) // mp自带策略，生成19位值，数字类型使用这种策略，比如Long
    // @TableId(type = IdType.ID_WORKER_STR) // mp自带策略，生成19位值，字符串用这种策略
    private Long id;
    private String name;
    private Integer age;
    private String email;

    // auto fill when create
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    // auto fill when update
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    // optimized lock
    @Version
    @TableField(fill = FieldFill.INSERT)
    private Integer version;

    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer deleted;
}
