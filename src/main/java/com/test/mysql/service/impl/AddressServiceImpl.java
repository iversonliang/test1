package com.test.mysql.service.impl;

import com.test.mysql.dao.AddressDao;
import com.test.mysql.entity.Address;
import com.test.mysql.service.AddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Resource
    private AddressDao addressDao;


    @Override
    public boolean addAddress(List<Address> addresses) {
        return addressDao.addAddresses(addresses);
    }
}
