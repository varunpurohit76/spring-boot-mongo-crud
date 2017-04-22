package com.source.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.source.dao.Customer;
import com.source.dao.CustomerRepository;

@Service
public class AppService {

	@Autowired
	private CustomerRepository customerDao;

	public Collection<Customer> getAllEntities() {
		return customerDao.findAll();
	}

	public Collection<Customer> findByFirstName(String firstName) {
		return customerDao.findByFirstName(firstName);
	}

	public Collection<Customer> findByLastName(String lastName) {
		return customerDao.findByLastName(lastName);
	}
	
	public Collection<Customer> findByFirstNameAndLastName(String firstName, String lastName) {
		return customerDao.findByFirstNameAndLastName(firstName, lastName);
	}
}
