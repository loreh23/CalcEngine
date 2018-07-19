package binary;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.wkfsfrc.ce.Exception.InvalidStatementException;

import operation.binary.Multiply;

public class MultiplyClassUnitTest {

	private static final double DELTA = 1e-15;
	private Multiply multiply = new Multiply();
	private String stringResult;
	private String stringExpectedResult;
	private double result;
	private double expectedResult;

	@SuppressWarnings("deprecation")
	@Test
	public void multiplyTest1() {
		String[] operands = { "3.0", "4.0" };
		multiply.setOperands(operands);
		result = multiply.getResult();
		expectedResult = 12;
		assertEquals(expectedResult, result, DELTA);
		stringResult = multiply.toString();
		stringExpectedResult = "3.0 * 4.0 = 12.0";
		assertEquals(stringExpectedResult, stringResult);
	}

	@Test
	public void multiplyTest2() {
		String[] operands2 = { "5", "4.0" };
		multiply.setOperands(operands2);
		result = multiply.getResult();
		expectedResult = 20;
		assertEquals(expectedResult, result, DELTA);
		stringResult = multiply.toString();
		stringExpectedResult = "5.0 * 4.0 = 20.0";
		assertEquals(stringExpectedResult, stringResult);
	}

	@Test
	public void multiplyTest3() {
		String[] operands3 = { "-4", "-2" };
		multiply.setOperands(operands3);
		result = multiply.getResult();
		expectedResult = 8;
		assertEquals(expectedResult, result, DELTA);
		stringResult = multiply.toString();
		stringExpectedResult = "-4.0 * -2.0 = 8.0";
		assertEquals(stringExpectedResult, stringResult);
	}



	@Test
	public void multiplyExceptionTest() {

		String[] operands = { "3.0", "4.0", "5.0" };
		multiply.setOperands(operands);
		try {
			multiply.wrongNumberOfParameters();
			fail("no thrown execetion from multiply unit test");
		} catch (InvalidStatementException e) {
		}
		String[] operands2 = { "1.0" };
		multiply.setOperands(operands2);
		try {
			multiply.wrongNumberOfParameters();
			fail("no thrown exception from multiply unit test");
		} catch (InvalidStatementException e) {
		}
		String[] operands3 = {};
		multiply.setOperands(operands3);
		try {
			multiply.wrongNumberOfParameters();
			fail("no thrown exception from multiply unit test");
		} catch (InvalidStatementException e) {
		}
	}
}
