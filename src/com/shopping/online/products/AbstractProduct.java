package com.shopping.online.products;

import java.util.HashMap;

public abstract class AbstractProduct {
	
	protected float cost;
	protected String title;
	protected String description;
	protected String manufacturer;
	protected HashMap<String, String> otherInformation;
	
	//region: Class Initializers
	protected AbstractProduct(float cost, String title) {
		
		this.cost = cost;
		this.title = title;
		
		this.otherInformation = new HashMap<String, String>();		
	}
	
	//region: Getters and setters
	public float getCost() {
		return cost;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	public String getInformation(String label) {
		return otherInformation.get(label);
	}
	
	public String setInformation(String label, String details) {
		return otherInformation.put(label, details);
	}
}
