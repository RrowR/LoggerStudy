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
    public void Study01() {
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
    public void Study02() {
        Logger logger = LoggerFactory.getLogger(LogBackStudy.class);
        logger.error("error");
        logger.warn("warn");
        logger.info("info");
        logger.debug("debug");
        logger.trace("trace");
    }

    /*
        将日志保存到文件中
     */
    @Test
    public void Study03() {
        Logger logger = LoggerFactory.getLogger(LogBackStudy.class);
        logger.error("error");
        logger.warn("warn");
        logger.info("info");
        logger.debug("debug");
        logger.trace("trace");
    }

    /*
        将日志输出成一个html格式,还是玩配置文件
     */
    @Test
    public void Study04() {
        Logger logger = LoggerFactory.getLogger(LogBackStudy.class);
        logger.error("error");
        logger.warn("warn");
        logger.info("info");
        logger.debug("debug");
        logger.trace("trace");
    }

    /*
        日志的拆分和压缩
     */
    @Test
    public void Study05() {
        Logger logger = LoggerFactory.getLogger(LogBackStudy.class);
        for (int i = 0; i < 100; i++) {
            logger.error("error");
            logger.warn("warn");
            logger.info("info");
            logger.debug("debug");
            logger.trace("trace");
        }
    }

    /*
        使用过滤器进行更细粒度的打印
     */
    @Test
    public void Study06() {
        Logger logger = LoggerFactory.getLogger(LogBackStudy.class);
        logger.error("error");
        logger.warn("warn");
        logger.info("info");
        logger.debug("debug");
        logger.trace("trace");
    }

    /*
        异步消息打印，因为日志会阻塞正常逻辑运行
        但是异步日志会出现显示问题(所谓异步日志就是多线程抢占资源)
     */
    @Test
    public void Study07() {
        Logger logger = LoggerFactory.getLogger(LogBackStudy.class);
        for (int i = 0; i < 100; i++) {
            logger.error("error");
            logger.warn("warn");
            logger.info("info");
            logger.debug("debug");
            logger.trace("trace");
        }
        System.out.println("11111111111");
        System.out.println("22222222222");
        System.out.println("33333333333");
        System.out.println("44444444444");
        System.out.println("55555555555");
    }

    /*
        自定义日志
     */
    @Test
    public void Study08() {
        Logger logger = LoggerFactory.getLogger(LogBackStudy.class);
        logger.error("error");
        logger.warn("warn");
        logger.info("info");
        logger.debug("debug");
        logger.trace("trace");
    }

    /*
    * 配置文件转换
    * https://logback.qos.ch/translator/
    * <discardingThreshold>0</discardingThreshold>      阈值，小于则丢弃trace、debug、info
    * <queueSize>256</queueSize>                        深度，影响性能
    * */
    @Test
    public void Study09(){
        Logger logger = LoggerFactory.getLogger(LogBackStudy.class);

    }
}
