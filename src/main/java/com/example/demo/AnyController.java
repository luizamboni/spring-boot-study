package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@RestController
public class AnyController {
 
	@Autowired
	private ThingsRepository thingsRepository;
	
	
    @RequestMapping(
	  value = "/any", 
	  produces = { "application/json", "application/xml" }, 
	  method = RequestMethod.GET
    )
    public Any any() {
    	Any any = new Any("nightmare");
        return any;
    }

    @RequestMapping(
	  value = "/things", 
	  produces = { "application/json", "application/xml" }, 
	  method = RequestMethod.GET
    )
    

    public Iterable<Any> things() {

    	Iterable<Any> things = thingsRepository.findAll();
    	
    	return things;
    }
    
    @RequestMapping("/")
	public String uuuooowwwww() {
		return "uuuooooowwwwww";
	}    
}