### hashmap与concurrenthashmap的区别 
- hashMap是非线程安全的，在jdk1.7之前是数组+链表的实现方式，在jdk1.8之后是数组+链表+红黑树的实现方式
- concurrenthashmap是线程安全的，jdk1.7之前使用分段锁(ReentrantLock)的方式对数组进行加锁，jdk1.8之后配合CAS+Synchronized
  对每个Node进行加锁，但两者的基本结构都是一样的

### 垃圾回收算法以及垃圾回收器 
- 标记清除。CMS收集器
- 标记整理。用在老年代的垃圾回收
- 标记复制。用在新生代eden区和survivor区的垃圾回收
- serial,serial old, parNew, parallel scavenge, parallel old, CMS, G1
### CMS的回收步骤 

### G1和CMS的区别 
### CMS哪个阶段是并发的哪个阶段是串行的？ 
### G1内部是如何分区的（region） 
### HashMap如何解决Hash冲突 
### mysql索引类别 
### 什么是覆盖索引 
### b+树和b树的区别 
### 为什么选用自增量作为主键索引 
### mysql如何优化查询 
### mysql如何在RR隔离级别下避免幻读问题：间隙锁 
### mysql范式和反范式的区别以及彼此的优缺点 
### AOF如何缩减自身文件大小 
### AOF缩减自身文件大小的时候，数据库来了新的操作怎么办？ 
### 多线程了解么？ 
### 死锁条件以及破坏死锁条件的方法 
### volatile做什么用的，如何实现可见性的 
### volatile和atomic的区别 
### atomic底层是如何实现的
