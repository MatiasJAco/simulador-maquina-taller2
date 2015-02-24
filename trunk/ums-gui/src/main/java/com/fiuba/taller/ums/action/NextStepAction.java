package com.fiuba.taller.ums.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.fiuba.taller.ums.ControlUnit;
import com.fiuba.taller.ums.CycleController;
import com.fiuba.taller.ums.component.EmulatorComponent;

public class NextStepAction implements ActionListener {

	private EmulatorComponent emulatorComponent;
	private CycleController cicleControl;
	
	public NextStepAction(EmulatorComponent emulatorComponent){
		this.emulatorComponent = emulatorComponent;
		this.cicleControl = emulatorComponent.getCicleControl();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Clean registry and memory background colors to white
		emulatorComponent.cleanGridsColor();
		
		ControlUnit myControlUnit = emulatorComponent.getControlUnit();
//		myControlUnit.fetchInstruction();
//		myControlUnit.decode();
//		myControlUnit.executeCurrentInstruction();
//		
		emulatorComponent.getFetchTextField().setText(myControlUnit.getFetchInstructionRegister());
		emulatorComponent.getDecodeTextField().setText(myControlUnit.getDecodeInstructionRegister());
		emulatorComponent.getExcecutionTextField().setText(myControlUnit.getExecutionInstructionRegister());
		emulatorComponent.getPcTextField().setText(Integer.toString(myControlUnit.getNextInstructionAddress()));
		
		//TODO: esto no se como ponerlo..
		System.out.print("Instruction register:" + myControlUnit.getInstructionRegister() + "\n");
		
		//ALU
		emulatorComponent.getRegAaluTextField().setText(myControlUnit.getAlu().getRegNumSrc1());
		emulatorComponent.getRegBaluTextField().setText(myControlUnit.getAlu().getRegNumSrc2());
		emulatorComponent.getRegRaluTextField().setText(myControlUnit.getAlu().getResult());
		
		emulatorComponent.getBitsLostTextField().setText(Integer.toString(myControlUnit.getAlu().getBitsPrecisionPerdidos()));
		emulatorComponent.getOverflowCheckbox().setEnabled(myControlUnit.getAlu().isOverflow());
		
		
		
			
		synchronized(this.cicleControl){
					this.cicleControl.setInputData(true);			
					this.cicleControl.notify();			
		}
			
		
		
	}

}
