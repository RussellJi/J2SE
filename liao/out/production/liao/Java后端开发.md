# Java后端开发

## 第一部分 Java基础

### 变量

### 控制结构

### 数组

### OOP

- 封装
- 继承
- 多态

### Java API

- String
- StringBuilder
- StringJoiner
- wrapper
- 枚举

### 异常处理

### 集合

如何选择？
单列数据：Collection
可重复：List
增删多：LinkedList（双向链表）
查改多：ArrayList（可变数组）
线程安全：Vector
不重复：Set
无序：HashSet
排序：TreeSet
有序：LinkedHashSet（数组+双向链表）
键值对：Map
线程安全：Hashtable
读取配置文件：Properties
键无序：HashMap
键排序：TreeMap


- Iteratable

	- Collection

		- List

		  存取一致
		  

			- ArrayList

			  线程不安全，没有synchronized
			  维护了Object[ ] elementData数组，顺序存储，方便查找元素，增加删除元素较为麻烦
			  扩容机制
			  无参，初始为0，第一次为10，扩容1.5倍
			  有参数，初始为参数，扩容1.5倍
			  

			- LinkedList

			  底层维护了一个双向链表
			  便于增加删除元素，不善于查找元素
			  线程不安全
			  

			- Vector

			  线程安全，synchronized
			  add
			  无参初始为10，扩容2.0
			  有参，初始参数，扩容2.0
			  

		- Set

		  不能通过索引获取元素
		  无重复
		  

			- HashSet

			  底层为HashMap:table+链表+红黑树
			  add
			  获取hash值：hashcode^hashcode>>>16  //减小碰撞
			  索引值：hash&(n-1)   //有时会当数组大小较小时，会隐藏高位特性
			  若数组长度为0，resize()
			  查看当前索引位置是否有元素
			  无：直接添加
			  有：判断hash值是否相同，再判断==或者equals
			  相等不添加
			  不等：判断是否为红黑树
			  按红黑树依次进行判断
			  按链表依次判断
			  没有相等的
			  添加到末尾
			  有相等的
			  不添加
			  扩容
			  table的数组长度初始化为16，加载为0.75（12），等于12，2倍容
			  红黑树转化
			  当链表的结点达到8.并且左右结点的数目达到64，链表转化为红黑树
			  

				- LinkedHashSet

				  底层维护了一个LinkedHashMap：table+双向链表+红黑树
				  保证了存取一致
				  

			- TreeSet

			  可排序
			  TreeSet结点为Entry<K,V>
			  构造器
			  无参构造器
			  默认字符串compareTo排序
			  有参构造器
			  Comparator对象传给TreeMap中的comparator
			  重写compare方法
			  add()
			  调用底层TreeMap的put()
			  
			  

	- Map

		- HashMap

		  索引值不重复
		  put
		  索引相同，替换
		  每个结点为hashmap.Node类型 实现了Entry接口，引用保存在EntrySet中，方便程序员遍历，entry提供了getkey()与getValue()方法
		  遍历方式
		  获得（list）keyset
		  get（key）
		  获得(collection)values
		  获得entryset
		  通过iterator获得entry实例，调用getKey
		  
		  

			- LinkedHashMap

		- Hashtable

		  存放键值对
		  键和值都不能为空，否则会跑出NPE
		  使用方法基本同HashMap
		  线程安全
		  

			- Properties

		- TreeMap

		  若key比较为一样，key不变，则value替换
		  

### 泛型

### 反射

### 注解

### 线程基础

- 进程与线程
- 并发并行
- 创建线程

	- 继承Thread
	- 实现Runnable接口

- Why start？not run
- 通知线程退出
- 线程中断
- 线程插队
- 守护线程
- 生命周期，7大状态
- 同步机制

	- 售票

### IO

- 文件
- IO流原理流的分类
- 节点流和处理流
- 输入流
- 输出流
- Properties

### 网络通信

### MySQL

## 第二部分 Java高级

### 算法与数据结构

- 算法

	- 排序

		- 直接插入
		- 选择
		- 冒泡
		- 快速排序
		- 堆排序
		- 基数排序
		- 归并

	- 查找
	- 分治
	- 回溯
	- 贪心
	- KMP
	- 动态规划

- 数据结构

### 多线程与高并发

- 并发基础

	- 同步异步
	- 阻塞非阻塞
	- 指令重排
	- synchronized
	- volatile

- 线程
- 锁

	- 自旋锁
	- 偏向锁
	- 可重用锁

- 线程池
- 并发容器
- JUC

	- executor
	- collections
	- atomic原子类
	- tools(CountDownLatch,Exchange,ThreadLocal,CyliBarrier)

### 设计模式

- 单例模式
- 观察者
- 工厂
- 适配器
- 装饰者
- 代理
- 模板
- 职责链
- 其它（组合，桥接，原型）

### JVM

- JVM体系
- 类加载机制
- 双亲委派/sandbox安全机制
- JMM（Java内存模式）
- 字节码的执行过程
- GC垃圾回收
- 性能监控，故障定位
- 调优

## 第三部分 Java Web

### 前端基础

- HTML
- CSS
- JS
- JQuery

### 前端框架（可弱化）

- VUE
- React
- Angular
- Bootstrap
- NodeJS

### Java Web后端

- Tomcat
- servlet
- JSP

## 第四部分 主流框架和项目管理

### Linux系统

### Nginx（反向代理的web服务器）

### SSM

- Spring
- SpringMVC
- Mybatis

### 项目管理

- Maven
- Git&GitHub

### 数据库

- Redis
- Mysql
- Oracle

### 其它

## 第五部分 分布式微服务 并行架构

## 第六部分 开发运维一体化技术（DevOps，自动化部署管理项目，解决CICD）

## 第七部分 大数据技术

## 第八部分 项目

### 电商

### 金融

### 教育

### 直播

### CRM,ERP

## 第九部分 大厂的高频面试题

## 第十部分底层源码内核研究

## 编程基础拓展

### 计算机网络

### 操作系统

### 计算机组成原理

### 编译原理

### 离散数学

### 数值分析

### 汇编

*XMind - Trial Version*