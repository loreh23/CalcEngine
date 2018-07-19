package com.wkfsfrc.ce.AppCore.test.unitTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.Before;
import org.junit.Test;

import com.wkfsfrc.ce.Exception.InvalidStatementException;
import com.wkfsfrc.ce.AppCore.Calculator;

public class CaclulatorClassUnitTest {

	private Calculator calculator=new Calculator();
	private String result;
    private String configFile=".\\configFile.properties";
    private Properties classes=new Properties();
    private InputStream input;
	@Before
	public void initMathOperations() {
		try {
			input= new FileInputStream(configFile);
			classes.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		calculator.setMathOperationsList(classes);
	}
	@Test
	public void myTest1() {
		try {
			calculator.calculate("add 1 2");
		} catch (InvalidStatementException e) {
			e.printStackTrace();
		}
		result=calculator.getResult();
		assertEquals("1.0 + 2.0 = 3.0", result);
	}
	
	public void myTest2() {
		try {
			calculator.calculate("sum 1");
		} catch (InvalidStatementException e) {
			e.printStackTrace();
		}
		result=calculator.getResult();
		assertEquals("sum(1.0) = 1.0", result);	
	}
	public void calculatorExcetionTest() {
		try {
			calculator.calculate("addd 1.0 2.0");
			fail("no thrown execetion from calculator unit test");
		} catch (InvalidStatementException e) {
		}
		try {
			calculator.calculate("subtract 1.0 2.0 3.0");
			fail("no thrown execetion from calculator unit test");
		} catch (InvalidStatementException e) {
		}
		try {
			calculator.calculate("inv");
			fail("no thrown execetion from calculator unit test");
		} catch (InvalidStatementException e) {
		}
	}

}
