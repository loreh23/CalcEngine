package binary;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.wkfsfrc.ce.Exception.InvalidStatementException;

import operation.binary.Divide;

public class DivideClassUnitTest {
	private static final double DELTA = 1e-15;
	private Divide divide = new Divide();
	private String stringResult;
	private String stringExpectedResult;
	private double result;
	private double expectedResult;

	@SuppressWarnings("deprecation")
	@Test
	public void divideTest1() {
		String[] operands = { "4.0", "4.0" };
		divide.setOperands(operands);
		result = divide.getResult();
		expectedResult = 1;
		assertEquals(expectedResult, result, DELTA);
		stringResult = divide.toString();
		stringExpectedResult = "4.0 / 4.0 = 1.0";
		assertEquals(stringExpectedResult, stringResult);
	}

	public void divideTest2() {
		String[] operands2 = { "2", "4.0" };
		divide.setOperands(operands2);
		result = divide.getResult();
		expectedResult = 0.5;
		assertEquals(expectedResult, result, DELTA);
		stringResult = divide.toString();
		stringExpectedResult = "2.0 / 4.0 = 0.5";
		assertEquals(stringExpectedResult, stringResult);
	}

	public void divideTest3() {
		String[] operands3 = { "-4", "-2" };
		divide.setOperands(operands3);
		result = divide.getResult();
		expectedResult = 2;
		assertEquals(expectedResult, result, DELTA);
		stringResult = divide.toString();
		stringExpectedResult = "-4.0 / -2.0 = 2.0";
		assertEquals(stringExpectedResult, stringResult);
	}

	@Test
	public void divideExceptionTest() {

		String[] operands = { "3.0", "4.0", "5.0" };
		divide.setOperands(operands);
		try {
			divide.wrongNumberOfParameters();
			fail("no thrown execetion from divide unit test");
		} catch (InvalidStatementException e) {
		}
		String[] operands2 = { "1.0" };
		divide.setOperands(operands2);
		try {
			divide.wrongNumberOfParameters();
			fail("no thrown exception from divide unit test");
		} catch (InvalidStatementException e) {
		}
		String[] operands3 = {};
		divide.setOperands(operands3);
		try {
			divide.wrongNumberOfParameters();
			fail("no thrown exception from divide unit test");
		} catch (InvalidStatementException e) {
		}
		String[] operands4 = { "4.0", "0" };
		divide.setOperands(operands3);
		try {
			divide.wrongNumberOfParameters();
			fail("no thrown exception from divide unit test");
		} catch (InvalidStatementException e) {
		}

	}

}
