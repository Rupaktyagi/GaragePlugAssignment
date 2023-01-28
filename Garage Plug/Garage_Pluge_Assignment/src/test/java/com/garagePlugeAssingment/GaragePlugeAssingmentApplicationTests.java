package com.garagePlugeAssingment;

import java.time.LocalDate;
import java.util.Optional;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import com.garagePlugeAssingment.Exception.CustomerException;
import com.garagePlugeAssingment.Service.CustomerServiceImp;
import com.garagePlugeAssingment.Service.OrderServiceImpl;
import com.garagePlugeAssingment.model.Category;
import com.garagePlugeAssingment.model.Customer;
import com.garagePlugeAssingment.model.CustomerDTO;
import com.garagePlugeAssingment.model.Orders;
import com.garagePlugeAssingment.repository.CustomerRepository;
import com.garagePlugeAssingment.repository.OrderRepository;


@SpringBootTest
class GaragePlugeAssingmentApplicationTests {

	@Autowired
	private CustomerServiceImp customer_service;
	
	@Autowired
	private OrderServiceImpl order_service;
	
	@MockBean
	private CustomerRepository customer_repo;
	
	@MockBean
	private OrderRepository order_repo;
	
	Customer customer;
	Orders order;  
	
	@BeforeEach
	public void setUpCustomer() {
	customer =new Customer(1, "rupak", "tyagi", "1234567891", "Bijnor", Category.Ragular,null);
	}
	
	@BeforeEach
	public void setupOrder() {
		
		order=new Orders(1, LocalDate.now(), 100, customer, 10);
		
	}
	
	@AfterEach
	public void tearDownOrder() {
		order=null;
	}
	
	@AfterEach
	public void tearDownCustomer() {
		customer=null;
	}
	
	@Test
	void contextLoads() {
	}
	
	@Test
	@DisplayName("JUnit test for create Customer operation")
	public void givenCustomerobject_whensaveCustomer_ThenReturnCustomerObject() {
		
		given(customer_repo.findById(customer.getCustomer_id())).willReturn(Optional.empty());
		given(customer_repo.save(customer)).willReturn(customer);
		CustomerDTO customerdto=new CustomerDTO("rupak", "tyagi", "1234567899", "Bijnor");
		
		Customer saveCustomer=customer_service.createCustomer(customerdto);
		assertThat(saveCustomer).isNotNull();
	}

	
	@Test
	@DisplayName("JUnit test for create order operation")
	public void givenOrderObject_whensaveOrder_ThenReturnOrderObject() {
		
		given(order_repo.findById(order.getOrder_id())).willReturn(Optional.empty());
		given(order_repo.save(order)).willReturn(order);
		
		try {
			order_service.createOrder(1, 100);
			
		} catch (CustomerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	

}
