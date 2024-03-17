package com.test.mysql.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1542456905641839238L;

    private Long id;

    private String userName;

    private String address;

    private String idCard;

    private Integer created;

    private Integer addressId;

    private Integer isDelete;
}