package com.test.mysql.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Address implements Serializable {
    private static final long serialVersionUID = -3592252486350081239L;

    private Long id;

    private String addressDetail;

    private Integer created;

    private Integer isDelete;
}
