package level03;

/*
 * 문제: 섬 연결하기
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42861
 * 해결방법: 그리디 알고리즘
 * */

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Programmers42861 {
    class Point implements Comparable<Point> {
        int node;
        int cost;

        public Point(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Point o) {
            return this.cost - o.cost;
        }
    }

    public List<List<Point>> map = new ArrayList<>();

    class Solution {
        public int solution(int n, int[][] costs) { // n: 섬의 수  costs: from, to, cost
            int answer = 0;

            for (int i = 0; i < n; i++) {
                map.add(new ArrayList<>());
            }

            for (int i = 0; i < costs.length; i++) {
                int from = costs[i][0];
                int to = costs[i][1];
                int cost = costs[i][2];

                map.get(from).add(new Point(to, cost));
                map.get(to).add(new Point(from, cost));
            }

            boolean[] visited = new boolean[n];
            PriorityQueue<Point> queue = new PriorityQueue<>();
            queue.add(new Point(0, 0));

            while (!queue.isEmpty()) {
                Point curr = queue.poll();

                if (visited[curr.node]) continue;

                visited[curr.node] = true;
                answer += curr.cost;

                for (Point neighbor : map.get(curr.node)) {
                    if (!visited[neighbor.node]) {
                        queue.add(neighbor);
                    }
                }
            }

            return answer;
        }
    }
}