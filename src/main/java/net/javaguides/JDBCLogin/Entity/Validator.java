package net.javaguides.JDBCLogin.Entity;

import java.util.Date;

import org.springframework.stereotype.Component;

import net.javaguides.JDBCLogin.Exception.ValidatorException;


public class Validator {

	public LoginID newUserValidation(Login login) {
		
		LoginID data=new LoginID();
		CommonHeader header=new CommonHeader();
		//data=null;
		if(login.getId()==0 || login.getFirstName().equals("") || 
				login.getLastName().equals("") || login.getDob()==null ||
				login.getEmailID().equals("") || login.getPassword().equals("") ||
				login.getNew_password().equals("")) {
			
			
			header.setMsgId("Fields cannot be Empty");
			header.setTimestamp(new Date());
			header.setStatusCode(404);
			header.setStatusDesc("Unsuccessful");
			data.setHeader(header);
			return data;
		}
		else if(!(login.getPassword().equals(login.getNew_password()))) {
			header.setMsgId("Password must be matched");
			header.setTimestamp(new Date());
			header.setStatusCode(404);
			header.setStatusDesc("Unsuccessful");
			data.setHeader(header);
			return data;
		}
//		else if(login.getPassword().length()>10) {
//		
//		}	
		return null;
	}
}
