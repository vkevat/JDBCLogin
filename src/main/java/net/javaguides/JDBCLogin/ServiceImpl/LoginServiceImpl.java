package net.javaguides.JDBCLogin.ServiceImpl;

import java.security.MessageDigest;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.JDBCLogin.Entity.BaseHeader;
import net.javaguides.JDBCLogin.Entity.CommonHeader;
import net.javaguides.JDBCLogin.Entity.FinalLogin;
import net.javaguides.JDBCLogin.Entity.Login;
import net.javaguides.JDBCLogin.Entity.LoginID;
import net.javaguides.JDBCLogin.Exception.EmptyResultDataAccessException;
import net.javaguides.JDBCLogin.Repository.LoginRepository;
import net.javaguides.JDBCLogin.Service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	LoginRepository repository;
	
	@Override
	public FinalLogin getAllUSer() {
		
		FinalLogin data=new FinalLogin();
		
		CommonHeader header=new CommonHeader();
		header.setMsgId("Please see below user list");
		header.setTimestamp(new Date());
		header.setStatusCode(200);
		header.setStatusDesc("Success");
		data.setHeader(header);
		
		List<Login> login=repository.getAllUser();
		data.setLogin(login);
		
		return data;
	}

	@Override
	public LoginID newUser(Login login) {
		LoginID data=new LoginID();
		int i= repository.newUser(login);
		CommonHeader header=new CommonHeader();
		if(i!=0) {
			header.setMsgId("User Added");
			header.setTimestamp(new Date());
			header.setStatusCode(201);
			header.setStatusDesc("Successful");
			data.setHeader(header);
			Login l=repository.findById(login.getId());
			data.setLogin(l);
		}
		return data;
	}
	
	@Override
	public String encryptData(String password) {
		try {
			
		MessageDigest messageDigest = MessageDigest.getInstance("SHA");
		
		messageDigest.update(password.getBytes());
		
		byte[] resultByteArray = messageDigest.digest();
		
		StringBuilder sb=new StringBuilder();
		
		for(byte b: resultByteArray) {
			sb.append(String.format("%02x", b));
		}
		
		return sb.toString();
		} catch(Exception e) {
			return "";
		}
	}

	@Override
	public LoginID findById(int id) {
		
		LoginID data=new LoginID();
		
		CommonHeader header=new CommonHeader();
		
		try {
			
			header.setMsgId("Please see below requested user");
			header.setTimestamp(new Date());
			header.setStatusCode(200);
			header.setStatusDesc("Success");
			data.setHeader(header);
			
			Login login=repository.findById(id);
			
			data.setLogin(login);
			
			
			} catch(Exception e) {
				
				header.setMsgId("This ID not available");
				header.setTimestamp(new Date());
				header.setStatusCode(404);
				header.setStatusDesc("Unsuccessful");
				data.setHeader(header);
				
				//Login login=null;
				
				//data.setLogin(login);
				
			}
		return data;
	
	}

	@Override
	public BaseHeader validUser(String emailID, String password) {
		System.out.println("Err 2"+emailID+password);
		Login login = repository.validUser(emailID, password);
		//System.out.println("Err 3"+login.getEmailID()+" "+login.getPassword());
		
		BaseHeader data=new BaseHeader();
		CommonHeader header=new CommonHeader();
		if(login==null)
		{
			header.setMsgId("User Invalid");
			header.setTimestamp(new Date());
			header.setStatusCode(404);
			header.setStatusDesc("Unsuccessful");
			data.setHeader(header);
		}
		else
		{
			header.setMsgId("User Valid");
			header.setTimestamp(new Date());
			header.setStatusCode(200);
			header.setStatusDesc("Successful");
			data.setHeader(header);
		}
		
		return data;
	}
	

}
