package net.javaguides.JDBCLogin.LoginController;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.JDBCLogin.Entity.BaseHeader;
import net.javaguides.JDBCLogin.Entity.CommonHeader;
import net.javaguides.JDBCLogin.Entity.FinalLogin;
import net.javaguides.JDBCLogin.Entity.Login;
import net.javaguides.JDBCLogin.Entity.LoginID;
import net.javaguides.JDBCLogin.Entity.Validator;
import net.javaguides.JDBCLogin.Exception.EmptyResultDataAccessException;
import net.javaguides.JDBCLogin.ServiceImpl.LoginServiceImpl;

@RestController
@RequestMapping("/fblogin")
public class LoginController {

	@Autowired
	LoginServiceImpl service;
	
	@GetMapping
	public FinalLogin getAllUser(){
		return service.getAllUSer();
	}
	
	@PostMapping
	public ResponseEntity<LoginID> newUser(@RequestBody Login login) {
		LoginID l=new LoginID();
		Validator v=new Validator();
		l=v.newUserValidation(login);
		if(l!=null) {			
		return new ResponseEntity<LoginID>(l,HttpStatus.NOT_FOUND);
		}
		String str=service.encryptData(login.getPassword());
		login.setPassword(str);
		login.setNew_password(str);
		l=service.newUser(login);
		return new ResponseEntity<LoginID>(l,HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<LoginID> findById(@PathVariable("id") int id) {
		//ResponseEntity<LoginID> l= new ResponseEntity<LoginID>(service.findById(id), HttpStatus.CREATED);
		LoginID l=service.findById(id);
		if(l.getLogin()!=null) {
			return new ResponseEntity<LoginID>(l, HttpStatus.CREATED);
		}
		return new ResponseEntity<LoginID>(l, HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/login")
	public ResponseEntity<BaseHeader> validUser(@RequestBody Login login) {
		System.out.println("Err 1"+login.getEmailID()+login.getPassword());
		String str=service.encryptData(login.getPassword());
		login.setPassword(str);
		BaseHeader b=service.validUser(login.getEmailID(), login.getPassword());
		
		if(b.getHeader().getStatusCode()==404) {
			return new ResponseEntity<BaseHeader>(b, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<BaseHeader>(b, HttpStatus.CREATED);
		
	}
}
