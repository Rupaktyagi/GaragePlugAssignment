package com.garagePlugeAssingment.Service;

import java.util.List;
import java.util.Set;

import com.garagePlugeAssingment.Exception.CustomerException;
import com.garagePlugeAssingment.model.Customer;
import com.garagePlugeAssingment.model.CustomerDTO;
import com.garagePlugeAssingment.model.DiscountDTO;
import com.garagePlugeAssingment.model.Orders;


public interface CustomerService {

	public Customer createCustomer(CustomerDTO  customer);
	
	public List<Orders> getOrderList(Integer id)throws CustomerException;
	
	public List<DiscountDTO> getDiscountDetails(Integer id)throws CustomerException;
	
	
	
}
