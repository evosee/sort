package com.example.demo.sort.patten;

public class Singleton2 {
    private Singleton2(){

    }
    public static Singleton2  getInstance(){
        return SingletonInstance.instance;
    }
    private static class SingletonInstance{
        private static final Singleton2 instance = new Singleton2();
    }
}
