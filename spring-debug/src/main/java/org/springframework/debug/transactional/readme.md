AOP 里面基本的四个组件

Advice                                                          AspectJAwareAdvisorAutoProxyCreator

Advisor                 DefaultBeanFactoryPointcutAdvisor

MethodInterceptor       TransactionInterceptor                  NameMatchTransactionAttributeSource

PointCut                AspectJExpressionPointcut


流程：
    1. obtainFreshBeanFactory 解析配置文件，创建 beanDefinitions
    2. registerBeanPostProcessors 注册一个 AspectJAwareAdvisorAutoProxyCreator
    3. ...   

xml 配置方式的对象
    AspectJExpressionPointCut
    DefaultBeanFactoryPointcutAdvisor
    TransactionInterceptor
    NameMatchTransactionAttributeSource


注解配置方式的对象  @EnableTransactionManagement
    BeanFactoryTransactionAttributeSourceAdvisor
    TransactionInterceptor
    AnnotationTransactionAttributeSource
    
   
如果外层方法中包含事务，那么内层方法是否支持事务？
    支持外层事务：
        REQUIRED    如果外层存在，则加入；外层没有则新建事务执行
        SUPPORTS    如果外层存在，则加入；外层没有就以无事务执行
        MANDATORY   如果外层存在，则加入；外层没有抛出异常
    不支持外层事务：
        REQUIRES_NEW    如果外层存在，则挂起，新建一个事务执行；外层没有则新建事务执行
        NOT_SUPPORTED   如果外层存在，则挂起，以无事务执行；外层没有就以无事务执行
        NESTED          如果外层存在，则抛出异常；外层没有就以无事务执行
    NEVER   只能在无事务下执行，如果存在事务，则抛出异常
    
        
事务组合（数字为外层事务传播机制，字母为内层事务传播机制）
    1、REQUIRED
        a、REQUIRED
            1.1 内层抛出异常，外层捕获异常                   结果：抛出 Transaction rolled back because it has been marked as rollback-only 异常
            1.2 内层抛出异常，外层不捕获异常                  结果：正常回滚
            1.3 内层正常，外层抛出异常                         结果：正常回滚
        b、SUPPORTS
            1.1 内层抛出异常，外层捕获异常                   结果：
            1.2 内存抛出异常，外层不捕获异常                  结果：
            1.3 外层抛出异常                              结果：
        c、MANDATORY
        d、REQUIRES_NEW
        e、NOT_SUPPORTED
        f、NESTED
        g、NEVER
    2、SUPPORTS
        a、REQUIRED
        b、SUPPORTS
        c、MANDATORY
        d、REQUIRES_NEW
        e、NOT_SUPPORTED
        f、NESTED
        g、NEVER   
    3、MANDATORY
        a、REQUIRED
        b、SUPPORTS
        c、MANDATORY
        d、REQUIRES_NEW
        e、NOT_SUPPORTED
        f、NESTED
        g、NEVER
    4、REQUIRES_NEW
        a、REQUIRED
        b、SUPPORTS
        c、MANDATORY
        d、REQUIRES_NEW
        e、NOT_SUPPORTED
        f、NESTED
        g、NEVER
    5、NOT_SUPPORTED
        a、REQUIRED
        b、SUPPORTS
        c、MANDATORY
        d、REQUIRES_NEW
        e、NOT_SUPPORTED
        f、NESTED
        g、NEVER
    6、NESTED
        a、REQUIRED
        b、SUPPORTS
        c、MANDATORY
        d、REQUIRES_NEW
        e、NOT_SUPPORTED
        f、NESTED
        g、NEVER
    7、NEVER
        a、REQUIRED
        b、SUPPORTS
        c、MANDATORY
        d、REQUIRES_NEW
        e、NOT_SUPPORTED
        f、NESTED
        g、NEVER
        
    
    