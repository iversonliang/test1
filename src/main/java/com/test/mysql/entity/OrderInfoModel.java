package com.test.mysql.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrderInfoModel {

    /**
     * 订单id
     */
    @ExcelProperty(value = "订单id", index = 0)
    private Long id;

    /**
     * 账期
     */
    @ExcelProperty(value = "账期", index = 1)
    private Integer period;

    /**
     * 账单金额
     */
    @ExcelProperty(value = "账单金额", index = 2)
    private BigDecimal amount;

    /**
     * 下单人
     */
    @ExcelProperty(value = "下单人", index = 3)
    private String userName;

    /**
     * 手机号
     */
    @ExcelProperty(value = "手机号", index = 4)
    private String phone;

    /**
     * 创建时间
     */
    @ExcelProperty(value = "创建时间", index = 5)
    private Date created;

    /**
     * 创建人
     */
    @ExcelProperty(value = "创建人", index = 6)
    private String creator;

    /**
     * 修改时间
     */
    @ExcelProperty(value = "修改时间", index = 7)
    private Date modified;

    /**
     * 修改人
     */
    @ExcelProperty(value = "修改人", index = 8)
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