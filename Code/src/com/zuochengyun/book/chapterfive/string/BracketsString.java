package com.zuochengyun.book.chapterfive.string;
/**
 * 括号字符串
 * @author caizongyu
 *
 */
public class BracketsString {
	/**
	 * 判断是不是正确的括号字符串
	 * @param s
	 * @return
	 */
	private static boolean effectiveString(String s) {
		if(s==null || s.length()<1){
			return false;
		}
		if((s.length()&1)==1) {
			return false;
		}
		int count=0;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i) == '(' || s.charAt(i) == ')') {
				if(s.charAt(i) == '(') {
					++count;
				}else {
					--count;
				}
				if(count<0) {
					return false;
				}
			}else {
				return false;
			}
		}
		return count==0?true:false;
	}
	/**
	 * 
	 * @param s
	 * @return
	 */
	private static int getMaxBracketString(String s) {
		if(s==null ||s.length()<1) {
			return -1;
		}
		int left=0;
		int ans =0;
		int[] dp = new int[s.length()];
		//int begin=-1;int end=-1;
		for(int i=1;i<s.length();i++) {
			if(s.charAt(i) == ')') {
				left=i-dp[i-1]-1;
				//说明没有从头开始
				if(left>=0 && s.charAt(i)=='(') {
					dp[i] = 2+dp[i-1]+(left>0 ? dp[left-1] : 0);
				}
				
			}
			ans = Math.max(ans, dp[i]);	
			System.out.print(dp[i]+ " ");
		}
		return ans;
	}
	public static void main(String[] args) {
		System.out.println(getMaxBracketString("(()())"));
		//System.out.println(getMaxBracketString("(("));
		//System.out.println(getMaxBracketString("()()"));
		//System.out.println(getMaxBracketString("()())("));
		
	}
}

