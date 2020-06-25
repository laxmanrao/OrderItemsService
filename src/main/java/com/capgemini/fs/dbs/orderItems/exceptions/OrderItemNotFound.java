package com.capgemini.fs.dbs.orderItems.exceptions;

public class OrderItemNotFound extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OrderItemNotFound() {
		super();
	}

	public OrderItemNotFound(final String message) {
		super(message);
	}

}
