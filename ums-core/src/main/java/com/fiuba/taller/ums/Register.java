package com.fiuba.taller.ums;

public class Register {

	private String data;

	public Register() {
		this.data="";
		
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	public void eraseCell(){
		this.setData("");
	};
	

}
