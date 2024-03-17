package com.test.mysql.dao;


import com.test.mysql.entity.OrderInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderInfoDao {

    int save(OrderInfo orderInfo);

    int batchSave(@Param("orderInfos") List<OrderInfo> orderInfos);

    List<OrderInfo> selectPage(@Param("period")Integer period, @Param("start") Integer start, @Param("count") Integer count);

    List<OrderInfo> selectPageHelper(@Param("period")Integer period);

    List<OrderInfo> searchPage(@Param("searchItem")String searchItem);

    List<OrderInfo> searchPage2(@Param("searchItem")String searchItem);

    List<OrderInfo> searchPage3(@Param("searchItem")String searchItem, @Param("searchItemOd")String searchItemOd);
}
