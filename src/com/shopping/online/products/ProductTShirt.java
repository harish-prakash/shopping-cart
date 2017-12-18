package com.shopping.online.products;

public class ProductTShirt extends AbstractProduct {

	// region: Class Initializers
	private ProductTShirt(float cost, String title) {
		super(cost, title);
	}
	
	public static AbstractProduct instance(float cost, String title) {
		
		ProductTShirt product = new ProductTShirt(cost, title);
		return product;
	}

}
