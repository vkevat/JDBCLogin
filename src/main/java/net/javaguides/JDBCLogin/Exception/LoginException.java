package net.javaguides.JDBCLogin.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class LoginException extends RuntimeException{


	/**
	 * 
	 */
	private static final long serialVersionUID = -5699739471136044315L;

	
	private String msg;

	public LoginException(String msg) {
		super();
		this.msg = msg;
	}

	public LoginException() {
	}
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	}
