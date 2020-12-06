package com.col.sample.greedy;

import java.util.ArrayList;
import java.util.List;

public class ArrangeActivity {


    /**
     * 活动时间安排
     */
    public void testArrangeActivity() {
        int[] start = {1, 3, 0, 5, 3, 5, 6, 8, 8, 2, 12};
        int[] end = {4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        List<Integer> results = arrangeActivity(start, end);
        for (int i = 0; i < results.size(); i++) {
            int index = results.get(i);
            System.out.println("开始时间:" + start[index] + ",结束时间:" + end[index]);
        }
    }

    /**
     * 活动安排
     *
     * @param s 开始时间
     * @param e 结束时间
     * @return
     */
    public List<Integer> arrangeActivity(int[] s, int[] e) {
        int total = s.length;
        int endFlag = e[0];
        List<Integer> results = new ArrayList<>();
        results.add(0);
        for (int i = 1; i < total; i++) {
            if (s[i] > endFlag) {
                results.add(i);
                endFlag = e[i];
            }
        }
        return results;
    }

    public static void main(String[] args) {
        new ArrangeActivity().testArrangeActivity();
    }

}
