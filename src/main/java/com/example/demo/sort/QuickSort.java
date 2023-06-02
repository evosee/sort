package com.example.demo.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] a = {2,1,324,45,546,57,34,45,56,657};
        quickSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
    public static void quickSort(int[] a,int left,int right){
        if(left<right){
            int p = partition(a,left,right);
            quickSort(a,left,p-1);
            quickSort(a,p+1,right);
        }
    }
    private static int partition(int[] a,int left,int right){
        int temp = a[left];
        int i = left+1;
        int j = right;
        while (i<=j){
            if(a[i]<=temp){
                i++;
            }else if(a[j]>temp){
                j--;
            }else {
                swap(a,i,j);
            }
        }
        swap(a,left,j);
        return j;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
