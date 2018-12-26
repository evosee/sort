package com.example.demo.sort.days;

import java.util.Arrays;

/**
 * @Author: chensai
 * @Date: 2018/12/25 15:44
 * @Version 1.0
 */
public class Day54 {
    public static void main(String[] args) {
        int[] a = {2,1,54,2,4,5};
        //bubbleSort(a);
        //selectSort(a);
        //insertSort(a);
        quickSort(a,0,a.length-1);
        System.out.println(binartSearch(a,0,a.length,3));
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
            for (int j=i+1;j<a.length;j++){
                if(a[lo]>a[j]){
                    lo = j;
                }
            }
            int t= a[lo];
            a[lo] = a[i];
            a[i] = t;
        }
    }

    public static void insertSort(int[] a){
        for (int i=1;i<a.length;i++){
            int left = i-1;
            int k = a[i];
            while (left>=0&&a[left]>k){
                a[left+1] = a[left];
                left--;
            }
            a[left+1] = k;
        }
    }

    public static void quickSort(int[] a,int start,int end){
        int lo =start;
        int hi = end;
        int k = a[start];
        while (start<end){
            while (start<end&&a[end]>=k) end--;
            if(a[end]<k){
                int  t = a[start];
                a[start] = a[end];
                a[end] = t;
            }
            while (start<end&&a[start]<=k) start++;
            if(a[start]>k){
                int  t = a[start];
                a[start] = a[end];
                a[end] = t;
            }
        }
        if(lo<start) quickSort(a,lo,start-1);
        if(end<hi) quickSort(a,end+1,hi);
    }

    public static int binartSearch(int[] a,int from,int to,int k){
        int lo = from;
        int hi = to-1;
        while (lo<=hi){
            int mid = (lo+hi)>>>1;
            int mk = a[mid];
            if(mk>k){
                hi = mid-1;
            }else if(mk<k){
                lo = mid+1;
            }else return mid;
        }
        return -(lo+1);
    }
}