package com.study.cote;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class 귤고르기 {
    public static void main(String[] args) {
        int k = 6;
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};
        solution(k, tangerine);
    }

    public static int solution(int k, int[] tangerine) {
        int answer = 0;

        List<Map.Entry<Integer, Long>> collect = Arrays.stream(tangerine)
                .boxed()
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toList());

        for (Map.Entry<Integer, Long> entry : collect) {
            k -= entry.getValue();
            answer++;
            if (k<=0) return answer;
        }

        return answer;
    }
}
