# spring框架是什么
它其实是一个轻量级开发框架，轻量主要在于它不是一个全量功能的框架，而是很多组件化的模块，
core，context，beans，expressions这些组件都可以分别独立引入使用。
IOC和AOP两大特性是Spring的核心设计思想，正是这两大特性帮助Spring实现了模块化，松耦合使得它们不再是强依赖，可以随意选择搭配使用。
Spring生态现在发展的也比较好，提供了各种中间件的抽象支持，各种快捷操作的模板可以快速迭代开发，上手成本低，开发周期也短

## IOC 的两种实现方式是什么？它们的区别和联系是什么？
实现方式：依赖注入上下文的被动的接收 依赖查找 上下文的查找 联系：依赖查找时运用了依赖注入

## BeanFactory与ApplicationContext的对比
BeanFactory 接口提供了一个抽象的配置和对象的管理机制，ApplicationContext 是 BeanFactory 的子接口，它简化了与 AOP 的整合、消息机制、事件机制，以及对 Web 环境的扩展（ WebApplicationContext 等），BeanFactory 是没有这些扩展的。

ApplicationContext 主要扩展了以下功能：

AOP 的支持（ AnnotationAwareAspectJAutoProxyCreator 作用于 Bean 的初始化之后 ）
配置元信息（ BeanDefinition 、Environment 、注解等 ）
资源管理（ Resource 抽象 ）
事件驱动机制（ ApplicationEvent 、ApplicationListener ）
消息与国际化（ LocaleResolver ）
Environment 抽象（ SpringFramework 3.1 以后）
