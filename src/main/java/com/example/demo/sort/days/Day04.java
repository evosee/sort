package com.example.demo.sort.days;

import java.util.Arrays;

public class Day04 {

    public static void main(String[] args) {
        int[] a = {2,1,3,5,4,7,1};
       // bubbleSort(a);
        //selectSort(a);
        //insertSort(a);
        quickSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }

    public static void bubbleSort(int[] a){
        for(int i=0;i<a.length-1;i++){
            for(int j=0;j<a.length-1-i;j++){
                if(a[j]>a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
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
            int temp = a[i];
            a[i] = a[lo];
            a[lo] = temp;

        }
    }

    public static void insertSort(int a[]){
        for(int i=1;i<a.length;i++){
            int left = i-1;
            int temp = a[i];
            while (left>=0&&a[left]>temp){
                a[left+1] = a[left];
                left--;
            }
            a[left+1] = temp;
        }
    }

    public static void quickSort(int a[],int start,int end){
        int temp  = a[start];
        int lo = start;
        int hi = end;

        while(start<end){
            while (start<end&&temp<=a[end]) end--;
            if(temp>a[end]){
                int s = a[start];
                a[start] = a[end];
                a[end] = s;

            }

            while (start<end&&temp>=a[start]) start++;
            if(temp<a[start]){
                int s = a[start];
                a[start] = a[end];
                a[end] = s;
            }

        }
        if(lo<start) quickSort(a,lo,start-1);
        if(end<hi) quickSort(a,end+1,hi);
    }
}
