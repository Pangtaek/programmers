package level02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/* 문제: [PCCP 기출문제] 2번 / 석유 시추
 * 출처: PCCP 기출문제
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/250136
 * 유형: BFS
 * 설명: 단순한 BFS 문제인줄 알았으나, 효율성 테스트에서 모든 석유 시추 위치를 더하여 합을 구하면 시간 초과가 발생한다.
 *      그래서 시추되는 위치에 따른 석유량을 ArrayList에 담아서 ArrayList의 원소의 합을 구하고 이 값들 중 최대 값을 반환하여
 *      문제를 해결하였다.
 * */

public class Programmers250136 {

    public static void main(String[] args) {
        int[][] array = {
                {0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0},
                {1, 1, 0, 0, 0, 1, 1, 0},
                {1, 1, 1, 0, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0, 1, 1}
        };

        System.out.println(new Programmers250136().solution(array));
    }

    public static boolean[][] visited;
    public static Queue<Position2D> queue;
    public static ArrayList<Integer>[] lists;
    public static int[] dirX = {-1, 1, 0, 0};
    public static int[] dirY = {0, 0, -1, 1};

    public int solution(int[][] land) {
        int answer = 0;

        visited = new boolean[land.length][land[0].length];
        lists = new ArrayList[land[0].length];

        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }
        queue = new LinkedList<>();

        for (int j = 0; j < land[0].length; j++) {
            for (int i = 0; i < land.length; i++) {
                if (!visited[i][j] && (land[i][j] == 1)) {
                    bfs(land, i, j);
                }
            }

        }

        for (ArrayList<Integer> list : lists) {
            int sum = 0;
            for (int i = 0; i < list.size(); i++) {
                sum += list.get(i);
            }

            answer = Math.max(answer, sum);
        }

        return answer;
    }

    public static void bfs(int[][] land, int x, int y) {
        int count = 1;
        int range = y;

        visited[x][y] = true;
        queue.offer(new Position2D(x, y));

        while (!queue.isEmpty()) {
            Position2D currentPosition2D = queue.poll();

            for (int i = 0; i < 4; i++) {
                int newX = currentPosition2D.x + dirX[i];
                int newY = currentPosition2D.y + dirY[i];

                if (isInBound(land, newX, newY)
                        && !visited[newX][newY]
                        && land[newX][newY] == 1
                ) {
                    range = Math.max(range, newY);
                    count++;
                    visited[newX][newY] = true;
                    queue.offer(new Position2D(newX, newY));
                }
            }
        }

        for (int i = y; i <= range; i++) {
            lists[i].add(count);
        }
    }

    public static boolean isInBound(int[][] land, int x, int y) {
        return x >= 0 && x < land.length && y >= 0 && y < land[0].length;
    }

    public static class Position2D {

        public int x;
        public int y;

        public Position2D(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
