package com.noq.address.domain;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Address")
@Data
@NoArgsConstructor
@Cacheable
public class AddressDomainObject {

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String id;

	private String streetAddress;
	private String suburb;
	private String postcode;

	@ManyToOne
	private StateDomainObject state;

	public String getStateName() {
		return state == null ? null : state.getName();
	}

	public String getCountryName() {
		return state == null ? null : state.getCountryName();
	}
}
