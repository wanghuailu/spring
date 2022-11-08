 自定义标签解析

1. 定义一个存储标签解析返回值的POJO  比如：org.springframework.debug.customtag.User

2. 定义自定义标签解析器 比如：org.springframework.debug.customtag.UserBeanDefinitionParser

3. 定一个标签处理器，将解析器注入进去 比如：org.springframework.debug.customtag.CustomerTagNamespaceHandler

4. 在resources目录下加一个META-INF文件夹（文件夹名称必须是META-INF）

5. 在META-INF文件夹下创建 Spring.hanlders 和 Spring.schemas 文件（文件名首字母必须大写，必须是properties文件）
    注：Spring.hanlders 和 Spring.schemas 文件使用小写其实也是可以的，但是需要改docs.gradle文件(228行)

6. 在META-INF文件夹下创建 xsd 文件（必须是properties文件，必须包含id属性）
