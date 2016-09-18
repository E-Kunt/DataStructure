package com.ekunt.ds.search;

import java.util.Arrays;

/**
 * 查找算法工具类。
 * Created by E-Kunt on 2016/9/18.
 */
public class SearchUtil {

    /**
     * 无哨兵，顺序查找
     * @param a 待查找数组，元素值从a[1]开始。
     * @param n 数组元素个数
     * @param key 查找的关键字
     * @return 成功返回位置，失败返回0
     */
    public static int seqSearch(int a[], int n, int key) {
        for(int i = 1; i <= n; i++) {
            if(a[i] == key) {
                return i;
            }
        }
        return 0;
    }


    /**
     * 有哨兵，顺序查找
     * @param a 待查找数组，元素值从a[1]开始。a[0]为哨兵。
     * @param n 数组元素个数
     * @param key 查找的关键字
     * @return 成功返回位置，失败返回0
     */
    public static int seqSearch2(int a[], int n, int key) {
        int i = n;
        a[0] = key;
        while(a[i] != key) {
            i--;
        }
        return i;
    }

    /**
     * 折半查找，二分查找
     * @param a 待查找数组，元素值从a[1]开始。
     * @param n 数组元素个数
     * @param key 查找的关键字
     * @return 成功返回位置，失败返回0
     */
    public static int binSearch(int a[], int n, int key) {
        //位置指针
        int low = 1, high = n, mid;
        //low<=high时，若没return,表示还没找到，故继续查找
        while(low <= high) {
            //确定中间位置
            mid = (low + high) / 2;
            //比较中间值与关键字，调整下一次查找的区间
            if(key < a[mid]) {
                high = mid - 1;
            } else if(key > a[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        //没找到，返回0
        return 0;
    }


    /**
     * 插值查找
     * @param a 待查找数组，元素值从a[1]开始。
     * @param n 数组元素个数
     * @param key 查找的关键字
     * @return 成功返回位置，失败返回0
     */
    public static int interSearch(int a[], int n, int key) {
        int low = 1, high = n, mid;
        while(low <= high) {
            //从折半查找改进：修改mid值的确定公式。
            mid = low + (key - a[low]) / (a[high] - a[low]) * (high - low);
            if(key < a[mid]) {
                high = mid - 1;
            } else if(key > a[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return 0;
    }

    /**
     * 斐波那契函数
     * @param n n
     * @return fb(n)
     */
    public static int fibonacci(int n) {
        if(n < 2) return n == 0 ? 0 : 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /**
     * 斐波那契查找，利用黄金分割比例
     * @param a 待查找数组，元素值从a[1]开始。
     * @param n 数组元素个数
     * @param key 查找的关键字
     * @param fb 斐波那契数组
     * @return 成功返回位置，失败返回0
     */
    public static int fibonaciiSearch(int a[], int n, int key, int[] fb) {
        int low = 1, high = n, mid;
        int k = 0;
        //计算n位于斐波那契数列的位置
        while(n > fb[k] - 1) {
            k++;
        }
        //为超过数组长度的后面的位置补全数值，补全的数值等于原数组最后一个数，保持了有序数列
        for(int i = n; i < fb[k] - 1; i++) {
            //修正：java实现时，需要拓展数组空间，防止indexOutOfBounds
            a = Arrays.copyOf(a,fb[k] - 1);
            a[i] = a[n];
        }
        //从这里才开始查找！
        while(low <= high) {
            //通过斐波那契数列的指导，确定中间位置指针的位置（实际利用黄金分割比例）
            mid = low + fb[k - 1] - 1;
            // 比较关键字与中间值，调整下一次查找的区间
            if(key < a[mid]) {
                high = mid - 1;
                k = k - 1;
            } else if(key > a[mid]) {
                low = mid + 1;
                k = k - 2;
            } else {
                //若找到，根据mid位置，判断该值是否是原数组中的。
                //若是直接返回位置下标，否则说明是补全数组的，返回最后一个元素的位置
                if(mid <= n) {
                    return mid;
                }else {
                    return n;
                }
            }
        }
        //没找到，返回0
        return 0;
    }

}
