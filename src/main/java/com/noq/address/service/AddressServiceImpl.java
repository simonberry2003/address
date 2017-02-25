package com.noq.address.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noq.address.domain.Address;
import com.noq.address.repository.AddressRepository;

import lombok.RequiredArgsConstructor;
import lombok.val;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AddressServiceImpl implements AddressService {

	private final AddressRepository addressRepository;

	@Override
	public Address getOrCreate(Address address) {

		val result = addressRepository.findOne(address.getId());
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
	public Address get(String id) {
		return addressRepository.findOne(id);
	}
}
