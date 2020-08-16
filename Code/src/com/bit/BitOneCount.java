package com.bit;

/**
 * 计算数字的二进制中有多少个1
 */
public class BitOneCount {
    private static int getResult(int n ){
        int res = 0;
        while(n!=0){
            n &= (n-1);
            ++res;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(getResult(10));
    }
}
