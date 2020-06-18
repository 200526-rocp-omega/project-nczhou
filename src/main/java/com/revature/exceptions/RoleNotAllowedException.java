package com.revature.exceptions;

public class RoleNotAllowedException extends AuthorizationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8216120613659562059L;

	public RoleNotAllowedException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RoleNotAllowedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public RoleNotAllowedException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public RoleNotAllowedException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public RoleNotAllowedException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	
}
