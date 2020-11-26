package com.capgemini.DealDate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.DealDate.Entity.Order;
import com.capgemini.DealDate.Entity.Product;
import com.capgemini.DealDate.Entity.ProductCategory;
import com.capgemini.DealDate.dao.ProductDao;
import com.capgemini.DealDate.exception.ProductNotFoundException;

@Service
public class ProductServiceImpl implements ProductServiceIntf {

	@Autowired
	private ProductDao repo;
	@Override
	public Product addProduct(Product product) {
		return repo.save(product);
	}

	@Override
	public List<String> showListOfCategories() {
		return repo.findListOfCategories();
	}

	@Override
	public List<Product> displayListOfProducts() {
		return repo.findAll();
	}

	@Override
	public List<Product> displayListOfProductByCategory(ProductCategory category) {
		return repo.findListofProductsByCategories(category);
	}

	@Override
	public List<Product> getListOfProductsOntheBasisOfProductPriceSortingAsc() {
		return repo.findByOrderByProductPriceAsc();
	}

	@Override
	public List<Product> getListOfProductsOntheBasisOfProductPriceSortingDesc() {
		return repo.findByOrderByProductPriceDesc();
	}
	
	 public Product updateProductSepcification(Product product) {
	        
	    	boolean exists =repo.existsById(product.getProductId());
	    	if(!exists) {
	    		 throw new ProductNotFoundException("product  not found for id=" + product.getProductId());
	    	}
	    	product = repo.save(product);
	        return product;
	    }
	 @Override
		public List<Product> fetchAll() {
			List<Product> product = repo.findAll();
			return product;
		}

}
