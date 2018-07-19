package aggregation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.wkfsfrc.ce.Exception.InvalidStatementException;
import operation.aggregation.Sum;

public class SumClassUnitTest {

	private static final double DELTA = 1e-15;
	private Sum sum = new Sum();
	private String stringResult;
	private String stringExpectedResult;
	private double result;
	private double expectedResult;

	@Test
	public void sumTest1() {
		String[] operands = { "3.0", "4.0" };
		sum.setOperands(operands);
		result = sum.getResult();
		expectedResult = 7;
		assertEquals(expectedResult, result, DELTA);
		stringResult = sum.toString();
		stringExpectedResult = "sum(3.0, 4.0) = 7.0";
		assertEquals(stringExpectedResult, stringResult);
	}

	@Test
	public void sumTest2() {
		String[] operands2 = { "3.0", "4.0", "5.0", "6.0" };
		sum.setOperands(operands2);
		result = sum.getResult();
		expectedResult = 18;
		assertEquals(expectedResult, result, DELTA);
		stringResult = sum.toString();
		stringExpectedResult = "sum(3.0, 4.0, 5.0, 6.0) = 18.0";
		assertEquals(stringExpectedResult, stringResult);
	}

	@Test
	public void sumTest3() {
		String[] operands3 = { "-3.0", "4.0", "-2" };
		sum.setOperands(operands3);
		result = sum.getResult();
		expectedResult = -1;
		assertEquals(expectedResult, result, DELTA);
		stringResult = sum.toString();
		stringExpectedResult = "sum(-3.0, 4.0, -2) = -1.0";
		assertEquals(stringExpectedResult, stringResult);

	}

	@Test
	public void sumExceptionTest() {

		String[] operands = {};
		sum.setOperands(operands);
		try {
			sum.wrongNumberOfParameters();
			fail("no thrown execetion from sum unit test");
		} catch (InvalidStatementException e) {
		}

	}

}
