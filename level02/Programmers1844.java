package level02;

import java.util.LinkedList;
import java.util.Queue;

public class Programmers1844 {
    public static void main(String[] args) {
        int[][] maps1 = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        };

        System.out.println(new Programmers1844().solution(maps1)); // 예상 출력: 11
    }

    private static Queue<Position2D> queue = new LinkedList<>();
    private static int[] dirX = {0, 0, -1, 1};
    private static int[] dirY = {1, -1, 0, 0};

    public int solution(int[][] maps) {
        if (maps.length == 0 || maps[0].length == 0 || maps[0][0] == 0) {
            return -1;
        }

        boolean[][] visit = new boolean[maps.length][maps[0].length];
        visit[0][0] = true;

        return bfs(maps, visit, 0, 0);
    }

    public int bfs(int[][] maps, boolean[][] visit, int x, int y) {
        queue.offer(new Position2D(x, y, 1)); // 거리도 함께 저장

        while (!queue.isEmpty()) {
            Position2D current = queue.poll();

            // 도착점 체크
            if (current.x == maps.length - 1 && current.y == maps[0].length - 1) {
                return current.distance; // 도착 시 거리 반환
            }

            for (int i = 0; i < 4; i++) {
                int newX = current.x + dirX[i];
                int newY = current.y + dirY[i];

                if (checkBound(maps, newX, newY) && maps[newX][newY] == 1 && !visit[newX][newY]) {
                    visit[newX][newY] = true; // 방문 체크
                    queue.offer(new Position2D(newX, newY, current.distance + 1)); // 거리 증가
                }
            }
        }
        return -1; // 도착할 수 없는 경우
    }

    private boolean checkBound(int[][] maps, int x, int y) {
        return x >= 0 && x < maps.length && y >= 0 && y < maps[0].length;
    }

    public static class Position2D {
        int x;
        int y;
        int distance; // 거리 추가

        public Position2D(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance; // 거리 초기화
        }
    }
}
