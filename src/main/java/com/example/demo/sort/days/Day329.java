package com.example.demo.sort.days;

import java.util.Arrays;

/**
 * @author chensai
 * @Description
 * @Date 2020/10/26 10:05
 */
public class Day329 {
    public static void main(String[] args) {
        int[] a= {2,1,34,45,56,678,87,4565,765,75,453,654,65,232};
      //  bubbleSort(a);
        selectSort(a);
        System.out.println(Arrays.toString(a));
    }
    public static void bubbleSort(int[] a){
        for(int i=0;i<a.length-1;i++){
            for(int j=0;j<a.length-1-i;j++){
                if(a[j]>a[j+1]){
                    int t = a[j];
                    a[j] = a[j+1];
                    a[j+1] = t;
                }
            }
        }
    }
    public static void selectSort(int[] a){
        for(int i=0;i<a.length-1;i++){
            int lo = i;
            for(int j=i+1;j<a.length;j++){
                if(a[lo]>a[j]){
                    lo = j;
                }
            }
            int t = a[lo];
            a[lo] = a[i];
            a[i] = t;
        }
    }
}
