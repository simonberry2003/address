package com.noq.address.domain;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.noq.jpa.Hashable;
import com.noq.jpa.Md5IdGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Address")
@Data
@NoArgsConstructor
@Cacheable
public class Address implements Hashable {

	@Id
	@GenericGenerator(name = "md5_hash", strategy = "com.noq.jpa.Md5IdGenerator")
	@GeneratedValue(generator = "md5_hash")
	private String id;

	private String streetAddress;
	private String suburb;
	private String postcode;

	@ManyToOne
	private State state;

	public String getStateName() {
		return state.getName();
	}

	public String getCountryName() {
		return state.getCountryName();
	}

	public String getId() {
		if (id == null) {
			id = Md5IdGenerator.generate(this);
		}
		return id;
	}

	@Override
	public String getHash() {
		return streetAddress + suburb + postcode + state.getHash();
	}
}
