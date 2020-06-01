package com.wicket.models;

import java.io.Serializable;

public class UserModel implements Serializable { //has to be serializable to be used by wicket
	
	/**
	 * this pojo is used to be filled by our form
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String gender;
	private String password;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
