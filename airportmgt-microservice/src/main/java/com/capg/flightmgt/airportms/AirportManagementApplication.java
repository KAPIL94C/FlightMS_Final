package com.capg.flightmgt.airportms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

/**
 * this is equal to three annotations
 * 1) @Configuration
 * 2)@ComponentScan
 * 3)@EnableAutoConfiguration
 */
@SpringBootApplication
@EnableTransactionManagement
@EnableDiscoveryClient
public class AirportManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirportManagementApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

}
