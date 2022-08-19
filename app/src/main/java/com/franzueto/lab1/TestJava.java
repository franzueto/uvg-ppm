package com.franzueto.lab1;

import java.util.ArrayList;
import java.util.List;

public class TestJava {

    public void test() {
        int one = 1;
        int oneLong = one;
    }

    public static int calPoints(String[] ops) {
        List<Integer> scores = new ArrayList<Integer>();
        for (int i = 0; i < ops.length - 1; i++) {
            final String op = ops[i];
            switch (op) {
                case "C":
                    int result = scores.remove(i - 1);
                    break;
                case "D":
                    scores.add(scores.get(i - 1));
                    break;
                case "+":
                    scores.add(scores.get(i - 2) + scores.get(i - 1));
                    break;
                default:
                    final int value = Integer.parseInt(op);
                    scores.add(value);
                    break;
            }
        }

        return 1;
    }
}