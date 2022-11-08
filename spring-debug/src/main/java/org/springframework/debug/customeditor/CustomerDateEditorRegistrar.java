package org.springframework.debug.customeditor;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

/**
 * @author kenny
 * @date 2021-11-09
 */
public class CustomerDateEditorRegistrar implements PropertyEditorRegistrar {

	@Override
	public void registerCustomEditors(PropertyEditorRegistry registry) {
		registry.registerCustomEditor(CustomerDate.class, new CustomerDateEditor());
	}
}
