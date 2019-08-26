# TestSerializer

 Test serialization project

#JMH Benchmark test results for my functions *object2bytesv1* and *bytes2objectv1* 

 "C:\Program Files\Java\jdk1.8.0_162\bin\java" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2017.3.4\lib\idea_rt.jar=59893:C:\Program Files\JetBrains\IntelliJ IDEA 2017.3.4\bin" -Dfile.encoding=UTF-8 -classpath "C:\Program Files\Java\jdk1.8.0_162\jre\lib\charsets.jar;C:\Program Files\Java\jdk1.8.0_162\jre\lib\deploy.jar;C:\Program Files\Java\jdk1.8.0_162\jre\lib\ext\access-bridge-64.jar;C:\Program Files\Java\jdk1.8.0_162\jre\lib\ext\cldrdata.jar;C:\Program Files\Java\jdk1.8.0_162\jre\lib\ext\dnsns.jar;C:\Program Files\Java\jdk1.8.0_162\jre\lib\ext\jaccess.jar;C:\Program Files\Java\jdk1.8.0_162\jre\lib\ext\jfxrt.jar;C:\Program Files\Java\jdk1.8.0_162\jre\lib\ext\localedata.jar;C:\Program Files\Java\jdk1.8.0_162\jre\lib\ext\nashorn.jar;C:\Program Files\Java\jdk1.8.0_162\jre\lib\ext\sunec.jar;C:\Program Files\Java\jdk1.8.0_162\jre\lib\ext\sunjce_provider.jar;C:\Program Files\Java\jdk1.8.0_162\jre\lib\ext\sunmscapi.jar;C:\Program Files\Java\jdk1.8.0_162\jre\lib\ext\sunpkcs11.jar;C:\Program Files\Java\jdk1.8.0_162\jre\lib\ext\zipfs.jar;C:\Program Files\Java\jdk1.8.0_162\jre\lib\javaws.jar;C:\Program Files\Java\jdk1.8.0_162\jre\lib\jce.jar;C:\Program Files\Java\jdk1.8.0_162\jre\lib\jfr.jar;C:\Program Files\Java\jdk1.8.0_162\jre\lib\jfxswt.jar;C:\Program Files\Java\jdk1.8.0_162\jre\lib\jsse.jar;C:\Program Files\Java\jdk1.8.0_162\jre\lib\management-agent.jar;C:\Program Files\Java\jdk1.8.0_162\jre\lib\plugin.jar;C:\Program Files\Java\jdk1.8.0_162\jre\lib\resources.jar;C:\Program Files\Java\jdk1.8.0_162\jre\lib\rt.jar;D:\Projects\idea\TestSerializer\target\classes;C:\Users\Tower\.m2\repository\org\json\json\20190722\json-20190722.jar;C:\Users\Tower\.m2\repository\org\openjdk\jmh\jmh-core\1.21\jmh-core-1.21.jar;C:\Users\Tower\.m2\repository\net\sf\jopt-simple\jopt-simple\4.6\jopt-simple-4.6.jar;C:\Users\Tower\.m2\repository\org\apache\commons\commons-math3\3.2\commons-math3-3.2.jar" com.homework.java.serialize.main.TestSerializer
 # JMH version: 1.21
 # VM version: JDK 1.8.0_162, Java HotSpot(TM) 64-Bit Server VM, 25.162-b12
 # VM invoker: C:\Program Files\Java\jdk1.8.0_162\jre\bin\java.exe
 # VM options: -Xms2G -Xmx2G
 # Warmup: 3 iterations, 10 s each
 # Measurement: 8 iterations, 10 s each
 # Timeout: 10 min per iteration
 # Threads: 1 thread, will synchronize iterations
 # Benchmark mode: Average time, time/op
 # Benchmark: com.homework.java.serialize.main.TestSerializer.loopFor
 # Parameters: (N = 100)
 
 # Run progress: 0,00% complete, ETA 00:07:20
 # Fork: 1 of 1
 # Warmup Iteration   1: 0,001 ms/op
 # Warmup Iteration   2: 0,001 ms/op
 # Warmup Iteration   3: 0,001 ms/op
 Iteration   1: 0,001 ms/op
 Iteration   2: 0,001 ms/op
 Iteration   3: 0,001 ms/op
 Iteration   4: 0,001 ms/op
 Iteration   5: 0,001 ms/op
 Iteration   6: 0,001 ms/op
 Iteration   7: 0,001 ms/op
 Iteration   8: 0,001 ms/op
 
 
 Result "com.homework.java.serialize.main.TestSerializer.loopFor":
   0,001 ±(99.9%) 0,001 ms/op [Average]
   (min, avg, max) = (0,001, 0,001, 0,001), stdev = 0,001
   CI (99.9%): [0,001, 0,001] (assumes normal distribution)
 
 
 # JMH version: 1.21
 # VM version: JDK 1.8.0_162, Java HotSpot(TM) 64-Bit Server VM, 25.162-b12
 # VM invoker: C:\Program Files\Java\jdk1.8.0_162\jre\bin\java.exe
 # VM options: -Xms2G -Xmx2G
 # Warmup: 3 iterations, 10 s each
 # Measurement: 8 iterations, 10 s each
 # Timeout: 10 min per iteration
 # Threads: 1 thread, will synchronize iterations
 # Benchmark mode: Average time, time/op
 # Benchmark: com.homework.java.serialize.main.TestSerializer.loopForEach
 # Parameters: (N = 100)
 
 # Run progress: 25,00% complete, ETA 00:05:33
 # Fork: 1 of 1
 # Warmup Iteration   1: 0,001 ms/op
 # Warmup Iteration   2: 0,001 ms/op
 # Warmup Iteration   3: 0,001 ms/op
 Iteration   1: 0,001 ms/op
 Iteration   2: 0,001 ms/op
 Iteration   3: 0,001 ms/op
 Iteration   4: 0,001 ms/op
 Iteration   5: 0,001 ms/op
 Iteration   6: 0,001 ms/op
 Iteration   7: 0,001 ms/op
 Iteration   8: 0,001 ms/op
 
 
 Result "com.homework.java.serialize.main.TestSerializer.loopForEach":
   0,001 ±(99.9%) 0,001 ms/op [Average]
   (min, avg, max) = (0,001, 0,001, 0,001), stdev = 0,001
   CI (99.9%): [0,001, 0,001] (assumes normal distribution)
 
 
 # JMH version: 1.21
 # VM version: JDK 1.8.0_162, Java HotSpot(TM) 64-Bit Server VM, 25.162-b12
 # VM invoker: C:\Program Files\Java\jdk1.8.0_162\jre\bin\java.exe
 # VM options: -Xms2G -Xmx2G
 # Warmup: 3 iterations, 10 s each
 # Measurement: 8 iterations, 10 s each
 # Timeout: 10 min per iteration
 # Threads: 1 thread, will synchronize iterations
 # Benchmark mode: Average time, time/op
 # Benchmark: com.homework.java.serialize.main.TestSerializer.loopIterator
 # Parameters: (N = 100)
 
 # Run progress: 50,00% complete, ETA 00:03:41
 # Fork: 1 of 1
 # Warmup Iteration   1: 0,001 ms/op
 # Warmup Iteration   2: 0,001 ms/op
 # Warmup Iteration   3: 0,001 ms/op
 Iteration   1: 0,001 ms/op
 Iteration   2: 0,001 ms/op
 Iteration   3: 0,001 ms/op
 Iteration   4: 0,001 ms/op
 Iteration   5: 0,001 ms/op
 Iteration   6: 0,001 ms/op
 Iteration   7: 0,001 ms/op
 Iteration   8: 0,001 ms/op
 
 
 Result "com.homework.java.serialize.main.TestSerializer.loopIterator":
   0,001 ±(99.9%) 0,001 ms/op [Average]
   (min, avg, max) = (0,001, 0,001, 0,001), stdev = 0,001
   CI (99.9%): [0,001, 0,001] (assumes normal distribution)
 
 
 # JMH version: 1.21
 # VM version: JDK 1.8.0_162, Java HotSpot(TM) 64-Bit Server VM, 25.162-b12
 # VM invoker: C:\Program Files\Java\jdk1.8.0_162\jre\bin\java.exe
 # VM options: -Xms2G -Xmx2G
 # Warmup: 3 iterations, 10 s each
 # Measurement: 8 iterations, 10 s each
 # Timeout: 10 min per iteration
 # Threads: 1 thread, will synchronize iterations
 # Benchmark mode: Average time, time/op
 # Benchmark: com.homework.java.serialize.main.TestSerializer.loopWhile
 # Parameters: (N = 100)
 
 # Run progress: 75,00% complete, ETA 00:01:50
 # Fork: 1 of 1
 # Warmup Iteration   1: 0,001 ms/op
 # Warmup Iteration   2: 0,001 ms/op
 # Warmup Iteration   3: 0,001 ms/op
 Iteration   1: 0,001 ms/op
 Iteration   2: 0,001 ms/op
 Iteration   3: 0,001 ms/op
 Iteration   4: 0,001 ms/op
 Iteration   5: 0,001 ms/op
 Iteration   6: 0,001 ms/op
 Iteration   7: 0,001 ms/op
 Iteration   8: 0,001 ms/op
 
 
 Result "com.homework.java.serialize.main.TestSerializer.loopWhile":
   0,001 ±(99.9%) 0,001 ms/op [Average]
   (min, avg, max) = (0,001, 0,001, 0,001), stdev = 0,001
   CI (99.9%): [0,001, 0,001] (assumes normal distribution)
 
 
 # Run complete. Total time: 00:07:23
 
 Benchmark                    (N)  Mode  Cnt  Score    Error  Units
 TestSerializer.loopFor       100  avgt    8  0,001 ±  0,001  ms/op
 TestSerializer.loopForEach   100  avgt    8  0,001 ±  0,001  ms/op
 TestSerializer.loopIterator  100  avgt    8  0,001 ±  0,001  ms/op
 TestSerializer.loopWhile     100  avgt    8  0,001 ±  0,001  ms/op

