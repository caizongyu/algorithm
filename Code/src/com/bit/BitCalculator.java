package com.bit;

/**
 * 使用位运算完成加减乘除
 */
public class BitCalculator {
    /**
     * 位运算两个数字相加   无进位相加 + 进位数 =结果
     * @param a
     * @param b
     * @return
     */
    private static int userBitAdd(int a, int b){
        int sum = a;
        while(b != 0){
            //不考虑进位两数字相加
            sum = a ^ b;
            //进位值
            b = (a&b)<<1;
            a = sum;
        }
        return sum;
    }

    /**
     * 计算机中的减法是通过加法来实现的  a-b = a + （-b）
     * @param a
     * @param b
     */
    private static int userBitMinus(int a, int b){
        return userBitAdd(a, getComplementCode(b));
    }

    /**
     * 获取一个数字的补码
     * @param a
     * @return
     */
    private static int getComplementCode(int a){
        return userBitAdd(~a, 1);
    }

    /**
     * 二进制a,b
     * @param a
     * @param b
     * @return
     */
    private static int userBitMultiply(int a, int b){
        int ans = 0;
        while(b != 0){
            if((b&1)!=0){
                ans = userBitAdd(a,ans);
            }
            a = a << 1;
            b= b >>> 1;
        }
        return ans;
    }

    private static int dev(int a, int b){
        int cA = a > 0 ? a: getComplementCode(a);
        int cB = b>0? b:getComplementCode(b);
        int ans = 0;
        for(int i= 31;i>=0;i--){
            if((cA >> i) >= b){
                ans |= (1<<i);
                cA = userBitMinus(cA, cB<< i);
            }
        }
        return isNeg(a) ^ isNeg(b)? getComplementCode(ans) : ans;
    }
    private static boolean isNeg(int a){
        return a<0;
    }

    public static void main(String[] args) {
        System.out.println(userBitMinus(5,2));
        System.out.println(true ^ false);
    }


}
