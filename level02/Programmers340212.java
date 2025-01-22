package level02;

/*
 * 문제명: [PCCP 기출문제] 2번 / 퍼즐 게임 챌린지
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/340212
 * 문제 설명: 제한시간 안에 모든 문제를 해결할 수 있는 플레이어의 레벨의 최소값을 구하는 문제
 * 해경 방법: 이진탐색을 통해 가장 적합한 플레이어 레벨을 찾는다.
 * */

public class Programmers340212 {

    public static void main(String[] args) {
        int[] diffs = {1, 328, 467, 209, 54};
        int[] times = {2, 7, 1, 4, 3};
        int limit = 1723;
        int result = 294;

        System.out.println(result == solution(diffs, times, limit));
    }

    public static int solution(int[] diffs, int[] times, int limit) {
        int max = 1;
        int min = 100000;

        while (max <= min) {
            int level = (max + min) / 2;
            long mid = calcul(diffs, times, level);

            if (mid > limit) {
                max = level + 1;
            } else {
                min = level - 1;
            }
        }

        return max;
    }

    public static long calcul(int[] diffs, int[] times, int level) {
        long ans = 0;

        for (int i = 0; i < diffs.length; i++) {
            if (diffs[i] < level) {
                ans += times[i];
            } else {
                long additionalTime = (i > 0) ? (long) (times[i] + times[i - 1]) * (long) (diffs[i] - level) : 0;
                ans += additionalTime + times[i];
            }
        }

        return ans;
    }
}
