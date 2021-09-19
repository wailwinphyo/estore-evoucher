package com.codetest.estoreevoucher.Exception;

public class TokenRefreshException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6236983173186552360L;

	public TokenRefreshException(String token, String message) {
		super(String.format("Failed for [%s]: %s", token, message));
	}
}
