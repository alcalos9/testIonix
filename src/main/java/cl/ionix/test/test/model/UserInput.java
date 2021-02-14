package cl.ionix.test.test.model;

import javax.validation.constraints.NotNull;


public class UserInput {
	
	@NotNull
	private String name;
	
	@NotNull
	private String username;
	
	@NotNull
	private String email;
	
	@NotNull
	private Integer phone;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	
	 
}
