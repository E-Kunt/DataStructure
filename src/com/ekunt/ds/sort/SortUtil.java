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

    /**
     * 快速排序
     * @param a 待排序的数组，元素值从a[1]开始。
     */
    public static void quickSort(int[] a) {
        qSort(a,1,a.length-1);
    }

    /**
     * 对数据子序列做快速排序
     * @param a 待排序的数组，元素值从a[1]开始。
     * @param low 子序列开始位置
     * @param high 子序列结束位置
     */
    private static void qSort(int[] a, int low, int high) {
        if(low < high) {
            //将a[low..high]一分为二，左（右）边的数都小（大）于枢轴值，返回枢轴的位置
            int pivotloc = partition(a,low,high);
            //递归：分别对低子表和高子表做快速排序
            qSort(a,low,pivotloc-1);
            qSort(a,pivotloc+1,high);
        }
    }

    /**
     * 对数据子序列进行一趟排序,把数据序列分为两部分，左边的数据都小于枢轴的值，右边 的数据都大于枢轴的值，返回枢轴的位置
     * @param a 待排序的数组，元素值从a[1]开始。
     * @param low 子序列开始位置
     * @param high 子序列结束位置
     * @return 枢轴的位置
     */
    private static int partition(int[] a, int low, int high) {
        //第一个数当成枢轴的值
        int pivotkey = a[low];
        //从两端交替向中间扫描，比枢轴小（大）的交换到低（高）端
        while(low < high) {
            while(low < high && a[high] >= pivotkey) {
                high--;
            }
            swap(a,low,high);
            while(low < high && a[low] <= pivotkey) {
                low++;
            }
            swap(a,low,high);
        }
        //此时low的位置就是枢轴的位置
        return low;
    }

    /**
     * 简单选择排序 （模型：不断观察时机，最后选择合适时机，一次性变卖股票）
     * @param a 待排序的数组，元素值从a[1]开始。
     */
    public static void selectSort(int[] a) {
        int length = a.length - 1;
        //对每个位置作循环（除了最后一个位置）
        for(int i = 1; i < length; i++) {
            //指示最小值的位置，一开始把目标位置上的数当成最小值
            int min = i;
            //从下个数据开始依次与当前最小值做对比，并让min指向最小值的位置
            for(int j = i + 1; j <= length; j++) {
                if(a[j] <= a[min]) {
                    min = j;
                }
            }
            //全部比较结束后，若min与初始的位置(i)不同，那么交换两个位置上的数据
            if(min != i) {
                swap(a,i,min);
            }
        }
    }

    /**
     * 堆排序
     * @param a 待排序的数组，元素值从a[1]开始。
     */
    public static void heapSort(int[] a) {
        int length = a.length - 1;
        //对前一半的数，当双亲结点，进行堆调整，最终构造成一个大顶堆
        for(int i = length / 2; i > 0; i--) {
            heapAdjust(a,i,length);
        }
        //从最后一个结点（值最小）开始，对于每个结点
        for(int i = length; i > 1; i--) {
            //把顶记录和当前未排序子序列的最后一个数进行交换
            swap(a,1,i);
            //交换后，进行堆调整，维持为大顶堆
            heapAdjust(a,1,i-1);
        }
    }

    /**
     * 已知a[s]之外均满足堆的定义，调整结构，使a[s..m]成为大顶堆
     * @param a 待排序的数组，元素值从a[1]开始。
     * @param s 子序列开始位置
     * @param m 子序列结束位置
     */
    private static void heapAdjust(int[] a, int s, int m) {
        //保存第一个数（不满足堆定义的数）
        int temp = a[s];
        //对于每个结点的左孩子（2*s）
        for(int i = s * 2; i <= m; i *= 2) {
            //如果左孩子小于右孩子，则i指向右孩子
            if(i < m && a[i] < a[i+1]) {
                i++;
            }
            //如果没有比temp大，证明它的所有子结点都不可能比temp大，不再循环
            //则上次循环后的位置s为最佳的插入位置
            if(a[i] <= temp) {
                break;
            }
            //如果比temp大，交换位置，使大的数往上放
            a[s] = a[i];
            //指向原先大的数的位置（期望：此处是可以插入temp的位置）
            s = i;
        }
        //找到了合适的位置，选择在s位插入temp
        a[s] = temp;
    }


    /**
     * 直接插入排序（模型：扑克牌排序）
     * @param a  待排序的数组，元素值从a[1]开始。
     */
    public static void insertSort(int[] a) {
        int length = a.length - 1;
        int i, j;
        //把第一个数当成有序序列，从第二个数开始，寻找前面有序序列的适当位置插入
        for (i = 2; i <= length; i++) {
            //如果当前这个要插入的数（以下称目标数）小于 它前面的那个数，证明目标数位置不对，需要调整
            if (a[i] < a[i - 1]) {
                //[0]位置当哨兵，暂存目标数
                a[0] = a[i];
                //向前扫描，依次与前面的各个数比较，把比目标数大的数都后移，直到遇到比目标数小的
                for (j = i - 1; a[j] > a[0]; j--) {
                    a[j + 1] = a[j];
                }
                //此时，[j]的后一个位置[j+1],就是合适的位置，把目标数插到这个位置
                a[j+1] = a[0];
            }
        }
    }

    /**
     * 折半插入排序，二分插入排序（通过二分查找算法来查找合适插入的位置，从而改进直接插入排序）
     * @param a 待排序的数组，元素值从a[1]开始。
     */
    public static void binInsertSort(int[] a) {
        int length = a.length - 1;
        int i, j;
        for(i = 2; i <= length; i++) {
            if(a[i] < a[i-1]) {
                a[0] = a[i];
                //通过二分查找算法来查找合适插入的位置，循环结束时[low]==[mid]==应插入的位置
                int low = 1, high = i - 1, mid;
                while(low <= high) {
                    mid = (low + high) / 2;
                    if(a[0] > a[mid]) {
                        low = mid + 1;
                    }else{
                        high = mid - 1;
                    }
                }
                //把[low]至[i-1]位置上的数全部后移
                for(j = i - 1; j >= low; j--) {
                    a[i] = a[j];
                    i--;
                }
                //目标数插入到[low]这个位置。（至此，从[1]到[low]都是有序的）
                a[low] = a[0];
            }
        }
    }

    /**
     * 希尔排序（通过减少序列个数，使序列基本有序，从而改进直接插入排序。）
     * @param a 待排序的数组，元素值从a[1]开始。
     */
    public static void shellSort(int[] a) {
        int length = a.length - 1;
        int i, j;
        //定义间隔，根据间隔确定子序列
        int increment = length;
        do{
            //每次循环缩小间隔，最后一次要等于1
            increment = increment / 3 + 1;
            //对间隔上的数进行直接插入排序
            for(i = 1 + increment; i <= length; i++) {
                //如果目标数位置不正确，调整
                if(a[i] < a[i-increment]) {
                    //a[0]暂存目标数
                    a[0] = a[i];
                    //根据间隔，从后往前扫描，把比目标数大的，往后移1个间隔，直到遇到比目标数小的
                    for(j = i - increment; j > 0 && a[j] > a[0]; j -= increment) {
                        a[j + increment] = a[j];
                    }
                    //此时，[j]的后一个间隔位置[j+increment],就是合适的位置，把目标数插到这个位置
                    a[j + increment] = a[0];
                }
            }
            //只要increment > 1， 缩小间隔，继续循环
        } while(increment > 1);
    }

    /**
     * 2-路归并排序
     * @param a 待排序的数组，元素值从a[1]开始。
     */
    public static void mergeSort(int[] a) {
        mSort(a,a,1,a.length-1);
    }

    /**
     * 2-路归并排序：将s[low..high]进行归并排序后放入t[low..high]中。
     * @param s 待排序的数组，元素值从a[1]开始。
     * @param t 排序后的数组，元素值从a[1]开始。
     * @param low 左边界
     * @param high 右边界
     */
    private static void mSort(int[] s, int[] t, int low, int high) {
        if(low == high) {
            //当序列长度等于1时，递归结束。
            t[low] = s[low];
        } else {
            //t2存左右序列递归后的结果
            int[] t2 = new int[t.length];
            //分成两个序列
            int mid = (low + high) / 2;
            //对左序列递归
            mSort(s,t2,low,mid);
            //对右序列递归
            mSort(s,t2,mid+1,high);
            //归并
            merge(t2,t,low,mid,high);
        }
    }

    /**
     * 归并函数：把相邻两个有序子序列s[low..mid]、s[mid+1..high]归并成一个有序序列t[low..high]
     * @param s 待排序的数组，元素值从a[1]开始。
     * @param t 排序后的数组，元素值从a[1]开始。
     * @param low 左边界
     * @param mid 中间边界
     * @param high 右边界
     */
    private static void merge(int[] s, int[] t, int low, int mid, int high) {
        //[i]是左序列开始的位置,[j]是右序列开始的位置，k是生成新序列开始的位置
        int i = low, j = mid + 1, k = low;
        //依次比较两个序列的值，把较小的数放在新序列t中,直到有一个序列空了（比较完了）
        while(i <= mid && j <= high) {
            t[k++] = s[i] <= s[j] ? s[i++] : s[j++];
        }
        //如果左序列非空，把剩余的数据存入新序列t中
        while(i <= mid) {
            t[k++] = s[i++];
        }
        //如果右序列非空，把剩余的数据存入新序列t中
        while(j <= high) {
            t[k++] = s[j++];
        }
    }


}
