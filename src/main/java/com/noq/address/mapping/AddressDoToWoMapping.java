package com.noq.address.mapping;

import org.modelmapper.PropertyMap;

import com.noq.address.domain.AddressDomainObject;
import com.noq.address.web.AddressWebObject;

public class AddressDoToWoMapping extends PropertyMap<AddressDomainObject, AddressWebObject> {

	@Override
	protected void configure() {
		map().setState(source.getStateName());
		map().setCountry(source.getCountryName());
	}
}
