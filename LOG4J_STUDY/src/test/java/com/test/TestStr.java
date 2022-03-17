package com.test;

import org.junit.Test;

/**
 * @author: Rrow
 * @date: 2022/3/17 10:08
 */
public class TestStr {
    @Test
    public void TestString(){
        String str = "1234567890abcdefghij1234567890abcdefghij";
        String substring = str.substring(21, 38);
        String substring2 = str.substring(21, 40);
        System.out.println(substring);
        System.out.println(substring2);
    }

    @Test
    public void TestString02(){
        String str = "123456787adcsdqw";
        System.out.println("str.substring(4,16) = " + str.substring(4, 16));
    }
}
