package level03;

/*
 * 문제: 정수 삼각형
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/43105
 * 해결방법: DP
 * */

import java.util.Arrays;

public class Programmers43105 {
    class Solution {
        public int solution(int[][] triangle) {
            int n = triangle.length;
            int[][] dp = new int[n][n];

            // 첫 번째 원소 초기화
            dp[0][0] = triangle[0][0];

            // DP 점화식 적용
            for (int i = 1; i < n; i++) {
                for (int j = 0; j <= i; j++) {  // 삼각형 구조에 맞게 j 범위 조정
                    if (j == 0) {
                        // 왼쪽 끝
                        dp[i][j] = dp[i - 1][j] + triangle[i][j];
                    } else if (j == i) {
                        // 오른쪽 끝
                        dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                    } else {
                        // 중간 값
                        dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
                    }
                }
            }

            // 마지막 줄에서 최댓값 찾기
            return Arrays.stream(dp[triangle.length - 1])
                    .max()
                    .orElse(-1);
        }
    }
}
