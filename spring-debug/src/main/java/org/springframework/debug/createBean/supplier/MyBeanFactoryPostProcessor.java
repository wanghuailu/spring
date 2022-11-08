package org.springframework.debug.createBean.supplier;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * @author kenny
 * @date 2021-12-08
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		BeanDefinition beanDefinition = beanFactory.getBeanDefinition("student");
		GenericBeanDefinition genericBeanDefinition = (GenericBeanDefinition) beanDefinition;
		genericBeanDefinition.setInstanceSupplier(StudentSupplier::createStudent);
	}
}
