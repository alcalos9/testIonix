package cl.ionix.test.test.model;

import cl.ionix.test.test.entity.User;

public class AllUserOutput {
	private boolean result;
	private String message;
	private Iterable<User> users;
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
	public Iterable<User> getUsers() {
		return users;
	}
	public void setUsers(Iterable<User> users) {
		this.users = users;
	}
	
}
