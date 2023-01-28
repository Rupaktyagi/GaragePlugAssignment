package com.garagePlugeAssingment.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customer_id;
	
	private String firstname;
	
	private String lastName;
	
	private String mobile;
	
	private String Address;
	
	private Category category=Category.Ragular;
	
	@OneToMany( fetch = FetchType.LAZY,
	            cascade = CascadeType.ALL)
	private Set<Orders> order_List=new HashSet<>();
	
	
	
	
}
