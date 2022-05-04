package net.javaguides.JDBCLogin.Exception;

import java.util.Date;

public class ErrorApplication {

	private Date date;
	private String msg;
	private String Description;
	
	public ErrorApplication(Date date, String msg, String description) {
		super();
		this.date = date;
		this.msg = msg;
		Description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
	
	
}
