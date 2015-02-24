package com.fiuba.taller.ums;

import java.util.Observable;

public class Cell extends Observable {

	private String data;
	
	public Cell(String data) {
		setData(data);		
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
		changeData(data);
	}
	
	public void erase(){
		this.setData("");
	};
		
    void changeData(Object data) {
        setChanged(); // the two methods of Observable class
        notifyObservers(data);
    }


}
