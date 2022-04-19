package com.javadoterr.api.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.javadoterr.api.enitity.Product;
import com.javadoterr.api.service.ProductService;

@Controller
public class HomeController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping(path = "/")
	public String getHomePage(Model model) {
		
		List<Product> products = this.productService.getProducts();
		model.addAttribute("products", products);
		return "home";
	}
	
	@GetMapping(path = "/add-product")
	public String addProduct(Model model) {
		model.addAttribute("title", "Add Product");
		return "add_product";
	}
	
//	@PostMapping(path = "/handle-product")
//	public String handleProduct(@ModelAttribute Product product) {
//		System.out.println(product);
//		
//		return "add_product";
//	}
	
	@PostMapping(path = "/handle-product")
	public RedirectView handleProduct(@ModelAttribute Product product,
						HttpServletRequest request) {
		this.productService.createProduct(product);
		
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		
		return redirectView;
	}
	
	
	@GetMapping(path = "/delete-product/{id}")
	public RedirectView deleteHandler(@PathVariable("id") int id, HttpServletRequest request) {
		
		this.productService.deleteProduct(id);
		
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		
		return redirectView;
	}
	
	@GetMapping(path = "/update-product/{id}")
	public String updateForm(@PathVariable("id") int id, Model model) {
		
		Product savedProduct = this.productService.getProduct(id);
		
		model.addAttribute("product", savedProduct);
		
		return "update_form";
	}
	
	@PostMapping(path = "/update-product")
	public RedirectView updateHandler(@RequestParam("id")int id,@ModelAttribute Product product,
					HttpServletRequest request) {
		
		Product savedProduct = this.productService.getProduct(id);
		savedProduct.setId(id);
		savedProduct.setName(product.getName());
		savedProduct.setDescription(product.getDescription());
		savedProduct.setPrice(product.getPrice());
		
		this.productService.createProduct(savedProduct);
		
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		
		return redirectView;
		
	}
	
	


}
