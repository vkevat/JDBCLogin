package net.javaguides.JDBCLogin.Entity;

import java.util.Date;

public class CommonHeader {
	
	private String msgId;
	private Date timestamp;
	private Integer statusCode;
	private String statusDesc;
	
	public String getMsgId() {
		return msgId;
	}
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date date) {
		this.timestamp = date;
	}
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusDesc() {
		return statusDesc;
	}
	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}
	
	

}
