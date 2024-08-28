package level02;

import java.util.Arrays;

/* 문제: 타겟 넘버
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/43165 */
public class Programmers43165 {

    public static int count = 0;

    public int solution(int[] numbers, int target) {
        count = 0; // count 초기화

        dfs(numbers, 0, 0, target); // DFS 시작
        return count;
    }

    public static void dfs(int[] numbers, int depth, int sum, int target) {
        // 모든 숫자를 사용한 경우
        if (depth == numbers.length) {
            if (sum == target) {
                count++; // 타겟과 합이 같으면 카운트 증가
            }
            return;
        }

        // 현재 숫자를 더하는 경우
        dfs(numbers, depth + 1, sum + numbers[depth], target);
        // 현재 숫자를 빼는 경우
        dfs(numbers, depth + 1, sum - numbers[depth], target);
    }
}
