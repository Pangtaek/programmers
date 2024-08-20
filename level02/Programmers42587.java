package level02;

import java.util.ArrayDeque;
import java.util.Deque;

/* 문제: 프로세스
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42587
 * 평가: deque를 사용해야겠다는 판단을 빠르게 했으나, 배열의 인덱스 값과 벨류값을 어떻게 저장할 것인가에 대한 고민을 많이 한것 같다.
 *      또한, deque의 값을 확인하는 과정에서 max 값의 갱신하지 않아 무한루프를 도는 문제점이 있다.
 *      굳이 for 문 보다는 deque와 while의 기능을 더 활용했으면 오류 없이 풀었을 것 같다.*/

public class Programmers42587 {
    public static void main(String[] args) {
        System.out.println(new Programmers42587().solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
    }

    public int solution(int[] priorities, int location) {
        int answer = 0;

        Deque<Process> deque = new ArrayDeque<>();

        for (int i = 0; i < priorities.length; i++) {
            Process process = new Process(priorities[i], i);
            deque.addLast(process);
        }

        System.out.print("초기값: ");
        for (Process process : deque) {
            System.out.print(process.priority + " ");
        }
        System.out.println();

        while (!deque.isEmpty()) {
            // 현재 대기 중인 프로세스의 우선순위 중 최대값을 찾습니다.
            int max = deque.stream().mapToInt(p -> p.priority).max().orElse(Integer.MIN_VALUE);

            // 현재 맨 앞의 프로세스를 확인합니다.
            Process current = deque.pollFirst();

            if (current.priority == max) {
                // 현재 프로세스가 가장 높은 우선순위를 가진 경우
                answer++;
                if (current.index == location) {
                    // 요청한 위치의 프로세스가 출력된 경우
                    return answer;
                }
            } else {
                // 현재 프로세스가 가장 높은 우선순위가 아닌 경우
                deque.addLast(current); // 맨 뒤로 보냅니다.
            }
        }

//        for (Process p : deque) {
//            if (p.priority != max) {
//                answer++;
//                deque.addLast(deque.pollFirst());
//                System.out.println("맨 뒤로 넘김");
//                for (Process process : deque) {
//                    System.out.print(process.priority + " ");
//                }
//                System.out.println();
//
//            } else {
//                if (deque.peekFirst().index == location) {
//                    return answer;
//                }
//
//                deque.pollFirst();
//                if (deque != null) {
//                    max = deque.peekFirst().priority;
//                    for (Process process : deque) {
//                        if (process.priority > max) {
//                            max = process.priority;
//                        }
//                    }
//                }
//            }
//        }

        return answer;
    }

    public static class Process {
        int priority;
        int index;

        Process(int priority, int index) {
            this.priority = priority;
            this.index = index;
        }
    }
}
