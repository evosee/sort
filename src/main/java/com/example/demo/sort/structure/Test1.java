package com.example.demo.sort.structure;

/**
 * @author chensai
 * @version 1.0
 * @date 2020/6/22 17:18
 *
 * cpu正弦曲线
 */
public class Test1 {
    public static void main(String[] args) throws Exception {
        long currentTimeMillis = System.currentTimeMillis();
        while (true){

            if(System.currentTimeMillis()-currentTimeMillis<1000){
                System.out.println(1);
            }else {
                Thread.sleep(1000);
                currentTimeMillis = System.currentTimeMillis();
            }

        }
    }
}
