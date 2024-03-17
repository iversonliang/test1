package com.test.mysql.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserTest implements Serializable {

    private Long id;

    private String userName;

    private String idCard;
}