package com.wkfsfrc.ce.API;

import com.wkfsfrc.ce.Exception.InvalidStatementException;
import com.wkfsfrc.ce.API.MathOperation;


public abstract class Unary extends MathOperation {

	private double operand;

	/**
	 * from the operands list, it sets the operand
	 */
	public void setOperand() {
		this.operand = Double.parseDouble(this.getOperands()[0]);
	}
	/**
	 * checks to see if the operands list does not have exactly one operand
	 */
	@Override
	public void wrongNumberOfParameters() throws InvalidStatementException {
		if (!(this.getOperands().length == 1)) {
			throw new InvalidStatementException("invalid statement, wrong number of parameters");
		}
	}

	public double getOperand() {
		return operand;
	}
}
