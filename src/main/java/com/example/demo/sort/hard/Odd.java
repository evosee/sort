package com.example.demo.sort.hard;

public class Odd {
    /*public static boolean isOdd(int i){
        return i%2 ==1;
    }*/
   /* public static boolean isOdd(int i){
        return i%2 !=0;
    }*/
    public static boolean isOdd(int i){
        return (i&1) !=0;
    }
}
