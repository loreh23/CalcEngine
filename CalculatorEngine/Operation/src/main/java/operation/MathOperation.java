package operation;

import com.wkfsfrc.ce.Exception.InvalidStatementException;

public abstract class MathOperation {
	
	private String[] operands;
	private double result;
	private String operator;
	
	public abstract double getResult();
	
	public abstract boolean checkOperator(String possibleOperator);
	public abstract String toString();
	public abstract void wrongNumberOfParameters() throws InvalidStatementException;
	
	public String[] getOperands() {
		return operands;
	}
	public void setOperands(String[] operands) {
		this.operands = operands;
	}
	public void setResult(double result) {
		this.result = result;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	
}
