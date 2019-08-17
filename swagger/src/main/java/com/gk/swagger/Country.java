package com.gk.swagger;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;


public class Country implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2322800529013981201L;
	String value;
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	String data;

	public Country(String name) {
		this.value = name;
		this.data = "";
	}

	

}
