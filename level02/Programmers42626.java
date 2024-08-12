package level02;

import java.util.PriorityQueue;

public class Programmers42626 {
    public static void main(String[] args) {
        System.out.println(new Programmers42626().solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
    }

    public int solution(int[] scoville, int K) {
        int answer = 0; // 결과로 반환할 스코빌 지수 조합 횟수
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 우선순위 큐 생성

        // 입력 배열이 null이 아니고 K가 0보다 큰 경우에만 실행
        if (scoville != null && K > 0) {
            for (int i : scoville) {
                pq.add(i); // 스코빌 지수를 큐에 추가
            }
        }

        // 큐에서 두 개의 요소를 안전하게 폴링하기 위한 루프
        // 큐에 두 개 이상의 요소가 있고, 가장 낮은 스코빌 지수가 K보다 작은 경우에만 반복
        while (pq.size() > 1 && pq.peek() < K) {
            Integer num1 = pq.poll(); // 가장 낮은 스코빌 지수
            Integer num2 = pq.poll(); // 두 번째로 낮은 스코빌 지수

            // num1 또는 num2가 null인 경우, 루프 종료
            if (num1 == null || num2 == null) {
                break; // 큐에서 더 이상 요소를 꺼낼 수 없으므로 종료
            }

            int newMenu = num1 + (num2 * 2); // 새로운 스코빌 지수 계산
            pq.add(newMenu); // 새로운 스코빌 지수를 큐에 추가
            answer++; // 조합 횟수 증가
        }

        // K 이상의 스코빌 지수가 만들어졌으면 answer 반환, 그렇지 않으면 -1 반환
        return pq.peek() != null && pq.peek() >= K ? answer : -1;
    }
}
