package com.javadoterr.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javadoterr.api.enitity.Product;
import com.javadoterr.api.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	//create
	@Transactional
	public Product createProduct(Product product) {
		Product savedProduct = this.productRepository.save(product);
		
		return savedProduct;
	}
	
	//get all products
	public List<Product> getProducts(){
		List<Product> products = this.productRepository.findAll();
		
		return products;
	}
	
	//delete the single product
	@Transactional
	public void deleteProduct(int pid) {
		this.productRepository.deleteById(pid);
	}
	
	//get the single product
	public Product getProduct(int pid) {
		Product product = this.productRepository.findById(pid).get();
		return product;
	}

}
