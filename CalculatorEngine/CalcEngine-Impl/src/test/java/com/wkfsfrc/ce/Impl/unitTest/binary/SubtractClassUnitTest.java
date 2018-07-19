package com.wkfsfrc.ce.Impl.unitTest.binary;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.wkfsfrc.ce.Exception.InvalidStatementException;
import com.wkfsfrc.ce.Impl.binary.Subtract;


public class SubtractClassUnitTest {
	private static final double DELTA = 1e-15;
	private Subtract subtract = new Subtract();
	private String stringResult;
	private String stringExpectedResult;
	private double result;
	private double expectedResult;

	@SuppressWarnings("deprecation")
	@Test
	public void subtarctTest1() {
		String[] operands = { "3.0", "4.0" };
		subtract.setOperands(operands);
		result = subtract.getResult();
		expectedResult = -1;
		assertEquals(expectedResult, result, DELTA);
		stringResult = subtract.toString();
		stringExpectedResult = "3.0 - 4.0 = -1.0";
		assertEquals(stringExpectedResult, stringResult);
	}

	@Test
	public void subtractTest2() {
		String[] operands2 = { "8", "4.0" };
		subtract.setOperands(operands2);
		result = subtract.getResult();
		expectedResult = 4;
		assertEquals(expectedResult, result, DELTA);
		stringResult = subtract.toString();
		stringExpectedResult = "8.0 - 4.0 = 4.0";
		assertEquals(stringExpectedResult, stringResult);
	}

	@Test
	public void subtractTest3() {
		String[] operands3 = { "-4", "-2" };
		subtract.setOperands(operands3);
		result = subtract.getResult();
		expectedResult = -2;
		assertEquals(expectedResult, result, DELTA);
		stringResult = subtract.toString();
		stringExpectedResult = "-4.0 - -2.0 = -2.0";
		assertEquals(stringExpectedResult, stringResult);
	}

	

	@Test
	public void subtractExceptionTest() {

		String[] operands = { "3.0", "4.0", "5.0" };
		subtract.setOperands(operands);
		try {
			subtract.wrongNumberOfParameters();
			fail("no thrown execetion from add unit test");
		} catch (InvalidStatementException e) {
		}
		String[] operands2 = { "1.0" };
		subtract.setOperands(operands2);
		try {
			subtract.wrongNumberOfParameters();
			fail("no thrown exception from add unit test");
		} catch (InvalidStatementException e) {
		}
		String[] operands3 = {};
		subtract.setOperands(operands3);
		try {
			subtract.wrongNumberOfParameters();
			fail("no thrown exception from add unit test");
		} catch (InvalidStatementException e) {
		}
	}
}
