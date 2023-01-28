package com.garagePlugeAssingment.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.garagePlugeAssingment.Exception.CustomerException;
import com.garagePlugeAssingment.model.Category;
import com.garagePlugeAssingment.model.Customer;
import com.garagePlugeAssingment.model.Orders;
import com.garagePlugeAssingment.repository.CustomerRepository;
import com.garagePlugeAssingment.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private CustomerRepository customer_repo;
	
	@Autowired
	private OrderRepository order_repo;

	@Override
	public void createOrder(Integer id, Integer totalorderAmount) throws CustomerException {
       
		Optional<Customer> Opt_customer=customer_repo.findById(id);
		if(Opt_customer.isEmpty())
		{
			throw new CustomerException("There is no customer with thid id");
		}
		Customer customer =Opt_customer.get();
        Set<Orders> orderlist=customer.getOrder_List();
        int Discount= checkDiscount(customer);
         Orders order =new Orders();
         
         order.setCustomer(customer);
         order.setDate_Order(LocalDate.now());
         order.setTotal_Amount(totalorderAmount);
         if(Discount==0)
         {
        	 order.setDiscount(0);
         }else if(Discount==10)
         {
        	 int discountamount=(int) (totalorderAmount*0.1);
        	 order.setDiscount(discountamount);
         }else {
        	 int discountamount=(int) (totalorderAmount*0.2);
        	 order.setDiscount(discountamount);
         }
         orderlist.add(order);
         customer.setOrder_List(orderlist);
         order_repo.save(order);
         customer_repo.save(customer);
		if(orderlist.size()==9)
		{
			sendMail();
		}
	}
	
	
	public void sendMail() {
		System.out.println("You have placed 9 orders with us. Buy one more stuff and you will be promoted to Gold customer and enjoy 10% discounts!");
		}
	
	   public Integer checkDiscount(Customer customer) {
		   
		   if(customer.getCategory().equals(Category.Ragular))
		   {
			   return 0;
		   }
		   else if(customer.getCategory().equals(Category.Gold)){
			   return 10;
			   
		   }else {
			   return 20;
		   }
		   
	   }

	
	
	
	
}
