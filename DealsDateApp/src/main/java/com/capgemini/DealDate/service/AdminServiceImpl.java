package com.capgemini.DealDate.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.DealDate.Entity.Order;
import com.capgemini.DealDate.dao.AdminDao;
import com.capgemini.DealDate.exception.OrderNotFoundException;


@Service
@Transactional
public class AdminServiceImpl implements IAdminService {

    @Autowired
    private AdminDao adminDao;
    
    
    @Override
    public Order save(Order order) {
    	order = adminDao.save(order);
        return order;
    }

	@Override
	public List<Order> fetchAll() {
		List<Order> orders = adminDao.findAll();
		return orders;
	}

	@Override
	public boolean deleteOrder(Integer orderId) {
		 Optional<Order> optional = adminDao.findById(orderId.intValue());   
	     if(optional.isPresent()) {
	    	 adminDao.deleteById(orderId);
			    return true;
	    }
	     throw new OrderNotFoundException("order not found for id=" + orderId);
	
	}

	

	
	}

 

