package com.fiuba.taller.ums;

import java.util.Observable;

public class ObservableOverflow extends Observable {

	private Boolean data;
	
	public ObservableOverflow(Boolean data) {
		setData(data);		
	}

	public Boolean getData() {
		return data;
	}

	public void setData(Boolean data) {
		this.data = data;
		changeData(data);
	}
	
	public void erase(){
		this.setData(false);
	};
		
    void changeData(Object data) {
        setChanged(); // the two methods of Observable class
        notifyObservers(data);
    }


}
