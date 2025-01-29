package level02;

/*
 * 문제: 조이스틱
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42860
 * */

public class Programmers42860 {
    public int solution(String name) {
        int length = name.length();
        int answer = 0;
        int minMove = length - 1;  // 기본적으로 오른쪽으로 이동하는 경우

        // 1. 알파벳 변경하는 최소 조작 횟수 계산
        for (int i = 0; i < length; i++) {
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            // 2. 커서 이동 최적화
            int nextIndex = i + 1;
            while (nextIndex < length
                    && name.charAt(nextIndex) == 'A') {
                nextIndex++;
            }

            // 3. 왼쪽으로 이동하는 경우 고려
            minMove = Math.min(minMove, i + length - nextIndex + Math.min(i, length - nextIndex));
        }

        return answer + minMove;
    }
}
