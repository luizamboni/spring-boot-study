package com.example.demo.rest;

import com.example.demo.domain.Any;
import com.example.demo.repositories.ThingsRepository;
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
    	// only to force use of "spring-boot-devtools" changing this var
    	Integer abc = 334;
    	Iterable<Any> things = thingsRepository.findAll();
    	return things;
    }
    
    @RequestMapping("/")
	public String uuuooowwwww() {
		return "uuuooooowwwwww";
	}    
}