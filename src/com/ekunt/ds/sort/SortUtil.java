package com.ekunt.ds.sort;

/**
 * 排序算法 工具类
 * Created by E-Kunt on 2016/9/18.
 */
public class SortUtil {

    /**
     * 交换数组中两元素位置。
     * @param a 元素所在的数组
     * @param i 第一个元素
     * @param j 第二个元素
     */
    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * 伪冒泡排序
     * @param a 待排序的数组，元素值从a[1]开始。
     */
    public static void bubbleSort1(int[] a) {
        int length = a.length - 1;
        //对每个数据做循环
        for(int i = 1; i <= length; i++) {
            //把其与下一个数据开始的所有数据进行 交换排序
            for(int j = i + 1; j <= length; j++) {
                if(a[i] > a[j]) {
                    swap(a,i,j);
                }
            }
        }
    }

    /**
     * 真正的冒泡排序
     * @param a 待排序的数组，元素值从a[1]开始。
     */
    public static void bubbleSort2(int[] a) {
        int length = a.length - 1;
        //针对每个目标位置做循环
        for(int i = 1; i <= length; i++) {
            //从最后2个位置的数据开始，依次排序，直到目标位置
            for(int j = length - 1; j >= i; j--) {
                if(a[j] > a[j+1]) {
                    swap(a,j,j+1);
                }
            }
        }
    }

    /**
     * 改进后的冒泡排序
     * @param a 待排序的数组，元素值从a[1]开始。
     */
    public static void bubbleSort3(int[] a) {
        int length = a.length - 1;
        //标志：上一轮是否有进行交换操作（若false证明已排序成功,不再进行下一轮排序）
        boolean flag = true;
        for(int i = 1; i <= length && flag; i++) {
            flag = false;
            for(int j = length - 1; j >= i; j--) {
                if(a[j] > a[j+1]) {
                    swap(a,j,j+1);
                    flag = true;
                }
            }
        }
    }


}
