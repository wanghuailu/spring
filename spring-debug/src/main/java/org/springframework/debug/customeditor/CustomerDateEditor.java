package org.springframework.debug.customeditor;

import java.beans.PropertyEditorSupport;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author kenny
 * @date 2021-11-09
 */
public class CustomerDateEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = dateFormat.parse(text.replaceAll("_", "-"));
			setValue(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
