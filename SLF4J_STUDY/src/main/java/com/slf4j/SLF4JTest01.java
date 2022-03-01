package com.slf4j;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: Rrow
 * @date: 2022/3/1 21:53
 */
public class SLF4JTest01 {

    /*
        入门案例
            SLF4J对日志级别的划分
            trace、debug、info、warn、error级别
            trace：跟踪信息      其他不解释
            默认级别是INFO级别
     */
    @Test
    public void Test01(){
        Logger logger = LoggerFactory.getLogger(SLF4JTest01.class);
        logger.trace("trace");
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
    }

}
