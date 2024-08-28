package level03;

import java.util.Arrays;

public class Programmers43162 {

    public static void main(String[] args) {
        int[][] array = {
                {1, 1, 0},
                {0, 1, 1},
                {0, 1, 1}
        };
        System.out.println(new Programmers43162().solution(3, array)); // 예상 출력: 3
    }

    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int count = 0; // 네트워크 카운트 초기화

        for (int i = 0; i < n; i++) {
            if (!visited[i]) { // 아직 방문하지 않은 경우
                dfs(computers, i, n); // DFS 호출
                count++; // 새로운 네트워크 발견 시 카운트 증가
            }
        }

        return count;
    }

    public static boolean[] visited;

    public static void dfs(int[][] computers, int node, int n) {
        visited[node] = true; // 현재 노드 방문 처리

        for (int i = 0; i < n; i++) {
            if (computers[node][i] == 1 && !visited[i]) { // 연결된 노드 탐색
                dfs(computers, i, n); // 재귀 호출
            }
        }
    }
}
