package com.arr;

/**
 * 子矩阵的最大累加和
 */
public class SonMatrixMaxAdd {
    private static Integer getResult(int[][] arr){
        if(arr==null){
            return null;
        }
        int ans = Integer.MIN_VALUE;
        int lenY = arr.length;
        int[] sumArr = null;
        int cur = 0;
        for(int i=0;i<lenY;i++){
            sumArr = new int[arr.length];
            for(int j=i;j<lenY;j++){
                cur = 0;
                for(int k=0;k< arr[0].length;k++){
                    sumArr[k] += arr[j][k];
                    cur += sumArr[k];
                    ans = Math.max(ans, arr[j][k] < cur? cur:arr[j][k]);
                    if(cur<0){
                        cur = 0;
                    }
                }

            }
        }
        return ans;
    }

    private static int getArrMax(int[] arr){
        int ans = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
            ans = Math.max(ans, arr[i]);
            ans = Math.max(ans, sum);
            if(sum < 0){
                sum  = 0;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] arr = {{-90, 48, 78},{64,-40,64},{-81,-7,66}};
        System.out.println(getResult(arr));
    }
}
