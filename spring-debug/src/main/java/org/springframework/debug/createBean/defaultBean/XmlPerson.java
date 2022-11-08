package org.springframework.debug.createBean.defaultBean;

/**
 * @author kenny
 * @date 2021-12-13
 */
public class XmlPerson {

	private String username;

	public XmlPerson(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "XmlPerson{" +
				"username='" + username + '\'' +
				'}';
	}
}
