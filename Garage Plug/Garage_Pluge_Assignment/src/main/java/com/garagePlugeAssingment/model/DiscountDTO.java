package com.garagePlugeAssingment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DiscountDTO {

	private Integer discountamount;
	
	private Integer customer_Id;
	
	private Integer order_id;
	
	
	
}
