package com.source.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.source.dao.Customer;
import com.source.service.AppService;

@RestController
public class AppController {

	@Autowired
	private AppService appService;

	@RequestMapping(path = "/customer/delete", method = RequestMethod.DELETE)
	public void deleteByFirstName(@RequestParam(value = "firstName") String firstName) {
		appService.deleteByFirstName(firstName);
	}
	
	@RequestMapping(path = "/customer/update/{firstName}", method = RequestMethod.PUT)
	public Customer updateByFirstName(@PathVariable(value = "firstName") String firstName, @RequestBody Map<String, Object> payload) {
		return appService.updateByFirstName(firstName, (String) payload.get("lastName"));
	}
}
