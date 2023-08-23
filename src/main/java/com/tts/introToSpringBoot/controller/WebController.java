package com.tts.introToSpringBoot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import com.tts.introToSpringBoot.model.Product;
import com.tts.introToSpringBoot.repository.ProductRepository;

@Controller
public class WebController {

	@Autowired
	ProductRepository productRepository;
	
	@GetMapping("/")
	public String home(Model model) {		

		List<Product> products = productRepository.findAll();
		
		model.addAttribute("products", products);
		
		return "index.html";
	}
	
	@GetMapping("/content/{id}")
	public String productInfo(@PathVariable(value="id") Long id, Model model) {
		
		Optional<Product> productById = productRepository.findById(id);
		
		if (productById.isPresent()) {
			Product product = productById.get();
			model.addAttribute("product", product);
		}
		
		return "content.html";
	}
	
	@GetMapping("/addProduct")
	public String newProduct(Model model) {
		
		Product product = new Product();
		model.addAttribute("product", product);
		
		return "addProduct.html";
		
	}
	
	@PostMapping("/product")
	public String addProduct(Product product) {
		productRepository.save(product);
		
		return "addProduct.html";
	}
	
}