#JMH Benchmark test results for standard functions *object2bytes* and *bytes2object*
 
"C:\Program Files\Java\jdk1.8.0_162\bin\java" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2017.3.4\lib\idea_rt.jar=52799:C:\Program Files\JetBrains\IntelliJ IDEA 2017.3.4\bin" -Dfile.encoding=UTF-8 -classpath "C:\Program Files\Java\jdk1.8.0_162\jre\lib\charsets.jar;C:\Program Files\Java\jdk1.8.0_162\jre\lib\deploy.jar;C:\Program Files\Java\jdk1.8.0_162\jre\lib\ext\access-bridge-64.jar;C:\Program Files\Java\jdk1.8.0_162\jre\lib\ext\cldrdata.jar;C:\Program Files\Java\jdk1.8.0_162\jre\lib\ext\dnsns.jar;C:\Program Files\Java\jdk1.8.0_162\jre\lib\ext\jaccess.jar;C:\Program Files\Java\jdk1.8.0_162\jre\lib\ext\jfxrt.jar;C:\Program Files\Java\jdk1.8.0_162\jre\lib\ext\localedata.jar;C:\Program Files\Java\jdk1.8.0_162\jre\lib\ext\nashorn.jar;C:\Program Files\Java\jdk1.8.0_162\jre\lib\ext\sunec.jar;C:\Program Files\Java\jdk1.8.0_162\jre\lib\ext\sunjce_provider.jar;C:\Program Files\Java\jdk1.8.0_162\jre\lib\ext\sunmscapi.jar;C:\Program Files\Java\jdk1.8.0_162\jre\lib\ext\sunpkcs11.jar;C:\Program Files\Java\jdk1.8.0_162\jre\lib\ext\zipfs.jar;C:\Program Files\Java\jdk1.8.0_162\jre\lib\javaws.jar;C:\Program Files\Java\jdk1.8.0_162\jre\lib\jce.jar;C:\Program Files\Java\jdk1.8.0_162\jre\lib\jfr.jar;C:\Program Files\Java\jdk1.8.0_162\jre\lib\jfxswt.jar;C:\Program Files\Java\jdk1.8.0_162\jre\lib\jsse.jar;C:\Program Files\Java\jdk1.8.0_162\jre\lib\management-agent.jar;C:\Program Files\Java\jdk1.8.0_162\jre\lib\plugin.jar;C:\Program Files\Java\jdk1.8.0_162\jre\lib\resources.jar;C:\Program Files\Java\jdk1.8.0_162\jre\lib\rt.jar;D:\Projects\idea\TestSerializer\target\classes;C:\Users\Tower\.m2\repository\org\json\json\20190722\json-20190722.jar;C:\Users\Tower\.m2\repository\org\openjdk\jmh\jmh-core\1.21\jmh-core-1.21.jar;C:\Users\Tower\.m2\repository\net\sf\jopt-simple\jopt-simple\4.6\jopt-simple-4.6.jar;C:\Users\Tower\.m2\repository\org\apache\commons\commons-math3\3.2\commons-math3-3.2.jar" com.homework.java.serialize.main.TestSerializer
# JMH version: 1.21
# VM version: JDK 1.8.0_162, Java HotSpot(TM) 64-Bit Server VM, 25.162-b12
# VM invoker: C:\Program Files\Java\jdk1.8.0_162\jre\bin\java.exe
# VM options: -Xms2G -Xmx2G
# Warmup: 3 iterations, 10 s each
# Measurement: 8 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: com.homework.java.serialize.main.TestSerializer.loopFor
# Parameters: (N = 100)

