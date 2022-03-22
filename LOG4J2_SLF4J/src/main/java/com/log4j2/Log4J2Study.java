package com.log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

/**
 * @Author: Rrow
 * @Date: 2022/3/22 5:04 下午
 */
public class Log4J2Study {

    /*
        使用log4j2,log4j2和log4j提供了相同的日志级别输出
        Log4j2级别是error级别的打印

        Using default configuration 缺少配置文件的错误提示
     */
    @Test
    public void Study01(){
        Logger logger = LogManager.getLogger(Log4J2Study.class);
        logger.fatal("fatal");
        logger.error("error");
        logger.warn("warn");
        logger.info("info");
        logger.debug("debug");
        logger.trace("trace");
    }

    /*
        Log4j2 默认加载的是resources下的log4j2.xml文件

     */
    @Test
    public void Log4j2Configuration02(){

    }

}
