package com.codingcompetition.statefarm;

public class SearchCriteria {

	private Category cat;
	private String value;
	
	
	
	
	
	
	public SearchCriteria(Category cat, String value)
	{
		this.cat = cat;
		this.value = value;
	}






	public Category getCategory() {
		return cat;
	}






	public void setCategory(Category cat) {
		this.cat = cat;
	}






	public String getValue() {
		return value;
	}






	public void setValue(String value) {
		this.value = value;
	}
	
	
	
	
}
