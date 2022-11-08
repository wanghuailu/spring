package org.springframework.debug.customeditor;

import java.util.Date;

/**
 * @author kenny
 * @date 2021-11-09
 */
public class CustomerDate {

	private Date date;

	public CustomerDate() {
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "CustomerDate{" +
				"date=" + date +
				'}';
	}
}
