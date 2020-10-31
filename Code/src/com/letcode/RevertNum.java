package com.letcode;

public class RevertNum {
    //letcode 解法
    public static int reverse(int x) {
        int rev = 0;//rev存储反转的数字
        while(x!=0){
            int pop = x%10;//pop表示弹出的数
            //如果已经反转内容rev大于Integr最大值/10,那么一定溢出；
            // 如果最rev反转内容等于最大值/10且最后一位pop的数字大于7，那么就从正数这边溢出了
            //另外一种就是从负数那边溢出了
            if((rev>Integer.MAX_VALUE/10||(rev==Integer.MAX_VALUE/10&&pop>7))
                    ||rev<Integer.MIN_VALUE/10||(rev==Integer.MIN_VALUE/10&&pop<-8)){
                return 0;
            }
            rev=rev*10+pop;//把pop防到rev后面
            x/=10;//去掉已经pop的内容
        }
        return rev;
    }
    public static int doRevert(int x){
        int result =0;
        while(x!= 0){
            int pop = x%10;
            result = result * 10 + pop;
            x = x/10;
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(doRevert(158));
    }
}
