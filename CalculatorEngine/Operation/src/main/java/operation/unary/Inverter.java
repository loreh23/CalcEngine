package operation.unary;

import com.wkfsfrc.ce.Exception.InvalidStatementException;


public class Inverter extends Unary{

	@Override
	public double getResult() {
		this.setOperand();
		return 1/this.getOperand();
	}

	 @Override
		public boolean checkOperator(String possibleOperator) {
			if(possibleOperator.equals("inv")) {
				return true;
			}
			
			return false;
		}
	@Override
	public String toString() {
		this.setOperand();
		return "inv("+this.getOperand()+") = "+this.getResult();
	}
	
	public void wrongNumberOfParameters() throws InvalidStatementException {
		super.wrongNumberOfParameters();
		this.setOperand();
		if(this.getOperand()==0) {
			throw new InvalidStatementException("invalid statement, you can not divide by 0");
		}
	}

}
