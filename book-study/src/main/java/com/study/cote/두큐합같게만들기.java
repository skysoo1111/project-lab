package com.study.cote;

import java.util.*;
import java.util.stream.Collectors;

public class 두큐합같게만들기 {
    public static void main(String[] args) {
//        int[] queue1 = {3, 2, 7, 2};
//        int[] queue2 = {4, 6, 5, 1};

        int[] queue1 = {1, 1};
        int[] queue2 = {1, 5};

        int solution = solution1(queue1, queue2);
    }

    public static int solution(int[] queue1, int[] queue2) {
        int answer = 0;

        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();

        for (int i : queue1) {
            q1.add(i);
        }
        for (int i : queue2) {
            q2.add(i);
        }

        long sum1 = q1.stream().mapToInt(i->i).sum();
        long sum2 = q2.stream().mapToInt(i->i).sum();
        long sum = sum1 + sum2;
        // 똑같이 나눌수 없는 값이라면 -1 리턴
        if (sum % 2 != 0) return -1;
        // 각 큐의 합이 도출해야 할 값
        long result = sum / 2;

        while (sum1 != result) {
            // queue1에서 queue2로
            if (sum1 > sum2) {
                sum1-=q1.peek();
                sum2+=q1.peek();
                q2.add(q1.poll());
                if (q1.isEmpty()) {
                    return -1;
                }
                answer++;
            // queue2에서 queue1으로
            } else if (sum1 < sum2) {
                sum2-=q2.peek();
                sum1+=q2.peek();
                q1.add(q2.poll());
                if (q2.isEmpty()) {
                    return -1;
                }
                answer++;
            }
            // answer는 q1이 모두 q2로 옮긴 수 + q2가 모두 a1으로 옮긴 수 보다 클 수 없다.
            if(answer > (q1.size() + q2.size()) * 2) return -1;
        }
        return answer;
    }

    public static int solution1(int[] queue1, int[] queue2) {
        int answer = 0;

        LinkedList<Integer> list1 = Arrays.stream(queue1).boxed().collect(Collectors.toCollection(LinkedList::new));
        LinkedList<Integer> list2 = Arrays.stream(queue2).boxed().collect(Collectors.toCollection(LinkedList::new));

        long sum1 = list1.stream().mapToInt(i->i).sum();
        long sum2 = list2.stream().mapToInt(i->i).sum();
        long sum = sum1 + sum2;
        // 똑같이 나눌수 없는 값이라면 -1 리턴
        if (sum % 2 != 0) return -1;
        // 각 큐의 합이 도출해야 할 값
        long result = sum / 2;

        while (sum1 != result) {
            // list1에서 list2로
            if (sum1 > sum2) {
                Integer pop = list1.get(0);
                list1.remove(0);
                sum1-= pop;
                sum2+= pop;
                list2.add(pop);
                if (list1.isEmpty()) {
                    return -1;
                }
                answer++;
            // list2에서 list1으로
            } else if (sum1 < sum2) {
                Integer pop = list2.get(0);
                list2.remove(0);

                sum2-= pop;
                sum1+= pop;
                list1.add(pop);
                if (list2.isEmpty()) {
                    return -1;
                }
                answer++;
            }
            // answer는 list1이 모두 list2로 옮긴 수 + list2가 모두 list1으로 옮긴 수 보다 클 수 없다.
            if(answer > (list1.size() + list2.size()) * 2) return -1;
        }
        return answer;
    }
}
