package com.test.mysql.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrderInfo {

    /**
     * 订单id
     */
    private Long id;

    /**
     * 账期
     */
    private Integer period;

    /**
     * 账单金额
     */
    private BigDecimal amount;

    /**
     * 下单人
     */
    private String userName;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 创建时间
     */
    private Date created;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 修改时间
     */
    private Date modified;

    /**
     * 修改人
     */
    private String modifier;

    /**
     * 页码
     */
    private Integer pageNo;

    /**
     * 每页数量
     */
    private Integer pageSize;
}