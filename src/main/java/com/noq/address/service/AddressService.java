package com.noq.address.service;

import com.noq.address.domain.AddressDomainObject;

public interface AddressService {
	AddressDomainObject getOrCreate(AddressDomainObject address);
	AddressDomainObject get(String id);
}
