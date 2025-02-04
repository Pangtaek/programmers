package level01;

import java.util.Arrays;

/*
 * 문제: 체육복
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42862
 * 해결방법: 그리디 알고리즘
 * */

public class Programmers42862 {
    public int solution(int n, int[] lost, int[] reserve) {
        // 정렬 처리
        sort(lost, reserve);

        // 여벌 체육복을 가진 학생 중 도난당한 학생 처리
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }

        // 체육복 빌려주기
        int count = n - lost.length;  // 기본적으로 체육 수업 가능한 학생 수
        for (int l : lost) {
            if (l == -1) {  // 이미 자기 자신이 체육복을 가지고 있는 경우
                count++;
                continue;
            }
            for (int j = 0; j < reserve.length; j++) {
                if (reserve[j] == l - 1 || reserve[j] == l + 1) {
                    count++;
                    reserve[j] = -1;  // 체육복을 빌려줬으므로 더 이상 사용 불가
                    break;
                }
            }
        }

        return count;
    }

    public void sort(int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);
    }
}
