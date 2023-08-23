package com.tts.introToSpringBoot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts.introToSpringBoot.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{

	Optional<Product> findById(Long id);
	
	Optional<Product> findByProductName(String name);
	
	List<Product> findAll();
	
}
