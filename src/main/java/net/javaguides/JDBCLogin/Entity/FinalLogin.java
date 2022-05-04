package net.javaguides.JDBCLogin.Entity;

import java.util.List;

public class FinalLogin extends BaseHeader{

	private List<Login> login;

	public List<Login> getLogin() {
		return login;
	}

	public void setLogin(List<Login> login) {
		this.login = login;
	}
	
}
