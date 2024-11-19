package level02;

import java.util.LinkedList;
import java.util.Queue;

public class Programmers118667 {

    public static void main(String[] args) {

        System.out.println(new Programmers118667().solution(
                new int[]{3, 2, 7, 2},
                new int[]{4, 6, 5, 1}
        ));
    }

    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum = 0;
        long sumOfQueue1 = 0;
        long sumOfQueue2 = 0;
        long half = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for (int num : queue1) {
            q1.offer(num);
            sum += num;
            sumOfQueue1 += num;
        }

        for (int num : queue2) {
            q2.offer(num);
            sum += num;
            sumOfQueue2 += num;
        }

        // 합이 홀수인 경우
        if (sum % 2 != 0) {
            return -1;
        } else {
            half = sum / 2;
        }

        // 최대 이동 횟수 설정
        int maxOperations = (queue1.length + queue2.length) * 2;

        while (sumOfQueue1 != sumOfQueue2) {
            if (answer >= maxOperations) {
                return -1; // 최대 이동 횟수를 초과한 경우
            }
            if (sumOfQueue1 > half) {
                Integer temp = q1.poll();
                q2.offer(temp);
                sumOfQueue1 -= temp;
                sumOfQueue2 += temp;
                answer++;
            } else if (sumOfQueue2 > half) {
                Integer temp = q2.poll();
                q1.offer(temp);
                sumOfQueue2 -= temp;
                sumOfQueue1 += temp;
                answer++;
            }
        }

        return answer;
    }
}
