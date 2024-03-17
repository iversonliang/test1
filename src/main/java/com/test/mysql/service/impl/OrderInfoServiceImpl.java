package com.test.mysql.service.impl;

import com.github.pagehelper.PageHelper;
import com.test.mysql.dao.OrderInfoDao;
import com.test.mysql.entity.OrderInfo;

import com.test.mysql.service.OrderInfoService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class OrderInfoServiceImpl implements OrderInfoService {

    private static Random random = new SecureRandom();

    public OrderInfoServiceImpl() {
        System.out.println("init...");
    }

    @Resource
    private OrderInfoDao orderInfoDao;

    private List<String> periodList = Arrays.asList(
            "201909", "201908", "201907", "201906", "201905",
            "202002", "202001", "201912", "201911", "201910",
            "202007", "202006", "202005", "202004", "202003",
            "202012", "202011", "202010", "202009", "202008",

            "202105", "202104", "202103", "202102", "202101",
            "202110", "202109", "202108", "202107", "202106",
            "202203", "202202", "202201", "202112", "202111",
            "202208", "202207", "202206", "202205", "202204"
    );

    /**
     * 导出测试接口  可以测试一下 前后性能差异
     * @param orderInfo
     * @return
     */
    public List<OrderInfo> export(OrderInfo orderInfo) {
        int pageNo = 1;
        int pageSize = 1000;
        if (orderInfo.getPageSize() != null) {
            pageSize = orderInfo.getPageSize();
        }
        List<OrderInfo> result = new ArrayList<>();
        boolean hasNext = true;
        do {
            Integer start = (pageNo - 1) * pageSize;
            List<OrderInfo> orderInfos = orderInfoDao.selectPage(orderInfo.getPeriod(), start, pageSize);
            if (orderInfos != null && orderInfos.size() > 0) {
                result.addAll(orderInfos);
            } else {
                hasNext = false;
            }
            pageNo++;
        } while (hasNext);

        return result;
    }



    @Transactional
    public List<OrderInfo> selectPage(Integer period) {
        PageHelper.startPage(1, 1);
        List<OrderInfo> orderInfos = orderInfoDao.selectPageHelper(period);
        return orderInfos;
    }

    public List<OrderInfo> searchItem(String searchItem) {
        log.info("1111111111");
        List<OrderInfo> orderInfos = orderInfoDao.searchPage(searchItem);
        log.info("22222222222");
        return orderInfos;
    }

    @Override
    public List<OrderInfo> searchItem2(String searchItem) {
        return orderInfoDao.searchPage2(searchItem);
    }

    @Override
    public List<OrderInfo> searchItem3(String searchItem, String searchItemOd) {
        return orderInfoDao.searchPage3(searchItem, searchItemOd);
    }

    @Transactional
    @Override
    public int save(OrderInfo orderInfo) {
        if (orderInfo.getPageSize() == 10) {
            return 0;
        }
        return orderInfoDao.save(orderInfo);
    }

    public int batchSave(List<OrderInfo> orderInfos) {
        return orderInfoDao.batchSave(orderInfos);
    }

    /**
     * 初始化数据  只需要执行一次 执行时 取消注释
     * 执行之后 记得注释上 防止数据量过大
     */
//    @PostConstruct
    public void init() {
        periodList = periodList.stream().sorted().collect(Collectors.toList());

        List<OrderInfo> list = new ArrayList<>(10000);
        for (String s : periodList) {
            for (int i = 0; i < 100000; i++) {
                Date date = generateDate(s);
                String userName = generateName();
                OrderInfo orderInfo = new OrderInfo();
                orderInfo.setPeriod(Integer.valueOf(s));
                orderInfo.setAmount(generateAmount());
                orderInfo.setUserName(userName);
                orderInfo.setPhone(generatePhone());
                orderInfo.setCreated(date);
                orderInfo.setCreator(userName);
                orderInfo.setModified(date);
                orderInfo.setModifier(userName);
                list.add(orderInfo);
                if (list.size() >= 20000) {
                    batchSave(list);
                    list.clear();
                }
            }
            if (list != null && list.size() > 0) {
                batchSave(list);
                list.clear();
            }
        }
    }

    public String generatePhone() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 11; i++) {
            int j = random.nextInt(9) + 1;
            sb.append(j);
        }
        return sb.toString();
    }

    public String generateName() {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 17);
    }


    public BigDecimal generateAmount() {
        int amount = random.nextInt(500000);
        return BigDecimal.valueOf(amount);
    }

    public static Date generateDate(String period) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMM");
        Date from = null;
        try {
            from = dateFormat.parse(period);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int i = 28 * 24 * 60 * 60;
        Long time = Long.valueOf(random.nextInt(i)) * 1000;
        Date result = new Date(from.getTime() + time);
        return result;
    }
}