## hashMap
### hashMap数据结构
- jdk1.7:
    数组+链表实现
    数组元素为Entry
- jdk1.8+:
    数组+链表，在链表长度大于8时转为红黑树
    用Node代替Entry作为内部数组元素

### hashMap工作原理
    底层是数组+链表的结构，或者数组+红黑树的结构，hashCode相等的key不一定是相等的，所以需要equals方法来比较
    hashMap的hash算法是通过key的高16位和低16位异或得到，这样只要有一位不同，就会产生不同的hash值，尽量减少冲突
- put:
    1. 传入Key和value，首先对key进行hashCode得到hash值，再结合数组长度算的数组下标
    2. 判断下标下如果存在hash冲突，即存在相同hash值的其它key，则使用equals方法判断key是否相等，若key相等，
        进行覆盖，若不相同，则插入头结点(jdk1.7) / 尾结点或红黑树插入(jdk1.8+)
- get:
    1. 传入key，首先对key进行hashCode得到hash值，并算出数组下标
    2. 依照该索引下的链表或者红黑树进行搜索，使用equals方法，当key符合时即返回该元素

### hashMap扩容
    当hashMap中的数组长度大于或等于capacity * loadFactory时，进行扩容，将数组扩为原来的2倍
    扩容只是对数组扩容，每个节点下的链表长度不影响扩容以及不受扩容影响，依然进行8转红黑树的操作
    
### hashMap红黑树
- 每个节点非黑即红
- 根节点必为黑色
- 叶子节点必为黑色空节点
- 红色节点的子节点必定为黑色节点，但是黑子节点的子节点不一样为红色节点
- 从跟节点到叶子节点，所有路径包含的黑色节点数量一致

### hashMap, TreeMap和 LinkedHashMap
- hashMap最常用
- TreeMap需要自己实现Comparator，按照Comparator的顺序排序
- LinkedHashMap按照插入顺序排序

### ConcurrentHashMap
- 线程安全
    1. jdk1.7 之前通过segment继承ReentrantLock做分段锁实现线程安全，每个segment守护多个桶，一个桶包含多个Entry，实际上就是类似于每个segment守护数组的一小段，包括数组下的链表
       每次hash需要进行两次，一次是获取segment的位置，一次是获得具体的桶的位置
    2. jdk1.8+使用CAS+Synchronized实现线程安全；锁粒度为一个Node(即1.7的Entry)，抛弃了桶和segment的实现