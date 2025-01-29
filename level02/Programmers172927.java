package level02;

import java.util.*;

/*
 * 문제: 광물 캐기
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/172927
 * 해결 방법: 그리디 알고리즘. 광물을 5개씩 묶고 가장 효율 좋은 곡괭이를 선택하여 사용
 * */

public class Programmers172927 {
    private static final String DIA = "diamond";
    private static final String IRON = "iron";
    private static final String STONE = "stone";

    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        List<int[]> mineralGroups = new ArrayList<>();

        int totalPicks = Arrays.stream(picks).sum();
        int maxMiningAmount = Math.min(totalPicks * 5, minerals.length);

        int diaCount = 0, ironCount = 0, stoneCount = 0;

        for (int i = 0; i < maxMiningAmount; i++) {
            switch (minerals[i]) {
                case DIA -> diaCount++;
                case IRON -> ironCount++;
                case STONE -> stoneCount++;
            }

            if ((i + 1) % 5 == 0 || i == maxMiningAmount - 1) {
                mineralGroups.add(new int[]{diaCount, ironCount, stoneCount});
                diaCount = 0;
                ironCount = 0;
                stoneCount = 0;
            }
        }

        mineralGroups.sort((a, b) -> {
            if (b[0] != a[0]) return Integer.compare(b[0], a[0]);
            if (b[1] != a[1]) return Integer.compare(b[1], a[1]);
            return Integer.compare(b[2], a[2]);
        });

        int pickIndex = 0;
        for (int[] group : mineralGroups) {
            while (pickIndex < 3 && picks[pickIndex] == 0) {
                pickIndex++;
            }
            if (pickIndex == 3) break;

            int dia = group[0], iron = group[1], stone = group[2];
            if (pickIndex == 0) {
                answer += dia + iron + stone;
            } else if (pickIndex == 1) {
                answer += dia * 5 + iron + stone;
            } else {
                answer += dia * 25 + iron * 5 + stone;
            }

            picks[pickIndex]--;
        }
        return answer;
    }
}