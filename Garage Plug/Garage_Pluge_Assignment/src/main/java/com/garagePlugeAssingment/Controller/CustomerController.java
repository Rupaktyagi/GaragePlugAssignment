package com.garagePlugeAssingment.Controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.garagePlugeAssingment.Exception.CustomerException;
import com.garagePlugeAssingment.Service.CustomerServiceImp;
import com.garagePlugeAssingment.Service.OrderServiceImpl;
import com.garagePlugeAssingment.model.Customer;
import com.garagePlugeAssingment.model.CustomerDTO;
import com.garagePlugeAssingment.model.DiscountDTO;
import com.garagePlugeAssingment.model.Orders;



@RestController
@RequestMapping("/Customer")
public class CustomerController {

	@Autowired
	private CustomerServiceImp customer_service;
	
	@Autowired
	private OrderServiceImpl order_service;
	
	@PostMapping("/register")
	public ResponseEntity<Customer> registerCustomerHandler(@RequestBody CustomerDTO customerDto){
		
		Customer customer=customer_service.createCustomer(customerDto);
		return new ResponseEntity<Customer>(customer,HttpStatus.CREATED);
	}
	
	
	@PostMapping("/order/{id}")
	public void createOrderHandler(@PathVariable("id")Integer id,@RequestParam Integer totalAmount) throws CustomerException{
		
		order_service.createOrder(id, totalAmount);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<List<Orders>> getorderListHandler(@PathVariable("id") Integer id) throws CustomerException{
		
		List<Orders> orderlist=customer_service.getOrderList(id);
		
		return new ResponseEntity<List<Orders>>(orderlist,HttpStatus.OK);
	}
	
	@GetMapping("/dicount/{id}")
	public ResponseEntity<List<DiscountDTO>> getDiscountDetailsHandler(@PathVariable("id") Integer id) throws CustomerException{
		
		List<DiscountDTO> discountdeatils=customer_service.getDiscountDetails(id);
		
		return new ResponseEntity<List<DiscountDTO>>(discountdeatils,HttpStatus.OK);
	}
	
	
	
	
}
