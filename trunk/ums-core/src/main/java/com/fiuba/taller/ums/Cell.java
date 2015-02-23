package com.fiuba.taller.ums;

import java.util.Observer;

public class Cell {

	private String data;
	private MessageObservable observable = new MessageObservable();
	
	public Cell() {
		setData("00");		
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
		observable.changeData(data);
	}
	
	public void eraseCell(){
		this.setData("");
	};
	
	public void addOberver(Observer observer){
		observable.addObserver(observer);
	}

}
