package com.col.sample.greedy;

public class GiveMoney {

    public void testGiveMoney() {
        //找零钱
        int[] m = {25, 10, 5, 1};
        int target = 99;
        int[] results = giveMoney(m, target);
        System.out.println(target + "的找钱方案:");
        for (int i = 0; i < results.length; i++) {
            System.out.println(results[i] + "枚" + m[i] + "面值");
        }
    }

    public int[] giveMoney(int[] m, int target) {
        int k = m.length;
        int[] num = new int[k];
        for (int i = 0; i < k; i++) {
            num[i] = target / m[i];
            target = target % m[i];
        }
        return num;
    }

    public static void main(String[] args) {
        new GiveMoney().testGiveMoney();
    }


}
