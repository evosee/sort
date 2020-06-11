package com.example.demo.sort.days;

import java.util.Arrays;
import java.util.BitSet;

/**
 * @author chensai
 * @version 1.0
 * @date 2020/6/11 16:32
 */
public class BisetTest {
    public static void main(String[] args) {
        //System.out.println(getChars("java"));
        int[] a = {2,1,23,232,32,23232323,32322};
        System.out.println(Arrays.toString(sort(a)));

    }
    //获取String中出现的字符
    public static String getChars(String a) {
        char[] chars = a.toCharArray();
        int lenth = chars.length;

        BitSet bitSet =  new BitSet(lenth);
        for(int i=0;i<lenth;i++){
            char c = chars[i];
            bitSet.set(c);
        }
        StringBuilder stringBuilder = new StringBuilder(lenth);
        for(int i=0;i<bitSet.length();i++){
            if(bitSet.get(i)){
                stringBuilder.append(i+"_");
            }

        }
        return stringBuilder.toString();
    }
    //对数字进行排序
    public static int[] sort(int[] a){
        BitSet bitSet = new BitSet(a.length);
        for(int i=0;i<a.length;i++){
            bitSet.set(a[i]);
        }

        int[] r = new int[bitSet.cardinality()];
        int x =0;
        for(int j = 0;j<bitSet.length();j++){
            boolean f  = bitSet.get(j);
            if(f){
                r[x++] = j;
            }
        }
        return r;
    }

}
