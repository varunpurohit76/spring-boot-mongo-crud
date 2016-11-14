package com.source.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.source.entity.Entity;

@Repository
public class Dao {

	public static Map<Integer, Entity> Entities;

	static {
		Entities = new HashMap<Integer, Entity>() {
			{
				put(1, new Entity("id-1"));
			}
		};
	}
	
	public Collection<Entity> getEntities () {
		return this.Entities.values();
	}

}