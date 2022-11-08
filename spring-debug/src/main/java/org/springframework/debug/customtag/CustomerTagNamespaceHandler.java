package org.springframework.debug.customtag;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @author kenny
 * @date 2021-11-05
 */
public class CustomerTagNamespaceHandler extends NamespaceHandlerSupport {

	@Override
	public void init() {
		registerBeanDefinitionParser("user", new UserBeanDefinitionParser());
	}
}
