package com.study.cote;

import java.util.HashSet;
import java.util.Set;

public class 연속부분수열합의개수 {
    public static void main(String[] args) {
        int[] elements = {7,9,1,1,4};

        int solution = solution(elements);
        System.out.println(solution);

    }

    public static int solution(int[] elements) {
        int answer = 0;
        int length = elements.length;
        Set result = new HashSet();

        for (int i = 1; i <= elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                int sum = 0;
                for (int k = 0; k < i; k++) {
                    sum += elements[k];
                }
                result.add(sum);
            }
        }
        return answer;
    }
}
