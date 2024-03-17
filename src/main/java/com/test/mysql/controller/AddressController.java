package com.test.mysql.controller;

import com.test.mysql.entity.Address;
import com.test.mysql.service.AddressService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

@RestController
public class AddressController {

    @RequestMapping(path = "/hi1/{name}", method = RequestMethod.GET)
    public String hello1(@PathVariable("name") String name, @RequestParam Boolean isTrue) {
        return name;
    }

    @Resource
    private AddressService addressService;


    //    @PostConstruct
    public void addAddresses() {
        List<Address> addressList = new ArrayList<>();
        Integer i = 0;
        for (i = 0; i < 1_000; i++) {
            Address address = new Address();
            String addressDetail = getRandomString(100);
            Integer created = getRandomInteger();
            address.setAddressDetail(addressDetail);
            address.setCreated(created);
            if (i < 100) {
                address.setIsDelete(1);
            } else {
                address.setIsDelete(i % 2);
            }

            addressList.add(address);
            if (addressList.size() >= 20000) {
                addressService.addAddress(addressList);
                System.out.println("插入批次完成");
                addressList.clear();
            }
        }
        if (addressList.size() > 0) {
            addressService.addAddress(addressList);
        }
        System.out.println("插入完成");
    }

    public static String getRandomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(36);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    public static Integer getRandomInteger() {
        Random random = new Random();
        int max = 500_0000;
        return random.nextInt(max);
    }
}
