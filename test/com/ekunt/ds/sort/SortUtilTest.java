package com.ekunt.ds.sort;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by E-Kunt on 2016/9/20.
 */
public class SortUtilTest {
    private int[] a;

    @Before
    public void setUp() throws Exception {
        a = new int[]{6,4,6,2,5,1,3}; //数据第0位开始：4，6，2，5，1，3
    }

    @After
    public void tearDown() throws Exception {
        a = Arrays.copyOfRange(a,1,7);
        String result = Arrays.toString(a);
        System.out.println(result);
        Assert.assertEquals(result,"[1, 2, 3, 4, 5, 6]");
    }

    @Test
    public void bubbleSort1() throws Exception {
        SortUtil.bubbleSort1(a);
    }

    @Test
    public void bubbleSort2() throws Exception {
        SortUtil.bubbleSort2(a);
    }

    @Test
    public void bubbleSort3() throws Exception {
        SortUtil.bubbleSort3(a);
    }

    @Test
    public void quickSort() throws Exception {
        SortUtil.quickSort(a);
    }

    @Test
    public void selectSort() throws Exception {
        SortUtil.selectSort(a);
    }

    @Test
    public void heapSort() throws Exception {
        SortUtil.heapSort(a);
    }

    @Test
    public void insertSort() throws Exception {
        SortUtil.insertSort(a);
    }

    @Test
    public void binInsertSort() throws Exception {
        SortUtil.binInsertSort(a);
    }

    @Test
    public void shellSort() throws Exception {
        SortUtil.shellSort(a);
    }

    @Test
    public void mergeSort() throws Exception {
        SortUtil.mergeSort(a);
    }

}