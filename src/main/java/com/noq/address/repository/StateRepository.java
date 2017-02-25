package com.noq.address.repository;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;

import com.noq.address.domain.Country;
import com.noq.address.domain.State;

public interface StateRepository extends CrudRepository<State, Integer>{

	@Override
	@CacheEvict(value = "state", allEntries = true)
	<S extends State> S save(S state);

	@Cacheable("state")
	State findByNameAndCountry(String name, Country country);
}
