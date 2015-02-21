package com.fiuba.taller.ums;

public class CycleController {

	private boolean inputData;

	public CycleController() {
		super();
		this.inputData = true;
	}
	
	public void setInputData(boolean ctrl){
		this.inputData = ctrl;		
	}
	
	public boolean getInputData(){
		return this.inputData;
	}
	
}
