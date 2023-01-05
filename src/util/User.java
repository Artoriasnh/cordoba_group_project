package util;

import java.io.Serializable;

/**
 * User object encapsulates all data associated with a single
 * user.
 */
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String sex; 
	private String email; 
	private String hobby; 	
	
	//-----------------------------------------
	// Two constructors; one for login, one for
	// account creation. 
	//-----------------------------------------
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public User(String username, String password, String sex, String email, String hobby) {
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.email = email;
		this.hobby = hobby;
	}
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getSex() {
		return sex;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getHobby() {
		return hobby;
	}
	
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
}