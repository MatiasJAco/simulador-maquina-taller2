package com.fiuba.taller.ums;

public class ALU {

	boolean overflow;

	public ALU() {
		// TODO Auto-generated constructor stub
		this.overflow = false;
	}

	public boolean isOverflow() {
		return overflow;
	}

	public void setOverflow(boolean overflow) {
		this.overflow = overflow;
	}

	public boolean isZeroReg(int i) {
		if (i == 0)
			return true;
		else
			return false;

	}

}
