package com.wkfsfrc.ce.Impl.binary;

import com.wkfsfrc.ce.API.Binary;

import com.wkfsfrc.ce.Exception.InvalidStatementException;

public class Divide extends Binary{

	@Override
	public double getResult() {
		this.setValues();
		return this.getFirstValue() / this.getSecondValue();
	}

	 @Override
		public boolean checkOperator(String possibleOperator) {
			if(possibleOperator.equals("divide")) {
				return true;
			}
			if(possibleOperator.equals("/")) {
				return true;
			}
			return false;
		}
	@Override
	public String toString() {
		this.setValues();
		return this.getFirstValue() + " / " + this.getSecondValue() + " = " + this.getResult();
	}
	/** 
	 * verifica daca lista de operanzi.length == 2 si al doilea operand nu este 0
	 */
	public void wrongNumberOfParameters() throws InvalidStatementException {
		super.wrongNumberOfParameters();
		this.setValues();
		if(this.getSecondValue()==0) {
			throw new InvalidStatementException("invalid statement, you can not divide by 0");
		}
	}

}
