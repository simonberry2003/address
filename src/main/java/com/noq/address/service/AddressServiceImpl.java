package com.noq.address.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noq.address.domain.AddressDomainObject;
import com.noq.address.repository.AddressRepository;

import lombok.RequiredArgsConstructor;
import lombok.val;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AddressServiceImpl implements AddressService {

	private final AddressRepository addressRepository;

	@Override
	public AddressDomainObject getOrCreate(AddressDomainObject address) {

		val result = addressRepository.findByStreetAddressAndPostcode(address.getStreetAddress(), address.getPostcode());
		if (result != null) {
			return result;
		}

		try {
			return addressRepository.save(address);
		} catch (Exception e) {
			return addressRepository.findByStreetAddressAndPostcode(address.getStreetAddress(), address.getPostcode());
		}
	}

	@Override
	public AddressDomainObject get(String id) {
		return addressRepository.findOne(id);
	}
}
