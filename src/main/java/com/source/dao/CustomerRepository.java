package com.source.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

    public List<Customer> findByFirstName(String firstName);
    public List<Customer> findByLastName(String lastName);
    public List<Customer> findByFirstNameAndLastName(String firstNaame, String LastName);
}