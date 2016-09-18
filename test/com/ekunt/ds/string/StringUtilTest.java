package com.ekunt.ds.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * 字符串匹配算法 测试用例
 * Created by E-Kunt on 2016/9/18.
 */
public class StringUtilTest {
    @Test
    public void bf() throws Exception {
        char[] s = {8,'a','b','c','d','a','b','a','b'};
        char[] t = {3,'d','a','b','a'};
        int result = StringUtil.bf(s,t,2);
        System.out.println(result);
        Assert.assertEquals(result,4);
    }

    @Test
    public void kmp() throws Exception {
        char[] s = {8,'a','b','c','d','a','b','a','b'};
        char[] t = {4,'a','b','a','b'};
        int result = StringUtil.kmp(s,t,1);
        System.out.println(result);
        Assert.assertEquals(result,5);
    }

    @Test
    public void kmpval() throws Exception {
        char[] s = {8,'a','b','c','d','a','b','a','b'};
        char[] t = {2,'a','b'};
        int result = StringUtil.kmpVal(s,t,6);
        System.out.println(result);
        Assert.assertEquals(result,7);
    }

}