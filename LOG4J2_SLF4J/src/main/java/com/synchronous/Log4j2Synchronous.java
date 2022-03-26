package com.synchronous;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: Rrow
 * @date: 2022/3/26 16:02
 */
public class Log4j2Synchronous {
    /*  这个包不在自定义一部日志的路径下
    *   测试另外包下是否是同步的日志，因为mix日志并没有生效在这里
    *   tip: 一定要关闭全局异步日志
    * */
    @Test
    public void TestSynchronous(){
        Logger logger = LoggerFactory.getLogger(Log4j2Synchronous.class);
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
