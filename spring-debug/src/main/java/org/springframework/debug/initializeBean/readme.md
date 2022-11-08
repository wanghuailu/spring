initializeBean 执行逻辑

1）执行调用 Aware 接口对应的方法
    BeanNameAware
    BeanClassLoaderAware
    BeanFactoryAware
    这三个接口，在 obtainFreshBeanFactory() 方法执行时，设置被忽略，在初始化操作里面才进行执行
    
2）执行 BPP 的 before 方法
    其余的 Aware 接口都是在这里执行的，ApplicationContextAwareProcessor 这个类负责执行（注：这里的 Aware 方法是在 prepareBeanFactory() 方法设置被忽略的）
    CommonAnnotationBeanPostProcessor 在这里主要是执行 @PostConstruct 和 @PreDestroy 注解的方法

3）调用执行 init-method 方法
    实行了 InitializingBean 接口，调用其 afterPropertiesSet() 方法
    调用用户自定义的 init-method 方法
   
4）执行 BPP 的 after 方法
    AbstractAutoProxyCreator
    
    
    
问题：
1、如果 @PostConstruct 和 init-method 指定的是同一个方法，那么该方法执行几次？
    只执行一次
    
2、如果 @PostConstruct 和 init-method 指定的是不同方法，那么这两个方法是否都会执行？
    都会执行
    在执行 init-method 的方法时，会判断缓存是否已经执行过该方法
    
3、@Bean 加上方法上创建出来的 Bean 是否会被 Spring 管理？是否会执行 initializeBean 逻辑？ 这个 Bean 是否会放到 Spring 的一级缓存中？

