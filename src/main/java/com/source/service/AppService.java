package com.source.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.source.dao.CustomerRepository;

@Service
public class AppService {

	@Autowired
	private CustomerRepository customerDao;

	public void deleteByFirstName(String firstName)
	{
		customerDao.delete(customerDao.findByFirstName(firstName));
	}
}
