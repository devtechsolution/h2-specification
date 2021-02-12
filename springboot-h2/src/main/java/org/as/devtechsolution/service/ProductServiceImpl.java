package org.as.devtechsolution.service;

import java.util.List;

import org.as.devtechsolution.dto.ProductDto;
import org.as.devtechsolution.entity.Product;
import org.as.devtechsolution.entity.specification.ProductSpecification;
import org.as.devtechsolution.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IProductService {

	private ProductRepository productRepo;



	public ProductServiceImpl(ProductRepository productRepo) {
		super();
		this.productRepo = productRepo;
	}



	@Override
	public List<Product> getAllProduct() {

		return productRepo.findAll();
	}
	@Override
	public List<Product> getAllProductSpecification(ProductDto dto) {

		List<Product> findAll = productRepo.findAll(new ProductSpecification(dto));

		return findAll;
	}

}
