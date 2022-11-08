package org.springframework.debug.createBean.resolveBeforeInstantiation;


import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;

/**
 * @author kenny
 * @date 2021-12-08
 */
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

	@Override
	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
		System.out.println("执行 MyInstantiationAwareBeanPostProcessor 的 postProcessBeforeInstantiation");
		if (beanClass == User.class) {
			Enhancer enhancer = new Enhancer();
			enhancer.setSuperclass(User.class);
			enhancer.setCallback(new UserInterceptor());
			User user = (User) enhancer.create();
			System.out.println("创建代理对象" + user.toString());
			return user;
		}
		return null;
	}

	@Override
	public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
		System.out.println("执行 MyInstantiationAwareBeanPostProcessor 的 postProcessAfterInstantiation");
		return false;
	}

	@Override
	public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
		System.out.println("执行 MyInstantiationAwareBeanPostProcessor 的 postProcessProperties");
		return pvs;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("执行 MyInstantiationAwareBeanPostProcessor 的 postProcessBeforeInitialization");
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("执行 MyInstantiationAwareBeanPostProcessor 的 postProcessAfterInitialization");
		return bean;
	}
}
