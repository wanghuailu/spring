一、如何查看当前spring的版本？
    查看gradle.properties的version值，当前源码是5.3.8-SNAPSHOT（属于5.x系列）

二、spring5.0，要求JDK9及以上
    可以安装jdk11来构建
    
三、idea版本
    idea的版本也会影响构建，可以使用2020.1版本（亲测有用）
    
四、构建时，部分依赖下载超时
    多构建几次
   
五、gradle使用阿里云镜像
    代码已经配置好阿里云镜像，参考setting.gradle和build.gradle文件
    全局配置方式，可以网上搜索下
    
六、调试spring项目时，控制台乱码解决方案？
    1、修改build.gradle文件，添加以下内容
        tasks.withType(JavaCompile) {
            options.encoding = "UTF-8"
        }
    2、修改help >> Edit Custom Properties，添加以下内容
        -Dfile.encoding=UTF-8
    3、修改Settings >> Editor >> File Encodeings，全部都配置UTF-8
    4、重启idea