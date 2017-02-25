package com.noq.address.repository;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;

import com.noq.address.domain.Country;

public interface CountryRepository extends CrudRepository<Country, Integer>{

	@Override
	@CacheEvict(value = "country", allEntries = true)
	<S extends Country> S save(S country);

	@Cacheable("country")
	Country findByName(String name);
}
