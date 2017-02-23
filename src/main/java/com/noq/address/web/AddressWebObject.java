package com.noq.address.web;

import lombok.Data;

@Data
public class AddressWebObject {
	private String id;
	private String streetAddress;
	private String suburb;
	private String postcode;
	private String state;
	private String country;
}
