Bean 的生命周期

xml或注解，启动容器

1. 创建容器对象 obtainFreshBeanFactory
    1) 创建容器 DefaultListableBeanFactory
    2) 设置某些属性值
    3) 加载配置文件   loadBeanDefinitions()  得到的都是 GenericBeanDefinition
        a. Document
        b. Element
            i. parseDefaultElement
           ii. parseCustomElement
2. invokeBeanFactoryPostProcessors
    1) 调用执行 BFPP，可以修改或引入其他的 BeanDefinition，但是需要注意，BFPP 操作的是 BeanFactory
    2) 子类 BeanDefinitionRegistryPostProcessor 可以直接操作 BeanDefinition
    3) 子类 ConfigurationClassPostProcessor 主要完成注解的解析工作
        a. @Configuration
        b. @Component
        c. @PropertySource
        d. @ComponentScan
        e. @Import
        f. @ImportResource
        g. @Bean
3. registerBeanPostProcessors
4. finishBeanFactoryInitialization  完成对象的创建工作
    1) 实例化    将 GenericBeanDefinition 合并成 RootBeanDefinition
        a. getBean()
        b. doGetBean()
        c. createBean()
        d. doCreateBean()
        e. createBeanInstance()
            i. supplier
           ii. factoryMethod
          iii. 默认反射机制
           iv. factoryBean
            v. BPP代理  InstantiationAwareBeanPostProcessor  
    2) applyMergedBeanDefinitionPostProcessors
        a. CommonAnnotationBeanPostProcessor 解析 @PostConstruct、@PreDestroy、@Resource 注解
        b. AutowiredAnnotationBeanPostProcessor 解析 @Autowired、@Value 注解
    3) populateBean
        a. 填充属性
        b. 创建依赖的 Bean 对象
    4) initializeBean  进行初始化工作
        a. 执行 Aware 接口的方法   BeanNameAware、BeanFactoryAware、BeanClassLoaderAware
        b. 执行 BPP 的 before 方法
            i. ApplicationContextAwareProcessor 继续执行剩下的 Aware 接口的方法
           ii. CommonAnnotationBeanPostProcessor 执行 @PostConstruct、@PreDestroy 修饰的方法
          iii. invokeInitMethods
            一、是否实现了 InitializingBean 接口，如果实现了需要执行对应的方法
            二、执行自定义的 init-method 方法
           iv. 执行 BPP 的 after 方法，主要是 AOP 功能
    5) 获取对象进行使用
    6) DestructionAwareBeanPostProcessors
    7) DisposableBean
    8) 执行 destroy-method 方法
        
        
        
           

