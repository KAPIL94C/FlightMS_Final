package com.capgemini.DealDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.xml.ws.Response;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.capgemini.DealDate.Entity.Order;
import com.capgemini.DealDate.dao.AdminDao;
import com.capgemini.DealDate.service.IAdminService;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest
public class AdminControllerTest {
	
private static final Optional<Order> Order = null;

//	@Autowired
//	private MockMvc mockMvc;	     


	@Autowired
	  private IAdminService repo;
	
	@Autowired
	  private AdminDao repository;

	  @Test
	    public void testSaveNewOrder() {
	       
	               
	        Order savedProduct = repo.save(new Order(1,"success","cash on delivery", 10));
	        
	      //  assertThat(savedProduct.getOrderId()).isGreaterThan(0);
	        assertThat(savedProduct.getOrderId()==1);
	       
	    }
	  
//	  @Test
//	    public void testDeleteOrder() throws Exception{
//	       
//	               
//	        Optional<Order> order = repository.findById(1);
//	        
//	        repository.delete(order.get());
//	        
//	        Optional<Order> deletedProduct = repository.findById(1);
//	         
//	        assertThat(deletedProduct).isNull();   
//	       
//	    }
	  

	  

	

}
