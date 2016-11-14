package com.source.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.source.dao.Dao;
import com.source.entity.Entity;

@Service
public class AppService {
	
	@Autowired
	private Dao dao;
	
	public Collection<Entity> getAllEntities() {
		return dao.getEntities();
	}

}
