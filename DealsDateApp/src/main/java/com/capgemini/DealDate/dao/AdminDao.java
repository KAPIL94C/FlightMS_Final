package com.capgemini.DealDate.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.DealDate.Entity.Order;

@Repository
public interface AdminDao extends JpaRepository<Order, Integer> {
	






	
}

