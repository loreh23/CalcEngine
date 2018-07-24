package com.wkfsfrc.ce.API;

import com.wkfsfrc.ce.Exception.InvalidStatementException;

public abstract class MathOperation {
	
	private String[] operands;
	private double result;
	private String operator;
	
	public abstract double getResult();
	/**checks to see if possibleOperator matches a certain operator (eg. if(pO.equals("inv"))
	 * it returns true if it does, false if it does not 
	 * verifica daca 
	 * @param possibleOperator este egal cu un anumit operator (ex. if(pO.equals("inv"))
	 * @return true daca este egal, false daca nu este
	 */
	public abstract boolean checkOperator(String possibleOperator);
	/**
	 * returns the full result, that will be put in output.txt
	 * returneaza stringul care urmeaza sa fie pus in output.txt
	 */
	public abstract String toString();
	/**
	 * this method will be implemented with by classes, with their proper requirements
	 * metoda care este implementeaza cerintele fiecarei operatii
	 * @throws InvalidStatementException
	 */
	public abstract void wrongNumberOfParameters() throws InvalidStatementException;
	
	public String[] getOperands() {
		return operands;
	}
	public void setOperands(String[] operands) {
		this.operands = operands;
	}
	public void setResult(double result) {
		this.result = result;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	
}
