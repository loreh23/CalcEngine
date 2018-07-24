package com.wkfsfrc.ce.Exception;

public class InvalidStatementException extends Exception{
	/**
	 * Invalid Statement Exception implementation
	 */
	private static final long serialVersionUID = 1L;

	public InvalidStatementException(String reason) {
		super(reason);
	}
}
