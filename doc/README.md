#SpringBoot打不同环境的包
**方法1**

在application.properties中设置spring.profiles.active=dev，说明默认以dev环境设置

**方法2**

执行java -jar xxx.jar --spring.profiles.active=dev，也可以设置dev环境