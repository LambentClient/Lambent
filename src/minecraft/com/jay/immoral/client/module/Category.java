package com.jay.immoral.client.module;

public enum Category {

	Combat("Combat"),
	Movement("Movement"),
	Render("Render"),
	World("World"),
	Other("Other");
	
	public String name;
	
	Category(String name) {
		this.name = name;
	}
	
}
