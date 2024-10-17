package level02;

/* 문제: 과제 진행하기
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/176962
 * */

import java.util.*;

public class Programmers176962 {

    public String[] solution(String[][] plans) {
        ArrayList<String> answer = new ArrayList<>();

        // 1. 우선 배열을 시작 시간순으로 정렬한다.
        sort(plans);

        Queue<String[]> queue = new LinkedList<>(Arrays.asList(plans));
        Stack<String[]> stack = new Stack<>();
        stack.push(queue.poll());

        while (!stack.isEmpty()) {
            String[] current = stack.pop();

            int endTime = Integer.parseInt(current[1]);
            if (Integer.parseInt(current[2]) >= 60) {
                int qns = Integer.parseInt(current[2]) % 60;
                int tl = Integer.parseInt(current[2]) / 60 * 100;

                endTime += qns;
                endTime += tl;

            } else {
                endTime += Integer.parseInt(current[2]);
            }

            // 시간 조정(ex: 1260 -> 1300)
            if (endTime % 100 >= 60) {
                int hour = endTime / 100;
                int minute = endTime % 100;

                hour += minute / 60; // 시간 증가
                minute = minute % 60; // 분은 60으로 나눈 나머지

                endTime = hour * 100 + minute;
            }

            // 다음 과제보다 일찍 끝나는 경우
            if (!queue.isEmpty() && endTime <= Integer.parseInt(queue.peek()[1])) {
                answer.add(current[0]);
                stack.push(queue.poll());
            }
            // 다음 과제 시작 시간 전보다 늦게 끝나서 미룸
            else if (!queue.isEmpty() && endTime > Integer.parseInt(queue.peek()[1])) {
                int remain = Integer.parseInt(queue.peek()[1]) - Integer.parseInt(current[1]);
                current[2] = Integer.toString(Integer.parseInt(current[2]) - remain);
                stack.push(current);
                stack.push(queue.poll());
            } else {
                answer.add(current[0]);
            }
        }

        return answer.toArray(new String[0]);
    }

    // 배열을 시작 시간 기준 오름차순으로 정렬하는 메소드
    public static String[][] sort(String[][] plans) {
        for (int i = 0; i < plans.length; i++) {
            plans[i][1] = plans[i][1].replace(":", "");
        }

        Arrays.sort(plans, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]);
            }
        });

        return plans;
    }

    // 배열을 원하는 형식으로 출력하는 메서드
    public static String formatOutput(String[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            sb.append("\"").append(array[i]).append("\"");
            if (i < array.length - 1) {
                sb.append(", "); // 마지막 요소가 아닐 경우 쉼표 추가
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        Programmers176962 solution = new Programmers176962();
        String[][] plans = {
                {"art", "11:00", "90"},
                {"music", "11:30", "30"},
                {"dance", "12:00", "60"},
                {"theater", "13:00", "30"}
        };


        String[] answer = solution.solution(plans);
        System.out.println(formatOutput(answer));
    }
}
