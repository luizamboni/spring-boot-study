package com.example.demo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

// Entity is Any and primaryKey is a long ?
public interface ThingsRepository extends CrudRepository<Any, Long> {

    List<Any> findByName(String name);

}