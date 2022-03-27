package com.springbootlog.study;

import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudyApplicationTests {

    @Test
    void testDefault() {
        /*
            springboot日志实现      默认是info级别  logback风格(没有颜色)
         */
        Logger logger = LoggerFactory.getLogger(StudyApplicationTests.class);
        logger.trace("trace");
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
    }

    @Test
    void testLog4j2() {
        // 使用log4j2后发现还是使用的logback，是因为使用了桥接器
        org.apache.logging.log4j.Logger logger = LogManager.getLogger(StudyApplicationTests.class);
        logger.trace("trace");
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
    }

    /*
    * 使用springboot配置文件可以直接配置日志信息
    *   logging.level.com.springbootlog=trace
        logging.pattern.console=%d{yyyy-MM-dd HH:mm:ss:SSS} %c %m%n
    * */
    @Test
    void testApplicationProperties() {
        Logger logger = LoggerFactory.getLogger(StudyApplicationTests.class);
        logger.trace("trace");
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
    }

    /*
    *   用这个name可以配置名字，path只有路径，默认名字为spring.log
        logging.file.name=F://log4j2//myspringboot.log
    * */
    @Test
    void testTopFiles() {
        Logger logger = LoggerFactory.getLogger(StudyApplicationTests.class);
        logger.trace("trace");
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
    }

    /*
        拆分日志        需要在resources下配置logback.xml
     */
    @Test
    void devideLogs() {
        Logger logger = LoggerFactory.getLogger(StudyApplicationTests.class);
        for (int i = 0; i < 2000; i++) {
            logger.trace("trace");
            logger.debug("debug");
            logger.info("info");
            logger.warn("warn");
            logger.error("error");
        }
    }

    /*
        springboot-整合log4j2     需要去除掉以前的环境
        1.spring-boot-starter-web 会引入logback依赖
            <exclusions>
                <!-- 排除掉日志依赖 -->
                <exclusion>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-logging</artifactId>
                </exclusion>
            </exclusions>
        2.添加log4j2的依赖
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-log4j2</artifactId>
            </dependency>
         3.将log4j2.xml导入到类路径resources下
     */
    @Test
    void springBootLog4j2() {
        Logger logger = LoggerFactory.getLogger(StudyApplicationTests.class);
        logger.trace("my trace");
        logger.debug("my debug");
        logger.info("my info");
        logger.warn("my warn");
        logger.error("my error");
    }


}
