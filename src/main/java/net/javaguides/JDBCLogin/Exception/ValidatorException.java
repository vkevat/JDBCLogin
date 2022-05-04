package net.javaguides.JDBCLogin.Exception;


public class ValidatorException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8123791612705673590L;
	String msg;

	public ValidatorException(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
