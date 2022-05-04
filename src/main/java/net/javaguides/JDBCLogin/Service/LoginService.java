package net.javaguides.JDBCLogin.Service;

import net.javaguides.JDBCLogin.Entity.BaseHeader;
import net.javaguides.JDBCLogin.Entity.FinalLogin;
import net.javaguides.JDBCLogin.Entity.Login;
import net.javaguides.JDBCLogin.Entity.LoginID;

public interface LoginService {

	FinalLogin getAllUSer();
	LoginID newUser(Login login);
	LoginID findById(int id);
	BaseHeader validUser(String emailID, String password);
	public String encryptData(String password);
}
