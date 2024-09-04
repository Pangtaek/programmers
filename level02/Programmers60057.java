package level02;

import java.util.LinkedList;
import java.util.Queue;

/* 문제: 문자열 압축
 * 출처: 2020 KAKAO BLIND RECRUITMENT
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/60057
 * 설명: 완전탐색이라고 생각하고 일정 크기의 문자열을 큐에 넣고 순서대로 비교 후, 결과 문자열에 넣고 가장 짧은 문자열의 길이를 반환
 *      문자열의 길이가 1일때 고려해야 된다는 것을 추후에 알게됨. IF문 추가했음.
 *      (입력 문자열의 길이가 1이면 substring 메소드에서 파싱이 안됨.) */

public class Programmers60057 {

    public static void main(String[] args) {
        System.out.println(new Programmers60057().solution("ababcdcdababcdcd")); // 결과: 7
    }

    public int solution(String s) {
        int answer = Integer.MAX_VALUE;

        if(s.length() == 1) {
            return 1;
        }

        for (int i = 1; i <= s.length() / 2; i++) {
            Queue<String> queue = new LinkedList<>();
            int startIndex = 0;
            int endIndex;

            // 문자열을 i 길이로 나누어 큐에 추가
            while (startIndex < s.length()) {
                endIndex = Math.min(startIndex + i, s.length());
                queue.offer(s.substring(startIndex, endIndex));
                startIndex += i;
            }

            StringBuilder result = new StringBuilder();
            String prev = queue.poll(); // 첫 번째 요소를 가져옴
            int count = 1;

            // 큐의 모든 요소를 압축
            while (!queue.isEmpty()) {
                String current = queue.poll();

                if (current.equals(prev)) {
                    count++;
                } else {
                    if (count > 1) {
                        result.append(count); // 카운트 추가
                    }
                    result.append(prev); // 이전 문자열 추가
                    prev = current; // 현재 문자열을 이전으로 갱신
                    count = 1; // 카운트 리셋
                }
            }

            // 마지막 문자열 추가
            if (count > 1) {
                result.append(count);
            }
            result.append(prev);

            // 최소 길이 업데이트
            answer = Math.min(answer, result.length());
        }

        return answer;
    }
}
