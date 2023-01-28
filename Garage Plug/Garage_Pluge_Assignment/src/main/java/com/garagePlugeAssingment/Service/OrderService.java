package com.garagePlugeAssingment.Service;

import com.garagePlugeAssingment.Exception.CustomerException;

public interface OrderService {

	
	public void createOrder(Integer id,Integer totalorderAmount)throws CustomerException;
	
	
}
