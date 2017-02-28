package com.noq.address.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.noq.address.domain.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, String> {
}
