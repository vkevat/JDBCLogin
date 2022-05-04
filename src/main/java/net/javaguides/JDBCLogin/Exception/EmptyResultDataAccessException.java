package net.javaguides.JDBCLogin.Exception;

public class EmptyResultDataAccessException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -124898413898745891L;
	private String msg;

	public EmptyResultDataAccessException(String msg) {
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
