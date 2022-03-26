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


}
