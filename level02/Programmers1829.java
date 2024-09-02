package level02;

/* 문제: 카카오프렌즈 컬러링북
 * 출처: 2017 카카오코드 예선
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/1829
 * 유형: BFS
 * 풀이: 간단한 BFS 문제
 * */

import java.util.LinkedList;
import java.util.Queue;

public class Programmers1829 {

    public static boolean[][] visited;
    public int[] dirX = {-1, 1, 0, 0}; // 상하좌우 방향
    public int[] dirY = {0, 0, -1, 1};
    public Queue<Position2D> queue = new LinkedList<>();

    public int[] solution(int m, int n, int[][] picture) {
        visited = new boolean[m][n];
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        int[] answer = new int[2];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && picture[i][j] != 0) {
                    int currentAreaSize = bfs(picture, i, j); // 현재 영역의 크기
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, currentAreaSize);
                }
            }
        }

        answer[0] = numberOfArea;       // 영역의 개수
        answer[1] = maxSizeOfOneArea;   // 최대 영역의 넓이

        return answer;
    }

    public int bfs(int[][] picture, int startX, int startY) {
        visited[startX][startY] = true;
        queue.offer(new Position2D(startX, startY));
        int areaSize = 1; // 현재 영역의 크기

        while (!queue.isEmpty()) {
            Position2D current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dirX[i];
                int ny = current.y + dirY[i];

                if (isInBounds(picture, nx, ny) && !visited[nx][ny] && picture[nx][ny] == picture[startX][startY]) {
                    visited[nx][ny] = true;
                    areaSize++; // 영역 크기 증가
                    queue.offer(new Position2D(nx, ny));
                }
            }
        }

        return areaSize; // 현재 영역의 크기 반환
    }

    public boolean isInBounds(int[][] picture, int x, int y) {
        return x >= 0 && x < picture.length && y >= 0 && y < picture[0].length;
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