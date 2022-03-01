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
    public void Test01() {
        logger.trace("trace");
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
    }

    /*
           输出动态信息
           使用占位符来实现，可以动态地进行展示
        */
    @Test
    public void Test02() {
        String name = "猫羽雫";
        logger.info("角色名字为:{}", name);
    }

    /*
        日志框架集成对象的引用
     */
    @Test
    public void Test03(){
        try {
            Class<?> aClass = Class.forName("aaa");
        } catch (ClassNotFoundException e) {
            logger.info("aaa类获取出现了错误");
            logger.info("具体错误是",e);
        }
    }

    /*
     *      SLF4j绑定日志框架，具体看地址
     *      https://www.slf4j.org/manual.html
     */
    @Test
    public void Test04(){
        /**
         * 绑定了logback
         *  Actual binding is of type [org.slf4j.impl.SimpleLoggerFactory]
         *  Class path contains multiple SLF4J bindings.
         *  使用了logback但是依然使用的是slf4j-simple包，根据包的顺序有关
         *
         *  SLF4J: Actual binding is of type [ch.qos.logback.classic.util.ContextSelectorStaticBinder]
         *  绑定了logback之后就是使用的logback，黑色字体，在实际的应用情况下只需要一种日志实现的集成
         *  在Import包下完全看不到Logback包，这就是日志门面带来的好处，完全看不到感觉,应用只需要记SLF4J的API
         */
        try {
            Class<?> aClass = Class.forName("aaa");
        } catch (ClassNotFoundException e) {
            logger.info("aaa类获取出现了错误");
            logger.info("具体错误是",e);
        }
    }



}
