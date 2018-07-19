package operation.aggregation;

import java.util.Arrays;

public class Average extends Aggregation {

	@Override
	public double getResult() {
			return Arrays.stream(this.getOperands()).mapToDouble(Double::parseDouble).average().getAsDouble();
	}

	 @Override
		public boolean checkOperator(String possibleOperator) {
			if(possibleOperator.equals("avg")) {
				return true;
			}
			
			return false;
		}
	@Override
	public String toString() {
		String numbersPlus=String.join(", ", this.getOperands());
		return String.format("avg(" + "%s) = %.1f", numbersPlus, this.getResult());
	}

}
