package operation.aggregation;

import com.wkfsfrc.ce.Exception.InvalidStatementException;
import operation.MathOperation;

public abstract class Aggregation extends MathOperation {

	public void wrongNumberOfParameters() throws InvalidStatementException {

		if (this.getOperands().length == 0) {
			throw new InvalidStatementException("wrong number of parameters ");
		}
	}
}
