package com.source.dao;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "customer", path = "customer")
public interface CustomerRepository extends MongoRepository<Customer, String> {

	@Cacheable(value = "customer", key = "#p0")
	public Customer findByFirstName(@Param("firstName") String firstName);
	public Customer findByLastName(@Param("lastName") String lastName);
	public Customer findById(@Param("id") String id); 
	public Customer findByFirstNameAndLastName(@Param("firstName") String firstNaame, @Param("lastName") String LastName);
}