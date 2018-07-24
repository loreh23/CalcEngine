package com.wkfsfrc.ce.API;

import com.wkfsfrc.ce.Exception.InvalidStatementException;
import com.wkfsfrc.ce.API.MathOperation;

public abstract class Binary extends MathOperation {
	double firstValue, secondfValue;

	/**
	 * it sets the operands from the operands list as firstValue and secondValue
	 */
	public void setValues() {
			this.firstValue=Double.parseDouble(this.getOperands()[0]);
			this.secondfValue=Double.parseDouble(this.getOperands()[1]);
	}
	/** 
	 * checks to see if the list does not have 2 operands
	 */
	public void wrongNumberOfParameters() throws InvalidStatementException {
		if (!(this.getOperands().length == 2)) {
				throw new InvalidStatementException("invalid statement, wrong number of parameters");	
		}
	}
	public double getFirstValue() {
		return this.firstValue;
	}

	public double getSecondValue() {
		return this.secondfValue;
	}
}
