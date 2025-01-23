package level02;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/*
* 문제: 광물 킥
* 링크: https://school.programmers.co.kr/learn/courses/30/lessons/172927
* 해결 방법: 그리디 알고리즘. 광물을 5개씩 묶고 가장 효율 좋은 곡괭이를 선택하여 사용
* */

public class Programmers172927 {

    public static final String DIA = "diamond";
    public static final String IRON = "iron";
    public static final String STONE = "stone";


    public int solution(int[] picks, String[] minerals) {

        PriorityQueue<MineralSet> mineralQueue = new PriorityQueue<>((m1, m2) -> m2.getTotalFatigue() - m1.getTotalFatigue());
        Queue<String> toolQueue = new LinkedList<>();
        int answer = 0;

        // 다이아->철->돌 순으로 곡갱이 큐에 삽입하기
        int toolCount = picks[0] + picks[1] + picks[2];
        for (int i = 0; i < 3; i++) {
            int k = picks[i];
            String tool = (i == 0) ? DIA : ((i == 1) ? IRON : STONE);
            while (k-- > 0) {
                toolQueue.add(tool);
            }
        }

        // 앞에서부터 5개씩 분류하여 광물집합 클래스 생성하기
        int index = 0;
        while (toolCount-- > 0 && index < minerals.length) {
            MineralSet mineralSet = new MineralSet();

            int limit = (index + 5 >= minerals.length) ? minerals.length : index + 5;
            for (int i = index; i < limit; i++) {
                if (minerals[i].equals(DIA)) mineralSet.diaCount++;
                else if (minerals[i].equals(IRON)) mineralSet.ironCount++;
                else if (minerals[i].equals(STONE)) mineralSet.stoneCount++;
            }

            index = index + 5;
            mineralQueue.add(mineralSet);// 우선순위 큐에 광물집합 클래스 넣기
        }


        // 가장 성능 좋은 곡갱이로 가장 피로도가 높은 광물집합을 캐야 한다.
        while (!toolQueue.isEmpty() && !mineralQueue.isEmpty()) {

            String tool = toolQueue.poll(); // 곡갱이 꺼내기
            MineralSet mineralSet = mineralQueue.poll();// 광물 꺼내기

            answer += mineralSet.getFatigue(tool); // 피로도 계산
        }

        return answer;
    }

    public class MineralSet {

        private static final int DIA_FATIGUE = 25;
        private static final int IRON_FATIGUE = 5;
        private static final int STONE_FATIGUE = 1;

        public int diaCount;
        public int ironCount;
        public int stoneCount;

        public int getTotalFatigue() {
            return (DIA_FATIGUE * diaCount + IRON_FATIGUE * ironCount + STONE_FATIGUE * stoneCount);
        }

        // 광물집합의 피로도는 돌곡갱이로 다이아,철,돌을 캘때 발생하는 피로도를 기준으로한다.
        public int getFatigue(String tool) {
            switch (tool) {
                case DIA:
                    return (diaCount * 1 + ironCount * 1 + stoneCount * 1);
                case IRON:
                    return (diaCount * 5 + ironCount * 1 + stoneCount * 1);
                case STONE:
                    return (diaCount * 25 + ironCount * 5 + stoneCount * 1);
                default:
                    return -1;
            }
        }

    }
}