# Run progress: 0,00% complete, ETA 00:07:20
# Fork: 1 of 1
# Warmup Iteration   1: 0,001 ms/op
# Warmup Iteration   2: 0,001 ms/op
# Warmup Iteration   3: 0,001 ms/op
Iteration   1: 0,001 ms/op
Iteration   2: 0,001 ms/op
Iteration   3: 0,001 ms/op
Iteration   4: 0,001 ms/op
Iteration   5: 0,001 ms/op
Iteration   6: 0,001 ms/op
Iteration   7: 0,001 ms/op
Iteration   8: 0,001 ms/op


Result "com.homework.java.serialize.main.TestSerializer.loopFor":
  0,001 ±(99.9%) 0,001 ms/op [Average]
  (min, avg, max) = (0,001, 0,001, 0,001), stdev = 0,001
  CI (99.9%): [0,001, 0,001] (assumes normal distribution)


# JMH version: 1.21
# VM version: JDK 1.8.0_162, Java HotSpot(TM) 64-Bit Server VM, 25.162-b12
# VM invoker: C:\Program Files\Java\jdk1.8.0_162\jre\bin\java.exe
# VM options: -Xms2G -Xmx2G
# Warmup: 3 iterations, 10 s each
# Measurement: 8 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: com.homework.java.serialize.main.TestSerializer.loopForEach
# Parameters: (N = 100)

