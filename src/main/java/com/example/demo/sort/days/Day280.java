package com.example.demo.sort.days;

import java.util.Arrays;

/**
 * @author chensai
 * @version 1.0
 * @date 2020/7/7 10:15
 */
public class Day280 {
    public static void main(String[] args) {
        int[]  a = {2,1,43,45,6711,1111,87879,543,576,867,34,56,67,3};
       // bubbleSort(a);
      //  selectSort(a);
     //  inserSort(a);
        quickSort(a,0,a.length-1);
        System.out.println(binarySearch(a,0,a.length,323232));
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
                    lo=j;
                }
            }
            int t=  a[lo];
            a[lo] = a[i];
            a[i] = t;
        }
    }
    public static void inserSort(int[] a){
        for(int i=1;i<a.length;i++){
            int left = i-1;
            int k = a[i];
            while (left>=0&&a[left]>k){
                a[left+1] = a[left];
                left--;
            }
            a[left+1] =k;
        }
    }
    public static void quickSort(int[] a,int start,int end){
        int lo = start;
        int hi = end;
        int k = a[start];
        while (start<end){
            while (start<end&&a[end]>=k) end--;
            if(a[end]<k){
                int t = a[start];
                a[start] = a[end];
                a[end] = t;
            }
            while (start<end&&a[start]<=k) start++;
            if(a[start]>k){
                int t = a[start];
                a[start] = a[end];
                a[end] = t;
            }
        }
        if(lo<start) quickSort(a,lo,start-1);
        if(end<hi) quickSort(a,end+1,hi);
    }
    public static int binarySearch(int[] a,int start,int end,int k){
        int lo = start;
        int hi = end-1;
        while (lo<=hi){
            int mid = (lo+hi)>>>1;
            int mk = a[mid];
            if(k>mk){
                lo = mid+1;
            }else if(k<mk){
                hi = mid-1;
            }else return mid;
        }
        return -(lo+1);
    }
}
