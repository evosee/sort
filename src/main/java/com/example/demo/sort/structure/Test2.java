package com.example.demo.sort.structure;

/**
 * @author chensai
 * @version 1.0
 * @date 2020/6/22 17:27
 * <p>
 * 将帅问题
 */
public class Test2 {
    public static void main(String[] args) {
        //new Test2().program();
        printPos();
    }
    public void program() {
        for(int i=1;i<=9;i++){
            for(int j=1;j<=9;j++){
                if(j!=i+3&&j!=i&&j!=i+6){
                    System.out.println("位置:"+i+" "+j);
                }
            }
        }
    }

    public static void printPos(){
        for(int i = 0;i<9;i++){
            for(int j = 0;j<9;j++){
                if(i%3 == j%3){
                    continue;
                }else{
                    System.out.println("A = "+(i+1)+", B = "+(j+1));
                }
            }
        }
    }



}
