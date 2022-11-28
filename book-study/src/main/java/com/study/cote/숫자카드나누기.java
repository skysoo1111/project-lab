package com.study.cote;

public class 숫자카드나누기 {
    public static void main(String[] args) {
        int[] arrayA = {10, 17};
        int[] arrayB = {5, 20};

        int solution = solution(arrayA, arrayB);
        System.out.println(solution);

    }

    public static int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        for (int i = 0; i < arrayA.length -1; i++) {
            if (arrayA[i] % arrayA[i+1] == 0) {

            }
        }
        return answer;
    }
}
