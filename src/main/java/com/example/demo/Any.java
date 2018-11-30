package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Any {
  
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long id;
	private String name;
	
	protected Any() {
		super();
	}
	
	public Any(String name) {
		this();
		this.name = name;
	}
	
	/** without the getter and setters, serializers not will find attributes
	 *  otherwise the attributes must be public (for exemple here, the id)
	 */
//	public Long getId() {
//		return id;
//	}

//	public void setId(Long id) {
//		this.id = id;
//	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
