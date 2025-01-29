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
        PriorityQueue<MineralSet> mineralQueue = new PriorityQueue<>(
                (m1, m2) -> Integer.compare(m2.getTotalFatigue(), m1.getTotalFatigue()));

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
                mineralQueue.add(new MineralSet(diaCount, ironCount, stoneCount));
                diaCount = 0;
                ironCount = 0;
                stoneCount = 0;
            }
        }

        int pickIndex = 0;
        while (!mineralQueue.isEmpty()) {
            while (pickIndex < 3 && picks[pickIndex] == 0) {
                pickIndex++;
            }
            if (pickIndex == 3) break;

            MineralSet mineralSet = mineralQueue.poll();
            answer += mineralSet.getFatigue(pickIndex);
            picks[pickIndex]--;
        }
        return answer;
    }
}

class MineralSet {
    private static final int DIA_FATIGUE = 25;
    private static final int IRON_FATIGUE = 5;
    private static final int STONE_FATIGUE = 1;

    private int diaCount;
    private int ironCount;
    private int stoneCount;

    public MineralSet(int diaCount, int ironCount, int stoneCount) {
        this.diaCount = diaCount;
        this.ironCount = ironCount;
        this.stoneCount = stoneCount;
    }

    public int getTotalFatigue() {
        return diaCount * DIA_FATIGUE + ironCount * IRON_FATIGUE + stoneCount * STONE_FATIGUE;
    }

    public int getFatigue(int pickIndex) {
        return switch (pickIndex) {
            case 0 -> diaCount + ironCount + stoneCount;
            case 1 -> diaCount * 5 + ironCount + stoneCount;
            case 2 -> diaCount * 25 + ironCount * 5 + stoneCount;
            default -> 0;
        };
    }
}