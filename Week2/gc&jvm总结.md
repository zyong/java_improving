### JVM总结
JVM是java的运行环境，从实现来说其模拟了硬件的一些，相当于在底层硬件和上层软件直接又抽象了一层，使软件实现与底层硬件解耦，极大的提升了开发效率。
JVM在内存结构上分为：

    线程栈 - 堆  - 非堆 - JVM自身
  
      |- 栈帧 - 栈帧 - 栈帧
      

线程执行过程中，一般会有多个方法组成调用栈，就会创建对应的栈帧。
栈帧中包括当前方法的原始类型局部变量，不包括类实例对象，对于类实例对象变量只存储其引用，类实例保存在堆中。

堆的划分包括：
1. Younggen
2. Oldgen
3. Eden 
4. S0 S1

非堆中包括
1. Metaspace 常量池
2. class cache
3. compressed class

堆区空间的使用逻辑
1. 新建对象先放到Younggen中的eden区，当eden满了，gc就开始工作，停止应用程序运行，开始收集垃圾，把还存活的对象移动到S0区，回收垃圾对象
2. 等eden区再满了，就将S0和eden的活着的对象移动到S1区，并删除垃圾对象
3. 对于达到阈值的对象，会移动到old区，默认阈值是15次



### GC 总结
1 串行GC在由于每次都是单线程集中处理，导致每次处理时间较长，对于使用大量内存的项目，会有很大的应用暂停风险，导致延迟增加
2 并行GC简单说在串行GC的基础上增加了多线程并行处理，其执行频次增加，但是每次指向的时间会更短
3 CMS GC在Minor GC时会暂停所有的应用线程，并以多线程的方式进行垃圾回收。在Full GC时不再暂停应用线程，而是使用若干个后台线程定期的对老年代空间进行扫描，及时回收其中不再使用的对象。
4 G1 的设计初衷是为了尽量缩短处理超大堆（大于4GB）时产生的停顿。相对于CMS的优势而言是内存碎片的产生率大大降低。


#### JAVA8默认参数执行

##### $: /usr/lib/jvm/java-8-openjdk-amd64/bin/java -XX:+PrintGCDetails mark.GCLogAnalysis

1. JVM内存分配起始值有240M，所以出现了很多次的GC和FULLGC
2. 第一次YoungGC从64M清理到10M，清理54M数据，Young区大小为74M
堆内存从64M，清理到22M，用时2.6ms
3. 经过3次youngGC后执行一次full GC，Young区从10M直接清到0，old区从119M清理到117M
堆内存增长到524M，堆内存从128M清理到117M，meta区为2.8M，清理前后没有变化
4. 由于分配内存偏小导致，频繁的youngGC和fullGC，需要调大启动内存设置


#### Java8 设置最大堆内存1g和最小1g
##### $: /usr/lib/jvm/java-8-openjdk-amd64/bin/java -Xmx1g -Xms1g -XX:+PrintGCDetails -XX:+PrintGCDateStamps com.week2.GCLogAnalysis

 
1. 执行younggc和fullgc情况明显优化，整体只出现3次fullGC
2. young区分配内存一直在160M-300M之间，堆分配内存为1G，第一次younggc执行7.8ms，young区从262M减少到43M，
堆内存使用从262M减少到85M，young区和堆内存使用情况一致
3. 当执行了13次youngc后执行一次fullgc，young区直接减少到0，old区从624M减少到330M 堆内存维持在932M，meta区为2.8M，耗时37毫秒


#### Java8 设置串行GC
 ##### $: /usr/lib/jvm/java-8-openjdk-amd64/bin/java -Xmx1g -Xms1g -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+UseSerialGC  com.week2.GCLogAnalysis
1. 改为串行GC后，出现两次fullgc，younggc分配314M空间，堆始终是1G空间，每次young区都会被用完，然后执行一次gc
2. GC时间每次都有30ms


#### Java8 设置并行GC
##### $: /usr/lib/jvm/java-8-openjdk-amd64/bin/java -Xmx1g -Xms1g -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+UseParallelGC  com.week2.GCLogAnalysis

1. 可以看到这次使用的结果和第一次是很相似的，因为java8默认是用的并行gc策略

#### Java8 设置CMSGC
##### $: /usr/lib/jvm/java-8-openjdk-amd64/bin/java -Xmx1g -Xms1g -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+UseConcMarkSweepGC  com.week2.GCLogAnalysis

1、Initial Mark
2、Concurrent Mark
3、Concurrent preclean
4、Final Mark
5、Concurrent sweep
6、Concurrent Reset


#### Java8 设置GC1
##### $: /usr/lib/jvm/java-8-openjdk-amd64/bin/java -Xmx1g -Xms1g -XX:+PrintGC -XX:+PrintGCDateStamps -XX:+UseG1GC  com.week2.GCLogAnalysis

Evacuation Pause：young 纯年轻代模式转移暂停
Concurrent Mark 并发标记
阶段1：Initial Mark 出师标记
阶段2：Root Region Scan Root区扫描
阶段3：Concurrent Mark 并发标记
阶段4：Remark 再次标记
阶段5：Cleanup 清理
Evacuation Pause (mixed) 转移暂停：混合模式
Full GC (Allocation Failure)