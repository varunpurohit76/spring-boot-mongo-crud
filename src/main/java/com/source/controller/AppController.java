package com.source.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.source.service.AppService;

@RestController
public class AppController {

	@Autowired
	private AppService appService;

	@RequestMapping(path = "/customer/delete", method = RequestMethod.DELETE)
	public void deleteByFirstName(@RequestParam(value = "firstName") String firstName) {
		appService.deleteByFirstName(firstName);
	}

}
