package com.wkfsfrc.ce.API;

import com.wkfsfrc.ce.Exception.InvalidStatementException;
import com.wkfsfrc.ce.API.MathOperation;

public abstract class Binary extends MathOperation {
	double firstValue, secondfValue;

	public double getFirstValue() {
		return this.firstValue;
	}

	public double getSecondValue() {
		return this.secondfValue;
	}
	public void setValues() {
			this.firstValue=Double.parseDouble(this.getOperands()[0]);
			this.secondfValue=Double.parseDouble(this.getOperands()[1]);
	}
	
	public void wrongNumberOfParameters() throws InvalidStatementException {
		if (!(this.getOperands().length == 2)) {
				throw new InvalidStatementException("invalid statement, wrong number of parameters");	
		}
	}
}
