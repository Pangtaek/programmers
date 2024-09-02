package level02;

/* 문제: 피로도
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/87946
 * 유형: 완전탐색
 * 풀이: */

public class Programmers87946 {

    public static void main(String[] args) {

        int currentFatigue = 80;      // 현재 피로도

        int[][] dungeons = {
                {80, 20},
                {50, 40},
                {30, 10}
        };

        System.out.println(new Programmers87946().solution(currentFatigue, dungeons));
    }

    public int solution(int k, int[][] dungeons) {
        int answer = 0;
        visited = new boolean[dungeons.length];


        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i]) {
                dfs(dungeons, i, 0, k);
                answer++;
            }
        }


        return answer;
    }

    public static boolean[] visited;

    public static void dfs(int[][] dungeons, int i, int sum, int currentFatigue) {

    }
}
