package com.example.demo.sort.other;

import java.util.ArrayList;
import java.util.List;

public class PECS {
    public static void main(String[] args) {
        List<? super Number> list = new ArrayList<>();
        list.add(3);
       // Number number = list.get(0);
    }
}
