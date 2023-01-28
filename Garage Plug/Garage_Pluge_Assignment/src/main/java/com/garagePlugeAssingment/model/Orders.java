package com.garagePlugeAssingment.model;

import java.time.LocalDate;




import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer order_id;
	
	private LocalDate date_Order;
	
	private Integer total_Amount;
	
	@ManyToOne
	private Customer customer;
	
	private Integer discount; 
}
