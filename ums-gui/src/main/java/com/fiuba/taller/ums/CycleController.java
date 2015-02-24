package com.fiuba.taller.ums;

public class CycleController {

	private boolean goNextInst;
	private boolean run;

	public boolean isRun() {
		return run;
	}

	public void setRun(boolean run) {
		this.run = run;
	}

	public CycleController() {
		super();
		this.goNextInst = true;
		this.run = false;
	}
	
	public void setGoNextInst(boolean ctrl){
		this.goNextInst = ctrl;		
	}
	
	public boolean getGoNextInst(){
		return this.goNextInst;
	}
	
}
