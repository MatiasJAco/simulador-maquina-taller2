package com.fiuba.taller.ums.action;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

import com.fiuba.taller.ums.ControlUnit;
import com.fiuba.taller.ums.CycleController;
import com.fiuba.taller.ums.component.EmulatorComponent;

public class NextStepAction implements ActionListener {
	public static Color GREEN_COLOR = new Color(144,245,0);
	public static Color WHITE_COLOR = new Color(255, 255, 255);
	private EmulatorComponent emulatorComponent;
	private CycleController cicleControl;

	public NextStepAction(EmulatorComponent emulatorComponent){
		this.emulatorComponent = emulatorComponent;
		this.cicleControl = emulatorComponent.getCicleControl();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		synchronized(this.cicleControl){
			this.cicleControl.setGoNextInst(true);			
			this.cicleControl.notify();			
		}
		
		
		// Clean registry and memory background colors to white
		emulatorComponent.cleanGridsColor();
		cleanAluRegsColor();

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
//		System.out.print("Instruction register:" + myControlUnit.getInstructionRegister() + "\n");

		//ALU

		if(emulatorComponent.getExcecutionTextField().getText().length()>0){
			String typeOfInst = ""+emulatorComponent.getExcecutionTextField().getText().charAt(0);
			if(typeOfInst.contains("5") || typeOfInst.contains("6") || typeOfInst.contains("7") || typeOfInst.contains("8") || typeOfInst.contains("9")|| typeOfInst.contains("A")){
				//Pintar casillas de ALU				
				emulatorComponent.getRegAaluTextField().setBackground(GREEN_COLOR);
				emulatorComponent.getRegBaluTextField().setBackground(GREEN_COLOR);
				emulatorComponent.getRegRaluTextField().setBackground(GREEN_COLOR);
				
			}
		}
		emulatorComponent.getRegAaluTextField().setText(myControlUnit.getAlu().getRegNumSrc1());
		emulatorComponent.getRegBaluTextField().setText(myControlUnit.getAlu().getRegNumSrc2());
		emulatorComponent.getRegRaluTextField().setText(myControlUnit.getAlu().getResult());

		emulatorComponent.getBitsLostTextField().setText(Integer.toString(myControlUnit.getAlu().getBitsPrecisionPerdidos()));
		emulatorComponent.getOverflowCheckbox().setEnabled(myControlUnit.getAlu().isOverflow());




		



	}

	private void cleanAluRegsColor() {
		emulatorComponent.getRegAaluTextField().setBackground(WHITE_COLOR);
		emulatorComponent.getRegBaluTextField().setBackground(WHITE_COLOR);
		emulatorComponent.getRegRaluTextField().setBackground(WHITE_COLOR);
		
	}

}
