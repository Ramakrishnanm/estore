package com.ofs.estore.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ofs.estore.entity.Product;
import com.ofs.estore.repository.ProductRepository;

@RestController
@RequestMapping("product")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@GetMapping("")
	public List<Product> getAll() {

		return productRepository.findAll().stream().collect(Collectors.toList());
	}
}
