package com.test.mysql.service;

import com.test.mysql.entity.Address;

import java.util.List;

public interface AddressService {

    boolean addAddress(List<Address> addresses);
}
