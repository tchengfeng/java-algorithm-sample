package com.algorithm.sample.leeCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个字符串，判断该字符串中是否可以通过重新排列组合，形成一个回文字符串。
 * <266. 回文排列>
 */
public class CanPermutePalindrome {

    /**
     * @author LeeCode
     * <方法一：穷举>
     */
    public boolean canPermutePalindrome1(String s) {
        int count = 0;
        for (char i = 0; i < 128 && count <= 1; i++) {
            int ct = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == i)
                    ct++;
            }
            count += ct % 2;
        }
        return count <= 1;
    }

    /**
     * @author tongchengfeng
     * <方法二：基于哈希的映射表（HashMap）>
     */
    public boolean canPermutePalindrome21(String s) {

        char[] charArray = s.toCharArray();
        Map<Character, Integer> calMap = new HashMap<>(); // TODO
        int len = charArray.length;
        for(int i =0; i < len; i++){
            Character c = charArray[i];
            if(calMap.get(c) != null){
                Integer integer = calMap.get(c);
                calMap.put(c,++integer);
            } else {
                calMap.put(c,1);
            }
        }

        int count = 0;
        for (Integer i : calMap.values()) {
            if(i % 2 != 0){
                count += 1;
            }
        }

        return count <=1;

    }

    /**
     * @author LeeCode
     * <方法二：基于哈希的映射表（HashMap）>
     */
    public boolean canPermutePalindrome22(String s) {
        HashMap < Character, Integer > map = new HashMap < > ();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1); // TODO:good
        }
        int count = 0;
        for (char key: map.keySet()) {
            count += map.get(key) % 2;
        }
        return count <= 1;
    }

    /**
     * @author LeeCode
     * 因为不同的字符数目最多只有 128 个，因此我们可以用长度为 128 的数组代替映射表。
     * <方法三：数组>
     */
    public boolean canPermutePalindrome3(String s) {
        int[] map = new int[128];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++; // TODO: function-charAt()
        }
        int count = 0;
        for (int key = 0; key < map.length && count <= 1; key++) {
            count += map[key] % 2;
        }
        return count <= 1;
    }

    /**
     * @author LeeCode
     * 因为不同的字符数目最多只有 128 个，因此我们可以用长度为 128 的数组代替映射表。
     * <方法四：数组+单次循环>
     */
    public boolean canPermutePalindrome4(String s) {
        int[] map = new int[128];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++;
            if (map[s.charAt(i)] % 2 == 0)
                count--;
            else
                count++;
        }
        return count <= 1;
    }

    /**
     * @author LeeCode
     * 方法四也可以使用集合而不是数组来实现。
     * <方法五：集合>
     */
    public boolean canPermutePalindrome5(String s) {
        Set< Character > set = new HashSet< >();
        for (int i = 0; i < s.length(); i++) {
            if (!set.add(s.charAt(i)))
                set.remove(s.charAt(i));
        }
        return set.size() <= 1;
    }

    public static void main(String[] args) {
        String str = "aaabbbccc";
//        boolean result = new CanPermutePalindrome().canPermutePalindrome1(str);
//        boolean result = new CanPermutePalindrome().canPermutePalindrome21(str); // tongchengfeng
//        boolean result = new CanPermutePalindrome().canPermutePalindrome22(str);
        boolean result = new CanPermutePalindrome().canPermutePalindrome3(str);
//        boolean result = new CanPermutePalindrome().canPermutePalindrome4(str);
//        boolean result = new CanPermutePalindrome().canPermutePalindrome5(str);
        System.out.println(result);

    }

}
