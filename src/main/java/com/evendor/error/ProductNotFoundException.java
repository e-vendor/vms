package com.evendor.error;

public class ProductNotFoundException extends RuntimeException {

	public ProductNotFoundException(String exception) {
		super(exception);
	}

}
