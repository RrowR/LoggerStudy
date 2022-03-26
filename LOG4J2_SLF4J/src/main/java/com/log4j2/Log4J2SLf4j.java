package com.log4j2;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: Rrow
 * @Date: 2022/3/22 5:04 下午
 */
public class Log4J2SLf4j {
    /*
        使用日志门面来操作log4j2
     */
    @Test
    public void StudyLog4JAndSLf4j() {
        Logger logger = LoggerFactory.getLogger(Log4J2SLf4j.class);
        logger.error("error");
        logger.warn("warn");
        logger.info("info");
        logger.debug("debug");
        logger.trace("trace");
    }

    /*
        写入到文件
     */
    @Test
    public void StudyLog4JAndSLf4j2() {
        Logger logger = LoggerFactory.getLogger(Log4J2SLf4j.class);
        logger.error("error");
        logger.warn("warn");
        logger.info("info");
        logger.debug("debug");
        logger.trace("trace");
    }

    /*
        滚动日志记录数据
     */
    @Test
    public void rollingFile() {
        Logger logger = LoggerFactory.getLogger(Log4J2SLf4j.class);
        for (int i = 0; i < 2000; i++) {
            logger.error("error");
            logger.warn("warn");
            logger.info("info");
            logger.debug("debug");
            logger.trace("trace");
        }
    }

    /*
        异步日志的实现
            方式1：使用AsyncAppender方式
                -- 添加异步日志依赖
                <dependency>
                    <groupId>com.lmax</groupId>
                    <artifactId>disruptor</artifactId>
                    <version>3.3.7</version>
                </dependency>

                <Async name="asyncLog">
                    <AppenderRef ref="Console"></AppenderRef>
                </Async>

                可以提升效率
     */
    @Test
    public void asyncLog() {
        Logger logger = LoggerFactory.getLogger(Log4J2SLf4j.class);
        for (int i = 0; i < 100; i++) {
            logger.error("error");
            logger.warn("warn");
            logger.info("info");
            logger.debug("debug");
            logger.trace("trace");
        }
        // 非异步的情况下，还是处于阻塞的状态
        for (int i = 0; i < 500; i++) {
            System.out.println("我是system.out");
        }
    }

    /*
        全局异步日志     文件名为: log4j2.component.properties
            方式2: 使用AsyncLogger的方式
            创建 log4j2.component.properties 文件 到resouces下 ，内容如下
                # 全局异步日志配置
                Log4jContextSelector=org.apache.logging.log4j.core.async.AsyncLoggerContextSelector
            log4j2.xml 的异步配置旧可以去掉了
     */
    @Test
    public void globalAsyncLog() {
        Logger logger = LoggerFactory.getLogger(Log4J2SLf4j.class);
        for (int i = 0; i < 100; i++) {
            logger.error("error");
            logger.warn("warn");
            logger.info("info");
            logger.debug("debug");
            logger.trace("trace");
        }
        // 非异步的情况下，还是处于阻塞的状态
        for (int i = 0; i < 500; i++) {
            System.out.println("我是system.out");
        }
    }

    /*
        混合异步日志：同时使用同步和异步日志

            要注意关闭全局异步日志
        Log4J2SLf4j 类是属于  com.log4j2 包下的，所以是异步的，否则就是同步的
        <AsyncLogger name="com.log4j2" level="trace" includeLocation="false" additivity="false">
            <!-- 将控制台的输出设置为异步打印 -->
            <AppenderRef ref="Console"/>
        </AsyncLogger>

        AsyncLogger 和 AsyncAppender 不要同时出现，没有这个需求，效果也不会叠加，如果同时出现，效率将以最低的 AsyncLogger 为主

        AsyncLogger的全局异步和混合异步也不要同时出现        效果也不会叠加，没有这个需求的话

     */
    @Test
    public void mixedAsyncLog(){
        Logger logger = LoggerFactory.getLogger(Log4J2SLf4j.class);
        for (int i = 0; i < 1000; i++) {
            logger.error("error");
            logger.warn("warn");
            logger.info("info");
            logger.debug("debug");
            logger.trace("trace");
        }
        // 非异步的情况下，还是处于阻塞的状态
        for (int i = 0; i < 500; i++) {
            System.out.println("我是system.out");
        }
    }


}
