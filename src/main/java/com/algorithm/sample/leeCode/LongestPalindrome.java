package com.algorithm.sample.leeCode;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <5. 最长回文子串>
 *
 * 方法一（暴力解法）
 * 方法二（中心扩散）
 * 方法三（动态规划）
 * 方法四（Manacher算法）
 *
 */
public class LongestPalindrome {
     public static int maxLeh = 1000;

    /**
     * 方法一（暴力解法）
     * @author LeeCode
     */
    public String longestPalindrome1(String s) {
        return null;
    }

    /**
     * 方法二（中心扩散）
     * @author LeeCode
     */
    public String longestPalindrome2(String s) {

        if (s == null || s.length() < 1) {
            return "";
        }

        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    public int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }


    /**
     * 方法三（动态规划）
     */
    public String longestPalindrome3(String s) {
        int len = s.length();
        if(len < 2){
            return s;
        }

        int maxLen = 1;
        int begin = 0;

        boolean[][] dp = new boolean[len][len];
        for(int i =0; i < len; i++){
            dp[i][i] = true;
        }

        char[] strArr = s.toCharArray();
        for(int j =0; j < len; j++){
            for(int i = 0; i < j; i++){
                if(strArr[i] != strArr[j]){
                    dp[i][j] = false;
                } else {
                    if(j-i<3){
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }

                if(dp[i][j] && j-i+1 > maxLen){
                    maxLen = j-i+1;
                    begin = i;
                }

            }
        }
        return s.substring(begin, begin+maxLen);
    }

    /**
     * 方法四（Manacher算法）
     */
    public String longestPalindrome4(String s) {
        return null;
    }

    /**
     * just for practise
     */
    public String longestPalindrome(String s) {
        return null;
    }

    public static void main(String[] args) {
        String str = "123224567777877777098";
//        System.out.println(new LongestPalindrome().longestPalindrome1(str));
//        System.out.println(new LongestPalindrome().longestPalindrome2(str));
//        System.out.println(new LongestPalindrome().longestPalindrome3(str));
//        System.out.println(new LongestPalindrome().longestPalindrome4(str));
        System.out.println(new LongestPalindrome().longestPalindrome(str));
    }

}
