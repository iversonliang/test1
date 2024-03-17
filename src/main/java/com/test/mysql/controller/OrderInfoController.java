package com.test.mysql.controller;

import com.alibaba.excel.EasyExcel;
import com.test.mysql.entity.OrderInfo;
import com.test.mysql.entity.OrderInfoModel;
import com.test.mysql.service.OrderInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class OrderInfoController {

    @Resource
    private OrderInfoService orderInfoService;
    
    @PostMapping("/order/export")
    public void exportOrder(@RequestBody OrderInfo orderInfo, HttpServletResponse servletResponse) throws IOException {
        List<OrderInfo> result = orderInfoService.export(orderInfo);
        List<OrderInfoModel> exportList = new ArrayList<>(result.size());
        for (OrderInfo info : result) {
            OrderInfoModel orderInfoModel = new OrderInfoModel();
            BeanUtils.copyProperties(info, orderInfoModel);
            exportList.add(orderInfoModel);
        }

        servletResponse.setContentType("application/vnd.ms-excel");
        servletResponse.setCharacterEncoding("utf-8");
        // 保证下载到本地文件名不乱码的
        String fileName = URLEncoder.encode("模版", "UTF-8");
        servletResponse.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        // List<模型> 的数据体，替换成自己的业务代码即可
        EasyExcel.write(servletResponse.getOutputStream(), OrderInfoModel.class).sheet("sheet").doWrite(exportList);
    }

    @GetMapping("/order/search")
    public List<OrderInfo> searchItem(@RequestParam String searchItem) {
        log.info("search ~~~~~~~~ : {}", orderInfoService);
        try {
            return orderInfoService.searchItem(searchItem);
        } catch (Exception e) {

            log.error("错误信息：" + e.getMessage(), e);
        }
        return null;
    }

    @GetMapping("/order/helper")
    public List<OrderInfo> orderHelper(@RequestParam Integer period) {
        return orderInfoService.selectPage(period);
    }

    @PostMapping("/order/search2")
    public List<OrderInfo> searchItem2(@RequestParam String searchItem) {
        return orderInfoService.searchItem2(searchItem);
    }

    @PostMapping("/order/search3")
    public List<OrderInfo> searchItem3(@RequestParam(required = false) String searchItem, @RequestParam(required = false) String searchItemOd) {
        return orderInfoService.searchItem3(searchItem, searchItemOd);
    }
}
