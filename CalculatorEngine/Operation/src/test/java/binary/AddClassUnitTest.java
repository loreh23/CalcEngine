package binary;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.wkfsfrc.ce.Exception.InvalidStatementException;

import operation.binary.Add;

@RunWith(JUnit4.class)
public class AddClassUnitTest {
	private static final double DELTA = 1e-15;
	private Add add = new Add();
	private String stringResult;
	private String stringExpectedResult;
	private double result;
	private double expectedResult;
    
	@SuppressWarnings("deprecation")
	@Test
	public void myTest1() {
		String[] operands = { "3.0", "4.0" };
		add.setOperands(operands);
		result = add.getResult();
		expectedResult = 7;
		assertEquals(expectedResult, result, DELTA);
		stringResult = add.toString();
		stringExpectedResult = "3.0 + 4.0 = 7.0";
		assertEquals(stringExpectedResult, stringResult);
	}

	@Test
	public void myTest2() {
		String[] operands2 = { "2", "4.0" };
		add.setOperands(operands2);
		result = add.getResult();
		expectedResult = 6;
		assertEquals(expectedResult, result, DELTA);
		stringResult = add.toString();
		stringExpectedResult = "2.0 + 4.0 = 6.0";
		assertEquals(stringExpectedResult, stringResult);
	}

	@Test
	public void myTest3() {
		String[] operands3 = { "-4", "-2" };
		add.setOperands(operands3);
		result = add.getResult();
		expectedResult = -6;
		assertEquals(expectedResult, result, DELTA);
		stringResult = add.toString();
		stringExpectedResult = "-4.0 + -2.0 = -6.0";
		assertEquals(stringExpectedResult, stringResult);

	}

	@Test
	public void addExceptionTest() {

		String[] operands = { "3.0", "4.0", "5.0" };
		add.setOperands(operands);
		try {
			add.wrongNumberOfParameters();
			fail("no thrown execetion from add unit test");
		} catch (InvalidStatementException e) {
		}
		String[] operands2 = { "1.0" };
		add.setOperands(operands2);
		try {
			add.wrongNumberOfParameters();
			fail("no thrown exception from add unit test");
		} catch (InvalidStatementException e) {
		}
		String[] operands3 = {};
		add.setOperands(operands3);
		try {
			add.wrongNumberOfParameters();
			fail("no thrown exception from add unit test");
		} catch (InvalidStatementException e) {
		}

	}

}
