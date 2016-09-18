package com.ekunt.ds.string;

/**
 * 字符串算法工具类
 * Created by E-Kunt on 2016/9/18.
 */
public class StringUtil {

    /**
     * BF算法-朴素的模式匹配算法
     * @param s 主串，s[0]存字符个数，数据从s[1]开始
     * @param t 子串，t[0]存字符个数，数据从s[1]开始
     * @param pos 开始查找的位置
     * @return 成功返回位置，失败返回0
     */
    public static int bf(char[] s, char[] t, int pos) {
        //主串和子串位置指针
        int i = pos, j = 1;
        //指针都没有超出范围，说明匹配未结束，继续
        while(i <= s[0] && j <= t[0]) {
            //相等比较下个字符，不等则回溯
            if(s[i] == t[j]) {
                i++;
                j++;
            } else {
                i = i - j + 2;
                j = 1;
            }
        }
        //匹配结束，若j超出范围，表示找到子串，返回位置，否则返回0
        if(j > t[0]) {
            return i - t[0];
        } else {
            return 0;
        }
    }


    /**
     * KMP算法中，获得next数组。
     * @param t 子串，t[0]存字符个数，数据从s[1]开始
     * @return next数组
     */
    private static int[] getNext(char[] t) {
        //后缀初始位置1，前缀初始位置0，next数组第一个位置的值永远是0
        int i = 1, j = 0;
        int[] next = new int[t[0] + 1];
        next[1] = 0;
        //后缀不超出字符串长度，循环
        while(i < t[0]) {
            //如果前缀位置为0，或者 前缀字符==后缀字符，位置指针后移，填写next数组的对应位置的值，继续比较下一个字符
            if(j == 0 || t[i] == t[j]) {
                i++;
                j++;
                next[i] = j;
            } else {
                //否则，i不回溯，j根据next数组的指导，回溯到相应的位置。
                j = next[j];
            }
        }
        //返回得到的next数组。
        return next;
    }

    /**
     * KMP算法。
     * @param s 主串，s[0]存字符个数，数据从s[1]开始
     * @param t 子串，t[0]存字符个数，数据从s[1]开始
     * @param pos 开始查找的位置
     * @return 成功返回位置，失败返回0
     */
    public static int kmp(char[] s, char[] t, int pos) {
        //主串和子串位置指针
        int i = pos, j = 1;
        //获得next数组
        int[] next = getNext(t);
        //只要位置指针不超出字符串长度，循环
        while(i <= s[0] && j <= t[0]) {
            //如果j指向子串左边（未指向第一个字符），或者主串和子串的对应位置的字符匹配，继续比较下一个字符
            if(j == 0 || s[i] == t[j]) {
                i++;
                j++;
            } else {
                //否则，i不回溯，j根据nextval数组的指导，回溯到相应的位置。
                j = next[j];
            }
        }
        //匹配结束，若j超出范围，表示找到子串，返回位置，否则返回0
        if(j > t[0]) {
            return i - t[0];
        } else {
            return 0;
        }
    }


    /**
     * 改进的KMP算法中，获取nextval数组。
     * @param t 子串，t[0]存字符个数，数据从s[1]开始
     * @return nextval数组
     */
    private static int[] getNextVal(char[] t) {
        int i = 1, j = 0;
        int[] nextval = new int[t[0] + 1];
        nextval[1] = 0;
        while(i < t[0]) {
            if(j == 0 || t[i] == t[j]) {
                i++;
                j++;
                //改进的地方：若当前字符c1与它原本的next数组指向的字符c2相等，那么取c2字符的nextval数组的值。
                if(t[i] != t[j]) {
                    nextval[i] = j;
                } else {
                    nextval[i] = nextval[j];
                }
            } else {
                j = nextval[j];
            }
        }
        return nextval;
    }

    /**
     * 改进后的KMP算法。
     * @param s 主串，s[0]存字符个数，数据从s[1]开始
     * @param t 子串，t[0]存字符个数，数据从s[1]开始
     * @param pos 开始查找的位置
     * @return 成功返回位置，失败返回0
     */
    public static int kmpVal(char[] s, char[] t, int pos) {
        int i = pos, j = 1;
        //改进的地方，使用nextval数组。
        int[] nextval = getNextVal(t);
        while(i <= s[0] && j <= t[0]) {
            if (j == 0 || s[i] == t[j]) {
                i++;
                j++;
            } else {
                j = nextval[j];
            }
        }
        if(j > t[0]) {
            return i - t[0];
        } else {
            return 0;
        }
    }

}
