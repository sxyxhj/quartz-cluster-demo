Quartz Cluster Demo：

基于Quartz 2.3.0

DB Tables:

https://github.com/quartz-scheduler/quartz/blob/v2.3.2/quartz-core/src/main/resources/org/quartz/impl/jdbcjobstore/tables_mysql_innodb.sql



Table信息介绍

```
qrtz_blob_triggers : 以Blob 类型存储的触发器。

qrtz_calendars存储Quartz的Calendar信息

qrtz_cron_triggers存储CronTrigger，包括Cron表达式和时区信息

qrtz_fired_triggers存储与已触发的Trigger相关的状态信息，以及相联Job的执行信息

qrtz_job_details存储每一个已配置的Job的详细信息

qrtz_locks存储程序的悲观锁的信息

qrtz_paused_trigger_grps存储已暂停的Trigger组的信息

qrtz_scheduler_state存储少量的有关Scheduler的状态信息，和别的Scheduler实例

qrtz_simple_triggers存储简单的Trigger，包括重复次数、间隔、以及已触的次数

qrtz_simprop_triggers   存储CalendarIntervalTrigger和DailyTimeIntervalTrigger两种类型的触发器

qrtz_triggers存储已配置的Trigger的信息
```



测试运行：
1. POM文件中添加如下的配置，

2. 然后运行mvn package打包,

   ```xml
       <build>
           <plugins>
               <plugin>
                   <groupId>org.apache.maven.plugins</groupId>
                   <artifactId>maven-compiler-plugin</artifactId>
                   <version>3.8.1</version>
                   <configuration>
                       <source>1.8</source>
                       <target>1.8</target>
                       <encoding>UTF-8</encoding>
                   </configuration>
               </plugin>
               <plugin>
                   <groupId>org.springframework.boot</groupId>
                   <artifactId>spring-boot-maven-plugin</artifactId>
                   <version>2.3.7.RELEASE</version>
                   <configuration>
                       <mainClass>org.sxyxhj.quartzclusterdemo.QuartzClusterDemoApplication</mainClass>
                   </configuration>
                   <executions>
                       <execution>
                           <goals>
                               <goal>repackage</goal>
                           </goals>
                       </execution>
                   </executions>
               </plugin>
               <plugin>
                   <groupId>org.apache.maven.plugins</groupId>
                   <artifactId>maven-surefire-plugin</artifactId>
                   <configuration>
                       <skipTests>true</skipTests>
                   </configuration>
               </plugin>
   
           </plugins>
       </build>
   ```

   

3. 运行java -jar xxx.jar, 本地可以更改端口号模拟不同的服务器

 

关注的点：

```
是否支持集群模式
任务是否能动态调整
任务执行策略
```

