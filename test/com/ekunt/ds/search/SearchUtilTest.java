package com.ekunt.ds.search;

import org.junit.Assert;
import org.junit.Test;

/**
 * 查找算法 测试用例
 * Created by E-Kunt on 2016/9/18.
 */
public class SearchUtilTest {
    @Test
    public void seqSearch() throws Exception {
        int[] a = {0,1,2,3,4,5};
        int length = 5, key = 4;
        int result = SearchUtil.seqSearch(a,length,key);
        System.out.println(result);
        Assert.assertEquals(result,4);
    }

    @Test
    public void seqSearch2() throws Exception {
        int[] a = {0,1,2,3,4,5};
        int length = 5, key = 3;
        int result = SearchUtil.seqSearch2(a,length,key);
        System.out.println(result);
        Assert.assertEquals(result,3);
    }

    @Test
    public void binSearch() throws Exception {
        int[] a = {0,1,2,3,4,5};
        int length = 5, key = 2;
        int result = SearchUtil.binSearch(a,length,key);
        System.out.println(result);
        Assert.assertEquals(result,2);
    }

    @Test
    public void interSearch() throws Exception {
        int[] a = {0,1,2,3,4,5};
        int length = 5, key = 1;
        int result = SearchUtil.interSearch(a,length,key);
        System.out.println(result);
        Assert.assertEquals(result,1);
    }

    @Test
    public void fibonaciiSearch() throws Exception {
        int[] a = {0,1,2,3,4,5};
        int length = 5, key = 5;
        int[] fb = new int[20];
        for(int i = 0; i < 20; i++) {
            fb[i] = SearchUtil.fibonacci(i);
        }
        int result = SearchUtil.fibonaciiSearch(a,length,key,fb);
        System.out.println(result);
        Assert.assertEquals(result,5);
    }

}