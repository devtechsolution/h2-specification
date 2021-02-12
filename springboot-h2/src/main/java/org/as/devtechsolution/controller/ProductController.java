package org.as.devtechsolution.controller;

import java.util.List;

import org.as.devtechsolution.dto.ProductDto;
import org.as.devtechsolution.entity.Product;
import org.as.devtechsolution.service.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	
	private IProductService iProductService;

	public ProductController(IProductService iProductService) {
		super();
		this.iProductService = iProductService;
	}
	
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProduct(){
		return new ResponseEntity<List<Product>>(iProductService.getAllProduct(), HttpStatus.FOUND);
	}
	
	
	@PostMapping("/products/specification")
	public ResponseEntity<List<Product>> getAllProducta(@RequestBody ProductDto productDto){
		
		return new ResponseEntity<List<Product>>(iProductService.getAllProductSpecification(productDto), HttpStatus.FOUND);
	}

}
