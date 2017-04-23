package com.source.dao;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="customer")
public class Customer implements Serializable{

    @Id
    public String id;
    
    public String firstName;
    public String lastName;

}

