AOP

动态代理：
    jdk：
        其代理对象必须是某个接口的实现，它是通过在运行期间创建一个接口的实现类来完成对目标对象的代理
    cglib
        实现原理类似于 JDK 动态代理，只是它在运行期间生成的代理对象是针对目标类扩展的子类。
    两者总结：
        1. 如果目标对象实现了接口，默认情况使用的是 jdk 动态代理
        2. 如果目标对象实现了接口，可以强制使用 cglib 动态代理
        3. 如果目标对象没有实现接口，必须采用 cglib 代理，spring 会自动在 jdk 动态代理和 cglib 动态代理之前切换  
    如何强制使用 cglib 动态代理？
        添加 cglib 库， Spring_HOME/cglib/*.jar
        在 spring 配置文件中，配置 proxy-target-class = true
    jdk 动态代理和 cglib 字节码生成的区别？
        1. jdk 动态代理只能对实现了接口的类生成代理，而不能针对类（生成的代理类，实际是接口的实现类）
        2. cglib 是针对类实现代理的，主要是对指定的类生成一个子类，覆盖其中的方法，因为是继承，所以该类或方法最好不要声明成 final
      
名词：
    Advisor 通知器/增强器
    Advice 通知/增强
    PointCut 切入点
    JoinPoint 连接点
    Target 目标对象
    Weaving 织入
    Proxy 代理
    Aspect 切面
    
问题：
    1、哪些类需要进行相关的切入？
        expression  pointcut
    2、额外的逻辑处理，有几个通知消息或者有哪些逻辑可以被执行？
        before、after、around、afterReturning、afterThrowing
    3、额外的处理逻辑类是哪个？
        aspect

配置文件属性：
    proxy-target-class: 
        默认值为 false，主要是用来控制是使用 JDK 还是使用 cglib 动态代理
        如果值为 false，会优先使用 JDK 来生成代理，如果被代理对象没有实现任何接口，则会用 cglib 来生成代理对象  
    expose-proxy:
        有时候目标对象内部的自我调用，将无法实施切面中的增强，例如：
        这种调用，test2() 的执行不会被代理类增强，如果想要被增强，则需要设置 expose-proxy = true，同时 ((A)AopContext.currentProxy()).test2()
        
        public class A {
            
            public void test1(){
                test2();
            }
            
            public void test2(){
            
            }
        }

阅读源码需要注意的：
    1、查看配置文件的解析工作，在处理之后的 beanDefinition 中包含什么信息？
        BeanDefinition 的解析工作(loadBeanDefinitions)
    2、对 aop 相关的 beanDefinition 进行实例化操作
        在进行第一个对象创建之前，就必须要把 aop 需要的相关对象提前准备好，因为无法预估哪些对象需要动态代理
    3、在哪个步骤中可以提前实例化并且生成对应的对象
        BFPP 是用来对 BeanFactory 进行修改操作的，不会影响到后续的实例化过程
        BPP(beanPostProcessor(before 和 after))   resolveBeforeInstantiation
    
AOP 主要的类：
AopConfigUtils
    静态块中引入 
        InfrastructureAdvisorAutoProxyCreator
        AspectJAwareAdvisorAutoProxyCreator
        AnnotationAwareAspectJAutoProxyCreator 

AspectJAutoProxyBeanDefinitionParser    
    parseCustomElement() 自定义标签解析

AnnotationAwareAspectJAutoProxyCreator 
    1) 查看类图可以看到，这个类是 InstantiationAwareBeanPostProcessor 的子类
    2) IOC 流程中，可以确定的是 InstantiationAwareBeanPostProcessor 可以创建代理对象
        createBean() 中的 resolveBeforeInstantiation() 方法
    3) AbstractAutoProxyCreator 可以看到两个重要的方法
        postProcessBeforeInstantiation
        postProcessAfterInitialization
    
AspectJMethodBeforeAdvice
AspectJAfterAdvice
AspectJAfterReturningAdvice
AspectJAfterThrowingAdvice
AspectJAroundAdvice
     
DefaultAopProxyFactory
    可以看到到底是使用 jdk 生成代理还是使用 cglib 生成代理
   

AspectJPointcutAdvisor
    只有有参构造器，需要 AbstractAspectJAdvice
    一般都是 
        AspectJMethodBeforeAdvice
        AspectJAfterAdvice
        AspectJAfterReturningAdvice
        AspectJAfterThrowingAdvice
        AspectJAroundAdvice
    这五类，如果没配置 aop:around，那就不会有 AspectJAroundAdvice，其他的同理
    上面五个类，也是只有有参构造器
    都是
        Method aspectJBeforeAdviceMethod
        AspectJExpressionPointcut pointcut
        AspectInstanceFactory aif
    所以在进行标签解析时，封装了 advisor 的 beanDefinition 中，同时注入了这些依赖的对象的信息
    在进行实例化的时候，可以看到
        resolveBeforeInstantiation(beanName, mbdToUse) 这里会执行 AnnotationAwareAspectJAutoProxyCreator 这个类创建 Advisor 对象
    然而创建 Advisor 的对象时，由于它只有有参构造器，又会去创建依赖的 Advice，而 Advice 也是只有有参构造器，所以需要继续创建
       Method、 AspectJExpressionPointcut、 AspectInstanceFactory
    在进行 debug 实例化的时候，可能会存在无限的嵌套，需要时刻看当前被实例化的是什么对象
            
    
AspectJExpressionPointcutAdvisor
    有无参构造器


被代理类的初始化方法里面，执行Bpp的after方法，才会生成代理类



问题1.某个代理类中包含m1和m2两个方法，当分别调用这两个方法的时候，是否能执行通知？
    可以

问题2.某个代理类中包含m1和m2两个方法，如果我们是在m1里面调用m2，那此时我们调用m1方法的时候，m2前后是否会执行通知？
    不会，如果想要执行通知，可以配置 expose-proxy = true

问题3.before、around、after、afterReturning、afterThrowing五个是什么样的调用顺序？
    先执行around，around里面调用before，然后再调用目标类的方法，然后再继续执行around
    其次执行after
    如果正常返回，那么执行afterReturning，如果异常，执行afterThrowing
    
问题4.ExposeInvocationInterceptor的执行逻辑？
    根据 advisors 的索引依次执行获取到的 advisor(通知) ，那么ExposeInvocationInterceptor相当于是联系者
    
问题5.DefaultAdvisorAdapterRegistry的构造方法，只注册三个adapter，不是注册五个adapter？
    扩展性
    本来可以把 before、around、after、afterReturning、afterThrowing 五个的 advice 都实现 MethodInterceptor 接口
    但是设计者考虑 AspectJMethodBeforeAdvice、AspectJAfterReturningAdvice、ThrowsAdvice 这三个可以完成很多场景的需求，留给开发者扩展
    AspectJAfterAdvice、AspectJAroundAdvice、AspectJAfterThrowingAdvice 三个都实现了 MethodInterceptor 接口
    AspectJMethodBeforeAdvice、AspectJAfterReturningAdvice 在执行前，又封装成实现了 MethodInterceptor 的一个 interceptor
    
    

问题6.如果配置了 beforeMethod、after、around 这三个方法，有时候执行的顺序却不一样，是什么情况？
    拓扑排序，会导致 beforeMethod + after 和 around 的顺序不是固定的
    一般使用上面，不会把这三个一起配置，都是选择 beforeMethod + after 或者 around

