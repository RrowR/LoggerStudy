package com.slf4j;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: Rrow
 * @date: 2022/3/1 21:53
 */
public class SLF4JTest01 {
    Logger logger = LoggerFactory.getLogger(SLF4JTest01.class);
    /*
        入门案例
            SLF4J对日志级别的划分
            trace、debug、info、warn、error级别
            trace：跟踪信息      其他不解释
            默认级别是INFO级别
     */
    @Test
    public void Test01(){
        logger.trace("trace");
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
    }

    @Test
    public void Test02(){
        /*
            输出动态信息
            使用占位符来实现，可以动态地进行展示
         */
        String name = "猫羽雫";
        logger.info("角色名字为:{}",name);
    }

}
