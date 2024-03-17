package com.test.mysql.service;

import com.test.mysql.entity.OrderInfo;

import java.util.List;

public interface OrderInfoService {

    List<OrderInfo> export(OrderInfo orderInfo);

    List<OrderInfo> selectPage(Integer period);

    List<OrderInfo> searchItem(String searchItem);

    List<OrderInfo> searchItem2(String searchItem);

    List<OrderInfo> searchItem3(String searchItem, String searchItemOd);

    int save(OrderInfo orderInfo);
}
