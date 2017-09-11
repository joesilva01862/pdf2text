package com.jsilva.bean;

public class Property {
	private String address;
	private String value;
	private String date;
	private String book;
	private String page;

	// We need to override "equals()" because it will be placed into a List
	// and will be used to check for existence/equality in Junit tests
	public boolean equals(Object obj) {
		Property prop = (Property)obj;
		return ( this.address.equals(prop.getAddress()) &&
				this.value.equals(prop.getValue()) &&
				this.date.equals(prop.getDate()) &&
				this.book.equals(prop.getBook()) &&
				this.page.equals(prop.getPage()));
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getBook() {
		return book;
	}
	public void setBook(String book) {
		this.book = book;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
}
