package operation.unary;

import com.wkfsfrc.ce.Exception.InvalidStatementException;
import operation.MathOperation;


public abstract class Unary extends MathOperation {

	private double operand;

	public double getOperand() {
		return operand;
	}

	public void setOperand() {
		this.operand = Double.parseDouble(this.getOperands()[0]);
	}

	@Override
	public void wrongNumberOfParameters() throws InvalidStatementException {
		if (!(this.getOperands().length == 1)) {
			throw new InvalidStatementException("invalid statement, wrong number of parameters");
		}
	}
}
