package com.noq.address.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.noq.address.domain.AddressDomainObject;
import com.noq.address.service.AddressService;
import com.noq.address.web.AddressWebObject;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.val;

@RestController
@RequestMapping("/address")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AddressController {

	private final AddressService addressService;
	private final ModelMapper mapper;

    @ApiOperation(value = "get-or-create", nickname = "get-or-create")
    @RequestMapping(method = POST, value = "/get-or-create", produces = "application/json")
    @ResponseBody
    public ResponseEntity<AddressWebObject> getOrCreate(@RequestBody AddressWebObject request) {
    	val address = mapper.map(request, AddressDomainObject.class);
    	val result = addressService.getOrCreate(address);
    	val response = result == null ? null : mapper.map(result, AddressWebObject.class);
    	return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ApiOperation(value = "get", nickname = "get")
    @RequestMapping(method = GET, value = "/get", produces = "application/json")
    @ResponseBody
    public ResponseEntity<AddressWebObject> get(@RequestParam String id) {
    	val result = addressService.get(id);
    	val response = result == null ? null : mapper.map(result, AddressWebObject.class);
    	return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
