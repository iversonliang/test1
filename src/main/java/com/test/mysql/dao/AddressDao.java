package com.test.mysql.dao;

import com.test.mysql.entity.Address;

import java.util.List;

public interface AddressDao {

    boolean addAddresses(List<Address> addresses);
}
