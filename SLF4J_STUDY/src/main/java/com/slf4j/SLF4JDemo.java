package com.slf4j;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: Rrow
 * @date: 2022/3/1 21:53
 */
public class SLF4JDemo {
    /*
        入门案例
            SLF4J对日志级别的划分
            trace、debug、info、warn、error级别
            trace：跟踪信息      其他不解释
            默认级别是INFO级别
     */
    @Test
    public void Test01() {
        Logger logger = LoggerFactory.getLogger(SLF4JDemo.class);
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
        Logger logger = LoggerFactory.getLogger(SLF4JDemo.class);
        String name = "猫羽雫";
        logger.info("角色名字为:{}", name);
    }

    /*
        日志框架集成对象的引用
     */
    @Test
    public void Test03(){
        Logger logger = LoggerFactory.getLogger(SLF4JDemo.class);
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
        Logger logger = LoggerFactory.getLogger(SLF4JDemo.class);
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

    /*
        NOP 还是和MAVEN顺序有关，谁在上方就先执行
        Actual binding is of type [org.slf4j.helpers.NOPLoggerFactory]
        slf4j-nop 可以禁止所有日志的打印，且必须在依赖顺序的最上方
     */
    @Test
    public void Test05(){
        Logger logger = LoggerFactory.getLogger(SLF4JDemo.class);
        try {
            Class<?> aClass = Class.forName("aaa");
        } catch (ClassNotFoundException e) {
            logger.info("aaa类获取出现了错误");
            logger.info("具体错误是",e);
        }
    }

    /*
        绑定Log4j
        由于Log4j并没有比SLF4J之前出来，并没有遵循SLF4J规范，所以不能直接导入使用

        如果想要使用，必须绑定适配器  slf4j-log4j12 ,再导入log4j的实现

        log4j:WARN No appenders could be found for logger (com.slf4j.SLF4JTest01).
        log4j:WARN Please initialize the log4j system properly.
        log4j:WARN See http://logging.apache.org/log4j/1.2/faq.html#noconfig for more info.

        使用了log4j框架，日志信息没有被打印出来，但是提示显示使用了log4j框架
        提示没有使用  appenders 来进行加载，需要在日志执行前进行加载操作（初始化）
        如果没有配置文件，会爆红显示没有log4j的配置文件，如果有log4j.properties就正常显示配置文件格式的日志
     */
    @Test
    public void Test06(){
        Logger logger = LoggerFactory.getLogger(SLF4JDemo.class);
        logger.trace("trace");
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
    }

    /*
        SLF4J整合JUL(JDK14)

        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-jdk14</artifactId>
            <version>1.7.25</version>
            <scope>test</scope>
        </dependency>
     */
    @Test
    public void Test07(){
        Logger logger = LoggerFactory.getLogger(SLF4JDemo.class);
        logger.trace("trace");
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
    }

}
