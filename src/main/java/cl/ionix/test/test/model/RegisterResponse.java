package cl.ionix.test.test.model;

public class RegisterResponse {
	private int responseCode;
	private String description;
	private long elapsedTime;
	private ResultRegister result;
	public int getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getElapsedTime() {
		return elapsedTime;
	}
	public void setElapsedTime(long elapsedTime) {
		this.elapsedTime = elapsedTime;
	}
	public ResultRegister getResult() {
		return result;
	}
	public void setResult(ResultRegister result) {
		this.result = result;
	}
	
}
