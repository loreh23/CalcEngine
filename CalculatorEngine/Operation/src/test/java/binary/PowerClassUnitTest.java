package binary;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.wkfsfrc.ce.Exception.InvalidStatementException;

import operation.binary.Power;

public class PowerClassUnitTest {

	private static final double DELTA = 1e-15;
	private Power power = new Power();
	private String stringResult;
	private String stringExpectedResult;
	private double result;
	private double expectedResult;

	@SuppressWarnings("deprecation")
	@Test
	public void addTest1() {
		String[] operands = { "3.0", "3.0" };
		power.setOperands(operands);
		result = power.getResult();
		expectedResult = 27;
		assertEquals(expectedResult, result, DELTA);
		stringResult = power.toString();
		stringExpectedResult = "3.0 ^ 3.0 = 27.0";
		assertEquals(stringExpectedResult, stringResult);
	}

	@Test
	public void addTest2() {
		String[] operands2 = { "2", "4.0" };
		power.setOperands(operands2);
		result = power.getResult();
		expectedResult = 16;
		assertEquals(expectedResult, result, DELTA);
		stringResult = power.toString();
		stringExpectedResult = "2.0 ^ 4.0 = 16.0";
		assertEquals(stringExpectedResult, stringResult);
	}

	@Test
	public void addTest3() {
		String[] operands3 = { "-4", "2" };
		power.setOperands(operands3);
		result = power.getResult();
		expectedResult = 16;
		assertEquals(expectedResult, result, DELTA);
		stringResult = power.toString();
		stringExpectedResult = "-4.0 ^ 2.0 = 16.0";
		assertEquals(stringExpectedResult, stringResult);
	}

	@Test
	public void addTest4() {
		String[] operands4 = { "4", "-2" };
		power.setOperands(operands4);
		result = power.getResult();
		System.out.println(result);
		expectedResult = 0.0625;
		assertEquals(expectedResult, result, DELTA);
		stringResult = power.toString();
		stringExpectedResult = "4.0 ^ -2.0 = 0.0625";
		assertEquals(stringExpectedResult, stringResult);
	}

	@Test
	public void powerExceptionTest() {

		String[] operands = { "3.0", "4.0", "5.0" };
		power.setOperands(operands);
		try {
			power.wrongNumberOfParameters();
			fail("no thrown execetion from power unit test");
		} catch (InvalidStatementException e) {
		}
		String[] operands2 = { "1.0" };
		power.setOperands(operands2);
		try {
			power.wrongNumberOfParameters();
			fail("no thrown exception from power unit test");
		} catch (InvalidStatementException e) {
		}
		String[] operands3 = {};
		power.setOperands(operands3);
		try {
			power.wrongNumberOfParameters();
			fail("no thrown exception from power unit test");
		} catch (InvalidStatementException e) {
		}
	}
}
