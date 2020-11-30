package com.onlineplatform.rnpdemo1010.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
