package com.noq.address.repository;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.noq.address.domain.Address;
import com.noq.address.domain.State;

@Repository
public interface AddressRepository extends CrudRepository<Address, String> {

	@Override
	@CacheEvict(value = "address", allEntries = true)
	<S extends Address> S save(S address);

	@Cacheable("address")
	Address findByStreetAddressAndPostcode(String streetAddress, String postcode);

	@Cacheable("address")
	Address findByStreetAddressAndSuburbAndPostcodeAndState(
		String streetAddress,
		String suburb,
		String postcode,
		State state);
}
