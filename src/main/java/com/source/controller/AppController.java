package com.source.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.source.dao.Customer;
import com.source.entity.Entity;
import com.source.service.AppService;

@RestController
@RequestMapping("/customer")
public class AppController {
	
	@Autowired
	private AppService appService;
	
	@RequestMapping(method = RequestMethod.GET)
    public Collection<Customer> getAllEntities(
    		@RequestParam(value = "firstName", defaultValue = "") String firstName,
    		@RequestParam(value = "lastName", defaultValue = "") String lastName){
        if(!firstName.equals("") && !lastName.equals(""))
        	return appService.findByFirstNameAndLastName(firstName, lastName);
        else if(!firstName.equals(""))
        	return appService.findByFirstName(firstName);
        else if(!lastName.equals(""))
        	return appService.findByLastName(lastName);
        else
        	return appService.getAllEntities();
    }
	
//	@RequestMapping(method = RequestMethod.GET)
//    public Collection<Customer> findByFirstName(@RequestParam(value = "firstName") String firstName ) {
//        return appService.findByFirstName(firstName);
//    }
	
//	@RequestMapping(method = RequestMethod.GET)
//    public Collection<Customer> findByLastName(@RequestParam(value = "lastName") String lastName ) {
//        return appService.findByLastName(lastName);
//    }

}
