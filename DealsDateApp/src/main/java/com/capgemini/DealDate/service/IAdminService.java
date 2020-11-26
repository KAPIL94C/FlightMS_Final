package com.capgemini.DealDate.service;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

import com.capgemini.DealDate.Entity.Order;


public interface IAdminService {
	
	 Order save(Order order);
	 List<Order> fetchAll(); 
	 boolean deleteOrder(Integer orderId);
	

    
}
