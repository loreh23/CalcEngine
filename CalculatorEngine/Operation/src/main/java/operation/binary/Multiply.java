package operation.binary;

public class Multiply extends Binary {

	@Override
	public double getResult() {
		this.setValues();
		return this.getFirstValue()*this.getSecondValue();
	}

	 @Override
		public boolean checkOperator(String possibleOperator) {
			if(possibleOperator.equals("multiply")) {
				return true;
			}
			if(possibleOperator.equals("*")) {
				return true;
			}
			return false;
		}

	@Override
	public String toString() {
		this.setValues();
		return this.getFirstValue()+" * "+this.getSecondValue()+" = "+this.getResult();
	}

}
