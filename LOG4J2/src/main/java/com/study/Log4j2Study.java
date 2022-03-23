package com.study;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

/**
 * @author: Rrow
 * @date: 2022/3/23 23:14
 */
public class Log4j2Study {

    /*
        使用log4j2,log4j2和log4j提供了相同的日志级别输出
        Log4j2级别是error级别的打印
        Using default configuration 缺少配置文件的错误提示
     */
    @Test
    public void Study01(){
        Logger logger = LogManager.getLogger(Log4j2Study.class);
        logger.fatal("fatal");
        logger.error("error");
        logger.warn("warn");
        logger.info("info");
        logger.debug("debug");
        logger.trace("trace");
    }

    /*
        Log4j2 默认加载的是resources下的log4j2.xml文件，抄袭了logback
        <Configuration status="debug" monitorInterval="5">
        status="debug"      默认是指级别
        monitorInterval     自动刷新时间5秒
     */
    @Test
    public void Log4j2Configuration02(){
        Logger logger = LogManager.getLogger(Log4j2Study.class);
        logger.fatal("fatal");
        logger.error("error");
        logger.warn("warn");
        logger.info("info");
        logger.debug("debug");
        logger.trace("trace");
    }
}
