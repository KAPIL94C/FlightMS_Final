package com.capgemini.DealDate.service;

import java.util.List;

import com.capgemini.DealDate.Entity.Order;
import com.capgemini.DealDate.Entity.Product;
import com.capgemini.DealDate.Entity.ProductCategory;

public interface ProductServiceIntf {

	//add products
		public Product addProduct(Product product);
		//show list of categories
		public List<String> showListOfCategories();
		//display all products
		public List<Product> displayListOfProducts();
		//display products based on categories
		public List<Product> displayListOfProductByCategory(ProductCategory category);
		
		public List<Product> getListOfProductsOntheBasisOfProductPriceSortingAsc();
		
		public List<Product> getListOfProductsOntheBasisOfProductPriceSortingDesc();
		
		public Product updateProductSepcification(Product product);
		 List<Product> fetchAll();
		
}
