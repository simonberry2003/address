package com.noq.address.service;

import com.noq.address.domain.Address;

public interface AddressService {
	Address getOrCreate(Address address);
	Address get(String id);
}
