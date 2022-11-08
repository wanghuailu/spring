填充属性   --->>>   给属性赋值

属性的类型：

1）基本数据类型
    byte、boolean、char、short、int、long、float、double
2）引用数据类型
    从容器中获取到具体的对象，如果有，直接赋值；如果没有，就创建后再赋值
    
以上两种类型，再加上 数组、list、set、map、properties 等类型，才是完整的属性类型

属性注入方式：
1）不注入
2）默认的注入方式
3）按照类型注入
4）按照名称注入
5）按照构造器注入

在注入的过程中，还包括类型的转型，比如，String 类型的值赋值给 int 类型的属性


自己实现 MyAutowired 注解，完成和 Autowired 相同的功能


总结：

1） 调用 InstantiationAwareBeanPostProcessor 
    postProcessAfterInstantiation 方法来完成属性的赋值工作，可以终止后续的值处理工作，也可以直接让后续的属性来完成覆盖操作，取决于开发者
    
2）根据配置文件的 autowired 的属性来决定使用名称还是类型完成注入
    byName
    byType
    @Autowired 是根据 byType 完成注入的
    
3）将对象中定义的 @Autowired 和 @Value 注解进行解析，并完成对象的属性注入
    AutowiredAnnotationBeanPostProcessor

4）根据 <property> 标签定义的属性值，完成各种属性值的解析和赋值工作
    applyPropertyValues() 方法完成的操作


