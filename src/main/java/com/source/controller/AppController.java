package com.source.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.source.entity.Entity;
import com.source.service.AppService;

@RestController
@RequestMapping("/rest")
public class AppController {
	
	@Autowired
	private AppService appService;
	
	@RequestMapping(method = RequestMethod.GET)
    public Collection<Entity> getAllEntities(){
        return appService.getAllEntities();
    }

}
