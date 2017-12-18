package com.shopping.online.products;

public class ProductBracelet extends AbstractProduct {

	// region: Class Initializers
	private ProductBracelet(float cost, String title) {
		super(cost, title);
	}
	
	public static AbstractProduct instance(float cost, String title) {
		
		ProductBracelet product = new ProductBracelet(cost, title);
		return product;
	}

}
