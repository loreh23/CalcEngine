package com.wkfsfrc.ce.Impl.unitTest.aggregation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import com.wkfsfrc.ce.Exception.InvalidStatementException;
import com.wkfsfrc.ce.Impl.aggregation.Average;

public class AverageClassUnitTest {

	private static final double DELTA = 1e-15;
	private Average average = new Average();
	private String stringResult;
	private String stringExpectedResult;
	private double result;
	private double expectedResult;

	@Test
	public void averageTest1() {
		String[] operands = { "3.0", "4.0" };
		average.setOperands(operands);
		result = average.getResult();
		expectedResult = 3.5;
		assertEquals(expectedResult, result, DELTA);
		stringResult = average.toString();
		stringExpectedResult = "avg(3.0, 4.0) = 3.5";
		assertEquals(stringExpectedResult, stringResult);
	}

	@Test
	public void averageTest2() {
		String[] operands2 = { "3.0", "4.0", "5.0", "6.0" };
		average.setOperands(operands2);
		result = average.getResult();
		expectedResult = 4.5;
		assertEquals(expectedResult, result, DELTA);
		stringResult = average.toString();
		stringExpectedResult = "avg(3.0, 4.0, 5.0, 6.0) = 4.5";
		assertEquals(stringExpectedResult, stringResult);
	}

	@Test
	public void averageTest3() {
		String[] operands3 = { "-3.0", "4.0", "-10" };
		average.setOperands(operands3);
		result = average.getResult();
		expectedResult = -3;
		assertEquals(expectedResult, result, DELTA);
		stringResult = average.toString();
		stringExpectedResult = "avg(-3.0, 4.0, -10) = -3.0";
		assertEquals(stringExpectedResult, stringResult);

	}

	@Test
	public void averageExceptionTest() {

		String[] operands = {};
		average.setOperands(operands);
		try {
			average.wrongNumberOfParameters();
			fail("no thrown execetion from sum unit test");
		} catch (InvalidStatementException e) {
		}

	}

}
