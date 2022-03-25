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


}
