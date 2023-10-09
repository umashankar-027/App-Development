package com.example.repository;

import java.util.List;

import ch.qos.logback.core.model.Model;

public interface Repository {

	List<Model> findAll();

	void deleteById();

}
