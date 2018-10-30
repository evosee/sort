package com.example.demo.sort.days;

import java.util.Arrays;

public class Day01 {
    public static void main(String[] args) {
        int[] array = {10, 9, 112, 10, 1, 2, 7, 113};
        //  bubbleSort(array);
        //selectSort(array);
        insertSort(array);
        System.out.println(Arrays.toString(array));


    }

    /**
     * 冒泡排序
     * 思路:外层循环控制循环次数
     * 内层循环实现交换 每执行完一次那么最大的值将会放在最后面
     * 缺点：循环次数过多，效率低
     */
    public static void bubbleSort(int[] source) {
        for (int i = 0; i < source.length - 1; i++) {
            for (int j = 0; j < source.length - 1 - i; j++) { //i其实代表了已经排过序的个数
                if (source[j] > source[j + 1]) {
                    int temp = source[j];
                    source[j] = source[j + 1];
                    source[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 选择排序 效率比冒泡高
     * 思路：找到最小的index交换，这样每次排完一次序最小的将放在最前面
     */
    public static void selectSort(int[] source) {
        for (int i = 0; i < source.length - 1; i++) {
            int lo = i;
            for (int j = i + 1; j < source.length; j++) {
                if (source[lo] > source[j]) {
                    lo = j;
                }
            }
            int temp = source[i];
            source[i] = source[lo];
            source[lo] = temp;
        }
    }
    /**
     * 插入排序 是在简单排序中速度最快的
     * 思路：先假设左边都是有序的，然后循环找个值应该插入的位置
     *
     * */
    public static void insertSort(int[] source){
        for(int i=1;i<source.length;i++){
            int temp = source[i];
            int left = i-1;
            while (left>=0&&temp<source[left]){
                source[left+1] = source[left];
                left--;
            }
            source[left+1]  = temp;
        }

    }
}



