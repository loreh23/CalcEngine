package com.wkfsfrc.ce.AppCore;

import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Properties;

import com.wkfsfrc.ce.Exception.InvalidStatementException;
import com.wkfsfrc.ce.API.MathOperation;

public class Calculator {

	private ArrayList<MathOperation> mathOperationsList;
	private String operator;
	MathOperation theRightMathOperation;
	private String result;
	private String[] operands;

	public MathOperation getMathOperation(String operator) throws InvalidStatementException {
		this.setOperator(operator);
		for (MathOperation mathOperationIterator : mathOperationsList) {
			if (mathOperationIterator.checkOperator(this.operator)) {
				return mathOperationIterator;
			}
		}
		throw new InvalidStatementException("invalid statemnet, wrong operator");
	}

	public void calculate(String lineContent) throws InvalidStatementException {
		this.result = null;
		if (lineContent.contains(" ")) {
			operator = lineContent.substring(0, lineContent.indexOf(" "));
			operands = lineContent.substring(lineContent.indexOf(" ") + 1, lineContent.length()).split(" ");
			this.theRightMathOperation = this.getMathOperation(operator);
			this.theRightMathOperation.setOperands(operands);
			this.theRightMathOperation.wrongNumberOfParameters();
			this.result = this.theRightMathOperation.toString();
		}
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getResult() {
		return this.result;
	}
	

	public ArrayList<MathOperation> getMathOperationsList() {
		return mathOperationsList;
	}

	public void setMathOperationsList(Properties classes) {
		mathOperationsList=new ArrayList<MathOperation>();
		for(Entry<Object, Object> classIterator: classes.entrySet()) {
			this.mathOperationsList.add(createOperator((String)classIterator.getValue()));
		}
	}

	private MathOperation createOperator(String className) {
		Class<?> operatorClass;
		MathOperation mathOperation = null;
		try {
			operatorClass = Class.forName(className);
			mathOperation = (MathOperation) operatorClass.newInstance();
		} catch (ClassNotFoundException e) {
			System.out.println("the "+className +" class was not found");
		}catch (IllegalAccessException e) {
			System.out.println("an instance of the "+className+" could not be created because it Calculator does not have access to it");
		} catch (InstantiationException e) {
			System.out.println("an instance of the "+className+" could not be created");
		} 
		return mathOperation;

	}
	

}
