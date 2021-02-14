package cl.ionix.test.test.model;

import java.util.List;

import cl.ionix.test.test.entity.User;

public class UserEmailOutput {
	private boolean result;
	private String message;
	private List<User>  users;
	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
}
