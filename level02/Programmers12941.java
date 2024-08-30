package level02;

import java.util.Arrays;

/* 문제: 최솟값 만들기
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12941
 * 풀이: 프로그래머스 구명보트 문제와 같이 배열을 정렬하고 가장 큰값과 가장 작은 값의 곱을 누적하고 반환한다. */

public class Programmers12941 {

    public int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[B.length - 1 - i];
        }

        return answer;
    }
}
