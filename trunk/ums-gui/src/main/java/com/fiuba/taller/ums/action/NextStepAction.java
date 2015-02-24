package com.fiuba.taller.ums.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.fiuba.taller.ums.ControlUnit;
import com.fiuba.taller.ums.EmulatorComponent;

public class NextStepAction implements ActionListener {

	private EmulatorComponent emulatorComponent;
	
	public NextStepAction(EmulatorComponent emulatorComponent){
		this.emulatorComponent = emulatorComponent;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Clean registry and memory background colors to white
		emulatorComponent.cleanGridsColor();
		
		ControlUnit myControlUnit = emulatorComponent.getControlUnit();
		myControlUnit.fetchInstruction();
		myControlUnit.decode();
		myControlUnit.executeCurrentInstruction();
		
		emulatorComponent.getFetchTextField().setText(myControlUnit.getFetchInstructionRegister());
		emulatorComponent.getDecodeTextField().setText(myControlUnit.getDecodeInstructionRegister());
		emulatorComponent.getPcTextField().setText(Integer.toString(myControlUnit.getNextInstructionAddress()));
		
		//TODO: esto no se como ponerlo..
		System.out.print("Instruction register:" + myControlUnit.getInstructionRegister() + "\n");
		
		//ALU
		emulatorComponent.getRegAaluTextField().setText(myControlUnit.getAlu().getRegNumSrc1());
		emulatorComponent.getRegBaluTextField().setText(myControlUnit.getAlu().getRegNumSrc2());
		emulatorComponent.getRegRaluTextField().setText(myControlUnit.getAlu().getResult());
		
		emulatorComponent.getBitsLostTextField().setText(Integer.toString(myControlUnit.getAlu().getBitsPrecisionPerdidos()));
		emulatorComponent.getOverflowCheckbox().setEnabled(myControlUnit.getAlu().isOverflow());
		
	}

}
