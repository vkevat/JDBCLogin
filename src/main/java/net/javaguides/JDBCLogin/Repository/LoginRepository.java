package net.javaguides.JDBCLogin.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import net.javaguides.JDBCLogin.Entity.Login;
import net.javaguides.JDBCLogin.Exception.EmptyResultDataAccessException;

@Repository
public class LoginRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Login> getAllUser(){
		return jdbcTemplate.query("select * from jdlogin", new BeanPropertyRowMapper<Login>(Login.class));
	}
	
	public int newUser(Login login) {
		return jdbcTemplate.update("insert into jdlogin(id, firstName, lastName, dob, emailID, password, new_password) values(?,?,?,?,?,?,?)", new Object[] {login.getId(), login.getFirstName(), login.getLastName(), login.getDob(), login.getEmailID(), login.getPassword(),login.getNew_password()});
	}
	
	public Login findById(int id) {
		return jdbcTemplate.queryForObject("select * from jdlogin where id=?", new BeanPropertyRowMapper<Login>(Login.class), new Object[] {id});
	}
	
	public Login validUser(String emailID, String password) {
		
		System.out.println("Err 3"+emailID+password);
		Login l;
		try {
		l=jdbcTemplate.queryForObject("select * from jdlogin where emailID=? and password=?", new BeanPropertyRowMapper<Login>(Login.class), new Object[] {emailID, password});
		}
		catch(Exception exception) {
		
		System.out.println(exception);
			
		l=null;
		}
		return l;
	}
}
