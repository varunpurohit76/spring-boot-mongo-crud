package com.source.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "customer", path = "customer")
public interface CustomerRepository extends MongoRepository<Customer, String> {

    public List<Customer> findByFirstName(@Param("firstName") String firstName);
    public List<Customer> findByLastName(@Param("lastName") String lastName);
    public List<Customer> findByFirstNameAndLastName(@Param("firstName") String firstNaame, @Param("lastName") String LastName);
}