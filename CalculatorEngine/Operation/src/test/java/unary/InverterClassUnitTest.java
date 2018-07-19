package unary;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.wkfsfrc.ce.Exception.InvalidStatementException;
import operation.unary.Inverter;

public class InverterClassUnitTest {

	private static final double DELTA = 1e-15;
	Inverter inverter = new Inverter();
	String stringResult;
	String stringExpectedResult;
	double result;
	double expectedResult;

	@Test
	public void inverterTest1() {
		String[] operand = { "2" };
		inverter.setOperands(operand);
		result = inverter.getResult();
		expectedResult = 0.5;
		assertEquals(expectedResult, result, DELTA);
		stringResult = inverter.toString();
		stringExpectedResult = "inv(2.0) = 0.5";
		assertEquals(stringExpectedResult, stringResult);
	}

	@Test
	public void inverterTest2() {
		String[] operand2 = { "-4" };
		inverter.setOperands(operand2);
		result = inverter.getResult();
		expectedResult = -0.25;
		assertEquals(expectedResult, result, DELTA);
		stringResult = inverter.toString();
		stringExpectedResult = "inv(-4.0) = -0.25";
		assertEquals(stringExpectedResult, stringResult);
	}

	@Test
	public void inverterExceptionTest() {

		String[] operands = { "3.0", "4.0", "5.0" };
		inverter.setOperands(operands);
		try {
			inverter.wrongNumberOfParameters();
			fail("no thrown exception from inverter unit test");
		} catch (InvalidStatementException e) {
		}
		String[] operands3 = {};
		inverter.setOperands(operands3);
		try {
			inverter.wrongNumberOfParameters();
			fail("no thrown exception from inverter unit test");
		} catch (InvalidStatementException e) {
		}
	}

}
