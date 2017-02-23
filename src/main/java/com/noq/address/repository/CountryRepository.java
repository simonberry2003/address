package com.noq.address.repository;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;

import com.noq.address.domain.CountryDomainObject;

public interface CountryRepository extends CrudRepository<CountryDomainObject, Integer>{

	@Override
	@CacheEvict(value = "country", allEntries = true)
	<S extends CountryDomainObject> S save(S country);

	@Cacheable("country")
	CountryDomainObject findByName(String name);
}
