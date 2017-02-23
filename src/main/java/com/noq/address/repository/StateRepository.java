package com.noq.address.repository;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;

import com.noq.address.domain.CountryDomainObject;
import com.noq.address.domain.StateDomainObject;

public interface StateRepository extends CrudRepository<StateDomainObject, Integer>{

	@Override
	@CacheEvict(value = "state", allEntries = true)
	<S extends StateDomainObject> S save(S state);

	@Cacheable("state")
	StateDomainObject findByNameAndCountry(String name, CountryDomainObject country);
}
