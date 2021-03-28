
## JAVA8默认参数执行

/usr/lib/jvm/java-8-openjdk-amd64/bin/java -XX:+PrintGCDetails com.mark.GCLogAnalysis

1、JVM内存分配起始值有240M，所以出现了很多次的GC和FULL gc
2、第一次YoungGC从64M清理到10M，清理54M数据，Young区大小为74M
堆内存从64M，清理到22M，用时2.6ms
3、经过3次youngGC后执行一次full GC，Young区从10M直接清到0，old区从119M清理到117M
堆内存增长到524M，堆内存从128M清理到117M，meta区为2.8M，清理前后没有变化
4、由于分配内存偏小导致，频繁的youngGC和fullGC，需要调大启动内存设置

/usr/lib/jvm/java-8-openjdk-amd64/bin/java -Xmx1g -Xms1g -XX:+PrintGCDetails -XX:+PrintGCDateStamps com.week2.GCLogAnalysis
设置最大堆内存1g和最小1g
 
 执行younggc和fullgc情况明显优化，整体只出现3次fullGC
1、young区分配内存一直在160M-300M之间，堆分配内存为1G，第一次younggc执行7.8ms，young区从262M减少到43M，
堆内存使用从262M减少到85M，young区和堆内存使用情况一致
2、当执行了13次youngc后执行一次fullgc，young区直接减少到0，old区从624M减少到330M 堆内存维持在932M，meta区为2.8M，耗时37毫秒


 /usr/lib/jvm/java-8-openjdk-amd64/bin/java -Xmx1g -Xms1g -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+UseSerialGC  com.week2.GCLogAnalysis
1、改为串行GC后，出现两次fullgc，younggc分配314M空间，堆始终是1G空间，每次young区都会被用完，然后执行一次gc
2、GC时间每次都有30ms


/usr/lib/jvm/java-8-openjdk-amd64/bin/java -Xmx1g -Xms1g -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+UseParallelGC  com.week2.GCLogAnalysis

可以看到这次使用的结果和第一次是很相似的，因为java8默认是用的并行gc策略

/usr/lib/jvm/java-8-openjdk-amd64/bin/java -Xmx1g -Xms1g -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+UseConcMarkSweepGC  com.week2.GCLogAnalysis

1、Initial Mark
2、Concurrent Mark
3、Concurrent preclean
4、Final Mark
5、Concurrent sweep
6、Concurrent Reset


 /usr/lib/jvm/java-8-openjdk-amd64/bin/java -Xmx1g -Xms1g -XX:+PrintGC -XX:+PrintGCDateStamps -XX:+UseG1GC  com.week2.GCLogAnalysis

Evacuation Pause：young 纯年轻代模式转移暂停
Concurrent Mark 并发标记
阶段1：Initial Mark 出师标记
阶段2：Root Region Scan Root区扫描
阶段3：Concurrent Mark 并发标记
阶段4：Remark 再次标记
阶段5：Cleanup 清理
Evacuation Pause (mixed) 转移暂停：混合模式
Full GC (Allocation Failure)