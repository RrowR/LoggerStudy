package com.study;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * @author: Rrow
 * @date: 2022/3/20 20:08
 */
public class Refactory {
    /**
     *  重构Log4j
     *  需求：改成slf4j+logback
     *
     *  1.去除以前旧的依赖
     *  2.添加slf4j桥接器
     *  3.添加logback
     *  4.结束
     *
     *      注意:
     *          在桥接器加入后，适配器就没必要引入了
     *          桥接器和适配器不能同时导入依赖
     *          桥接器如果在适配器的上方，则运行报错，不能同时出现
     *          桥接器如果在适配器下方，则不会运行，没有任何意义
     */
    @Test
    public void TestFactory(){
        Logger logger = LogManager.getLogger(Refactory.class);
        logger.info("111");
    }
}
