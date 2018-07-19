package com.wkfsfrc.ce.Impl.aggregation;

import com.wkfsfrc.ce.API.Aggregation;

import java.util.Arrays;

public class Sum extends Aggregation {

	@Override
	public double getResult() {
			return Arrays.stream(this.getOperands()).mapToDouble(Double::parseDouble).sum();
	}

	 @Override
		public boolean checkOperator(String possibleOperator) {
			if(possibleOperator.equals("sum")) {
				return true;
			}
			
			return false;
		}

	@Override
	public String toString() {
		String numbersPlus=String.join(", ", this.getOperands());
		return String.format("sum("+"%s) = %.1f", numbersPlus, this.getResult());
	}

}