# Run progress: 25,00% complete, ETA 00:05:34
# Fork: 1 of 1
# Warmup Iteration   1: 0,001 ms/op
# Warmup Iteration   2: 0,001 ms/op
# Warmup Iteration   3: 0,001 ms/op
Iteration   1: 0,001 ms/op
Iteration   2: 0,001 ms/op
Iteration   3: 0,001 ms/op
Iteration   4: 0,001 ms/op
Iteration   5: 0,001 ms/op
Iteration   6: 0,001 ms/op
Iteration   7: 0,001 ms/op
Iteration   8: 0,001 ms/op


Result "com.homework.java.serialize.main.TestSerializer.loopForEach":
  0,001 ±(99.9%) 0,001 ms/op [Average]
  (min, avg, max) = (0,001, 0,001, 0,001), stdev = 0,001
  CI (99.9%): [0,001, 0,001] (assumes normal distribution)


# JMH version: 1.21
# VM version: JDK 1.8.0_162, Java HotSpot(TM) 64-Bit Server VM, 25.162-b12
# VM invoker: C:\Program Files\Java\jdk1.8.0_162\jre\bin\java.exe
# VM options: -Xms2G -Xmx2G
# Warmup: 3 iterations, 10 s each
# Measurement: 8 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: com.homework.java.serialize.main.TestSerializer.loopIterator
# Parameters: (N = 100)

# Run progress: 50,00% complete, ETA 00:03:42
# Fork: 1 of 1
# Warmup Iteration   1: 0,001 ms/op
# Warmup Iteration   2: 0,001 ms/op
# Warmup Iteration   3: 0,001 ms/op
Iteration   1: 0,001 ms/op
Iteration   2: 0,001 ms/op
Iteration   3: 0,001 ms/op
Iteration   4: 0,001 ms/op
Iteration   5: 0,001 ms/op
Iteration   6: 0,001 ms/op
Iteration   7: 0,001 ms/op
Iteration   8: 0,001 ms/op


Result "com.homework.java.serialize.main.TestSerializer.loopIterator":
  0,001 ±(99.9%) 0,001 ms/op [Average]
  (min, avg, max) = (0,001, 0,001, 0,001), stdev = 0,001
  CI (99.9%): [0,001, 0,001] (assumes normal distribution)


# JMH version: 1.21
# VM version: JDK 1.8.0_162, Java HotSpot(TM) 64-Bit Server VM, 25.162-b12
# VM invoker: C:\Program Files\Java\jdk1.8.0_162\jre\bin\java.exe
# VM options: -Xms2G -Xmx2G
# Warmup: 3 iterations, 10 s each
# Measurement: 8 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: com.homework.java.serialize.main.TestSerializer.loopWhile
# Parameters: (N = 100)

# Run progress: 75,00% complete, ETA 00:01:51
# Fork: 1 of 1
# Warmup Iteration   1: 0,001 ms/op
# Warmup Iteration   2: 0,001 ms/op
# Warmup Iteration   3: 0,001 ms/op
Iteration   1: 0,001 ms/op
Iteration   2: 0,001 ms/op
Iteration   3: 0,001 ms/op
Iteration   4: 0,001 ms/op
Iteration   5: 0,001 ms/op
Iteration   6: 0,001 ms/op
Iteration   7: 0,001 ms/op
Iteration   8: 0,001 ms/op


Result "com.homework.java.serialize.main.TestSerializer.loopWhile":
  0,001 ±(99.9%) 0,001 ms/op [Average]
  (min, avg, max) = (0,001, 0,001, 0,001), stdev = 0,001
  CI (99.9%): [0,001, 0,001] (assumes normal distribution)


# Run complete. Total time: 00:07:23

Benchmark                    (N)  Mode  Cnt  Score    Error  Units
TestSerializer.loopFor       100  avgt    8  0,001 ±  0,001  ms/op
TestSerializer.loopForEach   100  avgt    8  0,001 ±  0,001  ms/op
TestSerializer.loopIterator  100  avgt    8  0,001 ±  0,001  ms/op
TestSerializer.loopWhile     100  avgt    8  0,001 ±  0,001  ms/op

