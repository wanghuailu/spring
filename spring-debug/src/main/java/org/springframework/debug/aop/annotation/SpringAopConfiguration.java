package org.springframework.debug.aop.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author kenny
 * @date 2022-01-13
 */
@Configuration
@ComponentScan(basePackages = "org.springframework.debug.aop.annotation")
@EnableAspectJAutoProxy
public class SpringAopConfiguration {
}
