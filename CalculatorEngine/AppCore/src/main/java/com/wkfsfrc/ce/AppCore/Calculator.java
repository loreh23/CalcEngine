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

	/**
	 * it gets as a parameter a line (eg. "add 1 3.0"), divides it into operator and
	 * operands, theRightMathOperator will get the value of the right operation
	 * according to the operator, we set the operands, we check to see if the
	 * requirements imposed by the class are met and the result parameter gets the
	 * proper result
	 * 
	 * @param lineContent
	 * @throws InvalidStatementException
	 */
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

	/**
	 * as a parameter it recives class Properties, it turns them into instances and
	 * adds them to MathOperationsList primeste ca parametru proprietati
	 * 
	 * @param classes , pe care le transforma in noi instante de clase folosind
	 *                createOperator si le adauga la MathOperationsList
	 */
	public void setMathOperationsList(Properties classes) {
		mathOperationsList = new ArrayList<MathOperation>();
		for (Entry<Object, Object> classIterator : classes.entrySet()) {
			this.mathOperationsList.add(createOperator((String) classIterator.getValue()));
		}
	}

	/**
	 * it gets the fully qualified name of a class and returns a new instance of
	 * that class primeste
	 * 
	 * @param className care este numele intreg al clasei, incluzand pachetul si
	 * @return o noua instanta a clasei ( echivalent cu ex. new Add())
	 */
	private MathOperation createOperator(String className) {
		Class<?> operatorClass;
		MathOperation mathOperation = null;
		try {
			operatorClass = Class.forName(className);
			mathOperation = (MathOperation) operatorClass.newInstance();
		} catch (ClassNotFoundException e) {
			System.out.println("the " + className + " class was not found");
		} catch (IllegalAccessException e) {
			System.out.println("an instance of the " + className
					+ " could not be created because it Calculator does not have access to it");
		} catch (InstantiationException e) {
			System.out.println("an instance of the " + className + " could not be created");
		}
		return mathOperation;

	}

	/**
	 * iterates through the operations from MathOperationsList and checks to see if
	 * the operator matches an operator from a concrete operation class and it
	 * returns that operation itereaza prin instantele de operatii din
	 * MathOperationsList si verifica daca
	 * 
	 * @param operator este egal cu un operatorul dintr-o clasa si
	 * @return acea operatie
	 * @throws InvalidStatementException
	 */
	private MathOperation getMathOperation(String operator) throws InvalidStatementException {
		this.setOperator(operator);
		for (MathOperation mathOperationIterator : mathOperationsList) {
			if (mathOperationIterator.checkOperator(this.operator)) {
				return mathOperationIterator;
			}
		}
		throw new InvalidStatementException("invalid statemnet, wrong operator");
	}

}
