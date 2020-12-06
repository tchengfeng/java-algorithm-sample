package com.algorithm.sample.leeCode;

public class Reverse {

    /**
     * tongchengfeng
     */
    public int reverse1(int x) {

        if(x > Math.pow(2,31) - 1 || x < 0 - Math.pow(2,31)){
            return 0;
        }

        int originalValue = (x > 0) ? x : -x;

        String str  = String.valueOf(originalValue);
        char[] charArr = str.toCharArray();

        char temp;
        int len = charArr.length;
        for(int i = 0, j = len -1; i <= j; i++, j--){
            temp = charArr[i];
            charArr[i] = charArr[j];
            charArr[j] = temp;
        }

        String resultStr = "";
        for(int k = 0; k < len; k++){
            resultStr += charArr[k];
        }

        int resultInt = Integer.parseInt(resultStr);
        return x > 0 ? resultInt : -resultInt;

    }

    /**
     * LeeCode
     */
    public int reverse2(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static void main(String[] args) {
//        System.out.println(new Reverse().reverse2(964632435));
        System.out.println(Integer.MIN_VALUE);
    }

}
