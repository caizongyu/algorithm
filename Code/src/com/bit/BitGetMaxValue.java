package com.bit;

/**
 * 不使用比较判断去获取两个数中比较大的数字
 * return  大数*1 + 小数*0
 */
public class BitGetMaxValue {
    /**
     * 获取一个数组的最高位，可以判断正负
     * @param n
     * @return
     */
    public static int getSign(int n){
        return (n>>31) & 1;
    }
    public static int trans(int n){
        return n ^ 1;
    }

    /**
     * return  大数*1 + 小数*0
     * @param a
     * @param b
     * @return
     */
    public static int method1GetMax(int a, int b){
        int c = a- b;
        int sC = getSign(c);
        int sA = getSign(sC);
        return a * sA + b * sC;
    }

    /**
     * 相对方法1，防止溢出
     * @param a
     * @param b
     * @return
     */
    public static int method2GetMax(int a, int b){
        int sA = getSign(a);
        int sB = getSign(b);
        int sC = getSign(a-b);
        int sab = sA ^ sB;
        int tab = trans(sab);
        return a * trans(sab * sA + tab * sC)  + b* (sab * sA + tab * sC);
    }

    public static void main(String[] args) {
        System.out.println(method2GetMax(5 , 4));
    }

}
