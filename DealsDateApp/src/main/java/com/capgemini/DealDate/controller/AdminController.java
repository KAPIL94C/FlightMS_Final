package com.capgemini.DealDate.controller;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.capgemini.DealDate.Entity.Order;
import com.capgemini.DealDate.Entity.Product;
import com.capgemini.DealDate.Entity.ProductCategory;
import com.capgemini.DealDate.service.IAdminService;
import com.capgemini.DealDate.service.ProductServiceIntf;

/*
@author  TRIPATHI
*/
@RestController
@RequestMapping("/admin")
public class AdminController {

    



	@Autowired
    private IAdminService adminService;

    @Autowired
    private ProductServiceIntf productService;
    
    
	/* view all orders details */
    
    @GetMapping
    public ResponseEntity<List<Order>> fetchAll() {
        List<Order>  orders = adminService.fetchAll();
        ResponseEntity<List<Order>> response = new ResponseEntity<>(orders, HttpStatus.OK);
        return response;
    }
    
    
    @PostMapping("/addOrder")
    public ResponseEntity<Order> addOrder(@RequestBody Order order) {
         order = adminService.save(order);
         ResponseEntity<Order> response = new ResponseEntity<>(order, HttpStatus.OK);
         return response;
    }
    
	/* for deleting the order by orderid */
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteOrder(@PathVariable("id") Integer id) {
        boolean result = adminService.deleteOrder(id.intValue());
        ResponseEntity respose = new ResponseEntity(result, HttpStatus.OK);
        return respose;
        
    }
    
	/* for updating the product specifications */
    
    @PutMapping("/update/{productId}")
    public ResponseEntity<Boolean> updateOrder(@RequestBody Product requestData, @PathVariable int productId) {
    	                     requestData.setProductId(productId);
          				
    	                     productService.updateProductSepcification(requestData);
        	ResponseEntity  response = new ResponseEntity(true, HttpStatus.OK);
    		return response;
    }
    
/* view all products details */
    
    @GetMapping("/products")
    public ResponseEntity<List<Product>> fetchAllProduct() {
        List<Product>  products = productService.fetchAll();
        ResponseEntity<List<Product>> response = new ResponseEntity<>(products, HttpStatus.OK);
        return response;
    }
    
    
    
	/* adding order objects for testing */ 
    @PostConstruct
    void addOrder(){
    	Order o1 = new Order();
    	Order o2 = new Order();
    	LocalDate dt = LocalDate.parse("2020-11-01"); 
    	o1.setOrderStatus("Success");
    	o1.setPaymentMethod("online");
    	o1.setOrderQuantity(2);
    	adminService.save(o1);
    	LocalDate dt2 = LocalDate.parse("2020-11-06");    
    	o2.setOrderStatus("Success");
    	o2.setPaymentMethod("Cash on Delivery");
    	o2.setOrderQuantity(3);
    	adminService.save(o2);
    }
    
    @PostConstruct
    void addProduct() {
    	Product p1 = new Product();
    	p1.setProductName("Nike");
    	p1.setProductColor("blue");
    	p1.setProductCategory(ProductCategory.FASHION_STYLE);
    	p1.setProductPrice(2000);
    	p1.setProductQuantity(1);
    	p1.setProductSpecification("xyz");
    	productService.addProduct(p1);
    	
    }
   
    
//    @PostMapping("/add")
//    public ResponseEntity<Order> addProduct(@RequestBody Order order) {
//         order = adminService.save(order);
//         ResponseEntity<Order> response = new ResponseEntity<>(order, HttpStatus.OK);
//         return response;
//    }
  
    
//	/* view order details */
//    
//    Order fetchOrderById(int id) {
//        String url = orderProductServiceBaseUrl + "/get/" + id;
//        Order order = restTemplate.getForObject(url, Order.class);
//        return order;
//    }
//    
//    List<Object> fetchAllOrder() {
//        String url = orderProductServiceBaseUrl + "/get/";
//        Object[] orders = restTemplate.getForObject(url, Object[].class);
//        return Arrays.asList(orders);
//    }
//    


}
