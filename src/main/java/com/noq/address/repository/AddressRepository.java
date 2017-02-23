package com.noq.address.repository;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.noq.address.domain.AddressDomainObject;

@Repository
public interface AddressRepository extends CrudRepository<AddressDomainObject, String> {

	@Override
	@CacheEvict(value = "address", allEntries = true)
	<S extends AddressDomainObject> S save(S address);

	@Cacheable("address")
	AddressDomainObject findByStreetAddressAndPostcode(String streetAddress, String postcode);
}
