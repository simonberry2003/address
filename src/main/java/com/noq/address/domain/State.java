package com.noq.address.domain;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.noq.jpa.Hashable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "State")
@Data
@NoArgsConstructor
@Cacheable
public class State implements Hashable {

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String id;
	private String name;
	private String description;

	@ManyToOne
	private Country country;

	public String getCountryName() {
		return country.getName();
	}

	@Override
	public String getHashString() {
		return name + country.getHashString();
	}
}
