## Spring

### 核心原理
- IOC
    称为控制反转。将原本由程序自己控制的对象的创建和生命周期交由spring控制，通常实例化一个对象时需要我们new一个对象，
    但是IOC把这个工作交给了Spring框架；
- IOC容器
    具有依赖注入（DI）功能的容器，是创建对象的容器。IOC负责实例化程序中的对象并建立对象之间的联系
- DI
    称为依赖注入，是IOC的实现方式。组件之间的依赖关系由容器运行时决定，是IOC中决定对象关联关系的一种实现方式，程序中
    所用到的外部资源会由IOC容器动态的注入到程序中（外部资源通常就是一些加了@Resource或@Autowired的类)
- AOP
    面向切面编程。将程序的公共方法抽出来，进行横向扩展，无需在程序中置入代码片段的编程方式成为AOP。通常进行方法抽象的
    方式是编写一段公共方法，然后由程序主动调用公共方法，而AOP则是通过切入点让程序在运行时插入代码块，而不用将抽象的方
    法在程序中调用。通常用于做一些日志记录、权限控制等统一的功能
    1. Aspect。切面，AOP中公共功能的实现类，通常是一个类，使用@Aspect修饰
    2. Advice。通知，切面的具体实现，也就是切入后具体要实现的功能
    3. JoinPoint。连接点，程序运行过程中的一个插入地点，此地点可能包含方法名，方法参数等等信息
    4. Pointcut。切入点，定义了切入的位置
### BeanFactory和FactoryBean
    区别在于BeanFactory是一个Bean的管理工厂。FactroyBean是一个Bean的生成器。
- BeanFactory是IOC中的核心工厂接口，也就是IOC容器，负责实例化和管理配置各种对象。但它只是一个接口定义，实际的实现
  由很多个实现类在实现
- FactoryBean是一个生产和修饰对象生成的Bean工厂接口，用户可以通过实现该接口定制bean的实例化逻辑。其中包含三个方法，
  getObject(获取对象实例), booleanSingleton(是否单例，若是单例则会加入到单例缓存池)，getObjectType(返回对象类型)
  
## spring boot

### 启动原理
- SpringBootApplication注解
    1. EnableAutoConfiguration。内部结合了@Import(EnableAutoConfigurationImportSelector.class)，借助
    EnableAutoConfigurationImportSelector类，以及SpringFactoriesLoader工具的支持，找到
    META-INF/spring.factories文件定义的配置文件进行加载，并转化成JavaConfig形式的配置
    2. Configuration。定义了javaConfig形式的配置
    3. ComponentScan。定义了类扫描路径
### 执行过程
- 创建SpringApplicationRunListener，并开始监听
- 加载SpringBoot配置环境
- 将配置环境加入监听器中
- 创建应用上下文
- prepareContext将监听器，配置环境等跟上下文绑定
- refreshContext初始化自动配置，包括spring.factories里面的配置加载，bean的实例化等