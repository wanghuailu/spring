package org.springframework.debug.createBean.factoryBean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author kenny
 * @date 2021-12-08
 */
public class MyFactoryBean implements FactoryBean<Person> {

	@Override
	public Person getObject() throws Exception {
		Person person = new Person("李四");
		return person;
	}

	@Override
	public Class<?> getObjectType() {
		return Person.class;
	}
}
