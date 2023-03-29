package Planner;

import java.io.IOException;

public class User {
	String loginName;
	String password;
	
	public void set(String name, String pass) {
		this.loginName = name;
		this.password = pass;
	}
	
	public boolean addToList() throws IOException {
		return true;
	}
	
	public boolean find(String name,String pass) throws IOException {
		return true;
	}
	
}
