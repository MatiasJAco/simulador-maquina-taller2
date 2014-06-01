package com.fiuba.taller.ums;

public class Cell {

	private String data;

	public Cell() {
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
