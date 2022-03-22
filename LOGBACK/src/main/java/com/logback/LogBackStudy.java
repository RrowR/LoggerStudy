package com.logback;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: Rrow
 * @Date: 2022/3/22 7:13 下午
 */
public class LogBackStudy {
    /*
        LogBack入门案例     默认的日志级别为debug trace信息没有打印出来
     */
    @Test
    public void Study01(){
        Logger logger = LoggerFactory.getLogger(LogBackStudy.class);
        logger.error("error");
        logger.warn("warn");
        logger.info("info");
        logger.debug("debug");
        logger.trace("trace");
    }

    /*
        logback的配置文件  logback.xml
        一切配置都是在在Configuration标签里进行配置的

     */
    @Test
    public void Study02(){

    }
}
