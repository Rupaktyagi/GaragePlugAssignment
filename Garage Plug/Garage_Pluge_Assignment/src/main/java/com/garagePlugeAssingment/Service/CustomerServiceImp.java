package com.garagePlugeAssingment.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.garagePlugeAssingment.Exception.CustomerException;
import com.garagePlugeAssingment.model.Category;
import com.garagePlugeAssingment.model.Customer;
import com.garagePlugeAssingment.model.CustomerDTO;
import com.garagePlugeAssingment.model.DiscountDTO;
import com.garagePlugeAssingment.model.Orders;
import com.garagePlugeAssingment.repository.CustomerRepository;
import com.garagePlugeAssingment.repository.OrderRepository;

@Service
public class CustomerServiceImp implements CustomerService {

	@Autowired
	private CustomerRepository customer_repo;
	
	@Autowired
	private OrderRepository order_repo;
	
	@Override
	public Customer createCustomer(CustomerDTO customer) {
		
		Customer newCustomer=new Customer();
		newCustomer.setFirstname(customer.getFirstname());
		newCustomer.setLastName(customer.getLastname());
		newCustomer.setMobile(customer.getMobile());
		newCustomer.setFirstname(customer.getAddress());
		newCustomer.setCategory(Category.Ragular);
		
		customer_repo.save(newCustomer);
		
		return newCustomer;
	}

	@Override
	public List<Orders> getOrderList(Integer id) throws CustomerException {

		Optional<Customer> Opt_customer=customer_repo.findById(id);
		if(Opt_customer.isEmpty())
		{
			throw new CustomerException("There is no customer with thid id");
		}
		Customer customer =Opt_customer.get();
		Set<Orders> orderset=customer.getOrder_List();
		List<Orders> orderlist=new ArrayList<>(orderset);
		
		return orderlist;
		
		
	}

	@Override
	public List<DiscountDTO> getDiscountDetails(Integer id) throws CustomerException {
		Optional<Customer> Opt_customer=customer_repo.findById(id);
		if(Opt_customer.isEmpty())
		{
			throw new CustomerException("There is no customer with thid id");
		}
		Customer customer =Opt_customer.get();
		List<DiscountDTO> discountDetails=new ArrayList<>();
		for(Orders o:customer.getOrder_List())
		{
			DiscountDTO discount_DetailObj=new DiscountDTO();
			discount_DetailObj.setCustomer_Id(id);
			discount_DetailObj.setOrder_id(o.getOrder_id());
			discount_DetailObj.setDiscountamount(o.getDiscount());
			discountDetails.add(discount_DetailObj);
		}
		
		return discountDetails;
		
	}

	

	
	
}
