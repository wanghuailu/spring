创建 Bean 的五种方式
1. 通过反射创建 bean   
    spring中最基本的创建 bean 方式
2. 通过 FactoryBean 来创建对象
    通过调用 FactoryBean 的 getObject() 来创建 bean
    此时创建的bean虽然是spring来管理，但是不是放在一级缓存(singletonObjects)中，而是放到了 factoryBeanObjectCache 中
3. 通过 beanPostProcessor 来创建代理对象
    InstantiationAwareBeanPostProcessor
4. 通过 supplier 来创建 bean
    通过实现 beanFactoryPostProcessor 来设置 beanDefinition 的 instanceSupplier 属性来创建的方式
5. 通过 factory-method 来创建 bean
    静态工厂
    实例工厂
    
   
对比下 FactoryBean 和 supplier
相同点：都是创建 bean，不用遵循 BeanFactory 给出的 bean 的严格创建流程
不同点：
    FactoryBean: 抽象出一个接规范口，所有的对象创建必须要通过 getObject() 方法来获取  --- 接口规范实现
    supplier: 随便定义一个创建的对象的方法，通过 BFPP 来修改 BeanDefinition 的 instanceSupplier 的值创建对象 --- 只是 BeanDefinition 的一个属性值
