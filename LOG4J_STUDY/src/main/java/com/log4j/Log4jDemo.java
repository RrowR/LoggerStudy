package com.log4j;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.helpers.LogLog;
import org.junit.Test;

/**
 * @author: Rrow
 * @date: 2022/3/1 23:02
 */
public class Log4jDemo {
    /**
     * ConsoleAppender                  日志输出到控制台
     * FileAppender                     日志输出到文件
     * DailyRollingFileAppender         将日志每天输出到一个新的日志文件
     * RollingFileAppender              将日志输出到文件，当日志文件达到指定大小的时候，会自动把文件改名，同事产生一个新的文件
     * JDBCAppender                     把日志记录到数据库中
     */
    @Test
    public void Test01() {
        /**
         * log4j入门案例
         *      log4j:WARN No appenders could be found for logger (com.log4j.Log4jDemo).
         *      log4j:WARN Please initialize the log4j system properly.
         *      log4j:WARN See http://logging.apache.org/log4j/1.2/faq.html#noconfig for more info.
         *
         *  BasicConfigurator.configure();  加载初始化信息
         *
         *  日志级别说明:
         *      Log4j提供了8个级别的日志输出
         *      ALL 最低等级    用户打开所有级别的日志记录
         *      TRACE   程序推进下的追踪信息，这个追踪信息的日志级别非常低，一般情况下是不会使用的
         *      DEBUG   指出细粒度信息时间对调式非常有用，主要是配合开发        默认级别
         *      INFO    信息的粗细粒度级别运行信息
         *      WARN    警告，程序在运行的过程中可能会出现的隐形错误
         *      ERROR   错误信息，发生的错误不印象错误的信息
         *      FATAL   表示严重错误，程序会不能运行,表示程序停止运行
         *      OFF     最高级别，用户关闭了所有日志记录
         */
        // Log4j默认的初始化设置
        Logger logger = Logger.getLogger(Log4jDemo.class);
        BasicConfigurator.configure();
        logger.info("info msg");
    }

    @Test
    public void Test02() {
        Logger logger = Logger.getLogger(Log4jDemo.class);
        BasicConfigurator.configure();
        logger.fatal("fatal");
        logger.error("error");
        logger.warn("warn");
        logger.info("info");
        logger.debug("debug");
        logger.trace("trace");          // 默认不显示
    }

    /*
        配置文件的使用
            1.BasicConfigurator.configure();
                (1)加载了Logger root = Logger.getRootLogger();
                (2)root.addAppender(new ConsoleAppender(new PatternLayout(PatternLayout.TTCC_CONVERSION_PATTERN))); 表示默认打印到控制台，自定义格式输出
            2.使用自定义的配置文件

        static public Logger getLogger(Class clazz) {
            return LogManager.getLogger(clazz.getName());
        }
        LogManager 里面的属性
        static public final String DEFAULT_CONFIGURATION_FILE = "log4j.properties";
        static final String DEFAULT_XML_CONFIGURATION_FILE = "log4j.xml";
	}
     */
    @Test
    public void Test03() {
        Logger logger = Logger.getLogger(Log4jDemo.class);
        BasicConfigurator.configure();
        logger.fatal("fatal");
        logger.error("error");
        logger.warn("warn");
        logger.info("info");
        logger.debug("debug");
        logger.trace("trace");          // 默认不显示
    }

    /*
        日志输出详细信息开关
     */
    @Test
    public void Test04() {
        LogLog.setInternalDebugging(true);          // 一定要放到前面
        Logger logger = Logger.getLogger(Log4jDemo.class);
        logger.fatal("fatal");
        logger.error("error");
        logger.warn("warn");
        logger.info("info");
        logger.debug("debug");
        logger.trace("trace");          // 默认不显示
    }

    /**
     * 设置layout输出格式
     * org.apache.log4j.SimpleLayout
     * org.apache.log4j.HTMLLayout
     * ...
     */
    @Test
    public void Test05() {
        //LogLog.setInternalDebugging(true);          // 一定要放到前面
        Logger logger = Logger.getLogger(Log4jDemo.class);
        new PatternLayout();
        logger.fatal("fatal消息");
        logger.error("error消息");
        logger.warn("warn消息");
        logger.info("info消息");
        logger.debug("debug消息");
        logger.trace("trace消息");
    }

    /*
        日志记录到文件
        FileAppender            记录到文件
        RollingFileAppender     拆分记录到文件
     */
    @Test
    public void Test06() {
        Logger logger = Logger.getLogger(Log4jDemo.class);
        for (int i = 0; i < 100; i++) {
            logger.fatal("fatal消息");
            logger.error("error消息");
            logger.warn("warn消息");
            logger.info("info消息");
            logger.debug("debug消息");
            logger.trace("trace消息");
        }
    }

    /**
     * DailyRollingFileAppender     按照天来进行拆分
     */
    @Test
    public void Test07() {
        Logger logger = Logger.getLogger(Log4jDemo.class);
        logger.fatal("fatal消息");
        logger.error("error消息");
        logger.warn("warn消息");
        logger.info("info消息");
        logger.debug("debug消息");
        logger.trace("trace消息");
    }

    /**
     * 将日志输出到数据库中
     */
    @Test
    public void Test08() {
        Logger logger = Logger.getLogger(Log4jDemo.class);
        logger.fatal("fatal消息");
        logger.error("error消息");
        logger.warn("warn消息");
        logger.info("info消息");
        logger.debug("debug消息");
        logger.trace("trace消息");
    }

    /**
     * 自定义日志
     * com.log4j.Log4jDemo
     * com.log4j        上层
     * ...
     * com              顶级也是可以的
     */
    @Test
    public void Test09(){
        Logger logger = Logger.getLogger(Log4jDemo.class);
        logger.fatal("fatal消息");
        logger.error("error消息");
        logger.warn("warn消息");
        logger.info("info消息");
        logger.debug("debug消息");
        logger.trace("trace消息");

        // 配置的是apache的
        Logger logger1 = Logger.getLogger(Logger.class);
        logger1.fatal("fatal消息---------");
        logger1.error("error消息---------");
        logger1.warn("warn消息---------");
        logger1.info("info消息---------");
        logger1.debug("debug消息---------");
        logger1.trace("trace消息---------");
    }

}
