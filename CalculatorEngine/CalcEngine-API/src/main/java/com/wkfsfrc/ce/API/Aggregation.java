package com.wkfsfrc.ce.API;

import com.wkfsfrc.ce.Exception.InvalidStatementException;
import com.wkfsfrc.ce.API.MathOperation;

public abstract class Aggregation extends MathOperation {

	public void wrongNumberOfParameters() throws InvalidStatementException {

		if (this.getOperands().length == 0) {
			throw new InvalidStatementException("wrong number of parameters ");
		}
	}
}
