package com.capgemini.fs.dbs.orderItems.exceptions;

public class UnableToCreateOrderItem extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UnableToCreateOrderItem() {
		super();
	}

	public UnableToCreateOrderItem(String message) {
		super(message);
	}
}
