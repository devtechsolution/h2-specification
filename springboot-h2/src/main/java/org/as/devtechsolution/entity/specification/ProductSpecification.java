package org.as.devtechsolution.entity.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.as.devtechsolution.dto.ProductDto;
import org.as.devtechsolution.entity.Product;
import org.as.devtechsolution.entity.Product_;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

//@Service
public class ProductSpecification implements Specification<Product>{
	
	private ProductDto filter;
	
	
	
	public ProductSpecification(ProductDto filter) {
		super();
		this.filter = filter;
	}
	
	

//	public static Specification<Product> hasColor(String color){
//		return ((root, criteriaquery,criteriaBuilder)-> {
//			return criteriaBuilder.equal(root.get(Product_.COLOR), color);
//		});
//	}
//	
//	public static Specification<Product> hasBrand(String brand){
//		return ((root, criteriaquery,criteriaBuilder)-> {
//			return criteriaBuilder.equal(root.get(Product_.BRAND), brand);
//		});
//	}
//	public static Specification<Product> hasSize(Integer size){
//		return ((root, criteriaquery,criteriaBuilder)-> {
//			return criteriaBuilder.equal(root.get(Product_.SIZE), size);
//		});
//	}



	@Override
	public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		//root.fetch("")
		List<Predicate> finalPredicate= new ArrayList<>();
		if(filter.getBrand()!=null && !filter.getBrand().isEmpty()) {
			finalPredicate.add(cb.equal(root.get("brand"), filter.getBrand()));
		}
		if(filter.getCategory()!=null && !filter.getCategory().isEmpty()) {
			finalPredicate.add(cb.equal(root.get("category"), filter.getCategory()));
		}
		if(filter.getPrice()!=null ) {
			finalPredicate.add(cb.equal(root.get("price"), filter.getPrice()));
		}
		if(filter.getColor()!=null && !filter.getColor().isEmpty()) {
			finalPredicate.add(cb.equal(root.get("color"), filter.getColor()));
		}
		if(filter.getSize()!=null ) {
			finalPredicate.add(cb.greaterThan(root.get("size"), filter.getSize()));
		}
		query.distinct(true);
		Predicate and= cb.and(finalPredicate.toArray(new Predicate[finalPredicate.size()]));
		
		return and;
	}

}
