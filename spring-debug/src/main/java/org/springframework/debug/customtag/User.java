package org.springframework.debug.customtag;

/**
 * @author kenny
 * @date 2021-11-05
 */
public class User {

	private String username;

	private String password;

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

	@Override
	public String toString() {
		return String.format("User{username:%s password:%s}", this.username, this.password);
	}
}
