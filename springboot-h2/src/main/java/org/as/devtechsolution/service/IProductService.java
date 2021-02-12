package org.as.devtechsolution.service;

import java.util.List;

import org.as.devtechsolution.dto.ProductDto;
import org.as.devtechsolution.entity.Product;

public interface IProductService {
	
	public List<Product> getAllProduct();
	public List<Product> getAllProductSpecification(ProductDto dto) ;

}
