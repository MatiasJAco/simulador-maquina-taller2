package com.fiuba.taller.ums.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.fiuba.taller.ums.ControlUnit;
import com.fiuba.taller.ums.CycleController;
import com.fiuba.taller.ums.component.EmulatorComponent;

public class RunAction implements ActionListener {

	private EmulatorComponent emulatorComponent;
	private CycleController cicleControl;

	public RunAction(EmulatorComponent emulatorComponent){
		this.emulatorComponent = emulatorComponent;
		this.cicleControl = this.emulatorComponent.getCicleControl();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		synchronized(this.cicleControl){
			this.cicleControl.setRun(true);
			this.cicleControl.setGoNextInst(true);
			this.cicleControl.notify();			
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ControlUnit myControlUnit = emulatorComponent.getControlUnit();
		emulatorComponent.getFetchTextField().setText(myControlUnit.getFetchInstructionRegister());
		emulatorComponent.getDecodeTextField().setText(myControlUnit.getDecodeInstructionRegister());
		emulatorComponent.getExcecutionTextField().setText(myControlUnit.getExecutionInstructionRegister());
		emulatorComponent.getPcTextField().setText(Integer.toString(myControlUnit.getNextInstructionAddress()));


	}

}
