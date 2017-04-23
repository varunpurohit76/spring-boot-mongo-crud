package com.source.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.source.dao.Customer;
import com.source.dao.CustomerRepository;

@Service
public class AppService {

	@Autowired
	private CustomerRepository customerDao;
	
	@Autowired
	MongoTemplate mongoTemplate;

	@CacheEvict(value = "customer", key = "#p0")
	public void deleteByFirstName(String firstName)
	{
		customerDao.delete(customerDao.findByFirstName(firstName));
	}
	
	public void deleteById(String id)
	{
		customerDao.delete(customerDao.findById(id));
	}
	
	@CachePut(value = "customer", key = "#p0")
	public Customer updateByFirstName(String firstName, String lastName)
	{
		Query query = new Query(Criteria.where("firstName").is(firstName));
        Update update = new Update().set("lastName", lastName);
        Customer result = mongoTemplate.findAndModify(query, update,
                new FindAndModifyOptions().returnNew(true).upsert(false), Customer.class);
        return result;
	}
}
