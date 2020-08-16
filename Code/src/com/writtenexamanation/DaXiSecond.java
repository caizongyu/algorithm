package com.writtenexamanation;

/**
 * 给定⼀个⾮空字符串 s 和⼀个缩写 abbr，请校验它们是否匹配。
 * 假设字符串中只包含⼩写字⺟，缩写中只包含⼩写字⺟和数字。缩写中的数字
 * 表示其缩略的字符数；连续多位数字表示⼀个多位数。
 * 例如，字符串 “word” 的缩写有且仅有以下这些：[“word", "1ord", "w1rd",
 * "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d",
 * "w3", “4"]。
 */
public class DaXiSecond {
    private static boolean valid(String word, String abbr){
        if(word == null || abbr == null ||abbr.length()>word.length()){
            return false;
        }
        char[] words = word.toCharArray();
        char[] addrs = abbr.toCharArray();
        int index=0;
        String ans="";
        String current="";
        for(int i=0;i<abbr.length();i++){
            if(addrs[i]>= 'a'  && addrs[i]<='z'){
                index = current.length()>0 ? Integer.parseInt(current) : 0;
                current="";
                if(ans.length()+index>words.length){
                    return false;
                }
                for(int j=0;j<index;j++){
                    ans += "*";
                }
                ans +=addrs[i];
            }else{
                current +=addrs[i];
            }
        }
        for(int i=0;i<ans.length();i++){
            if(words[i] != ans.charAt(i) && ans.charAt(i)!='*'){
                return false;
            }
        }
        int free = current.length()>0 ? Integer.parseInt(current):0;
        if(free+ans.length() != words.length){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s= "aaa";
        String abbr ="2a";
        System.out.println(valid(s, abbr));
    }
}
