package level02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Programmers87377 {

    public static void main(String[] args) {
        String[] answer = solution(new int[][]{
                {0, 1, -1},
                {1, 0, -1},
                {1, 0, 1}
        });

        Arrays.stream(answer).forEach(System.out::println);
    }

    public static String[] solution(int[][] line) {
        List<String> answerList = new ArrayList<>();
        List<Position2D> list = new ArrayList<>();

        // 1. 교점을 리스트에 저장
        for (int i = 0; i < line.length - 1; i++) {
            for (int j = i + 1; j < line.length; j++) {
                Position2D newPos = getSpot(line[i][0], line[i][1], line[i][2],
                        line[j][0], line[j][1], line[j][2]);

                if (newPos != null) {
                    list.add(newPos);
                }
            }
        }

        // 2. x, y 최대/최소값 구하기
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;

        for (Position2D pos : list) {
            minX = Math.min(minX, pos.getX());
            maxX = Math.max(maxX, pos.getX());
            minY = Math.min(minY, pos.getY());
            maxY = Math.max(maxY, pos.getY());
        }

        // 가로 길이만큼 "." 찍음
        char[] dash = new char[maxX - minX + 1];
        Arrays.fill(dash, '.');

        // 3. 그림 그리기
        for (int level = maxY; level >= minY; level--) {
            char[] copyDash = dash.clone();
            for (Position2D pos : list) {
                if (pos.getY() == level) {
                    copyDash[pos.getX() - minX] = '*'; // minX를 기준으로 조정
                }
            }
            answerList.add(String.valueOf(copyDash));
        }

        return answerList.toArray(new String[0]);
    }

    // 교점 구하는 메서드
    public static Position2D getSpot(int A, int B, int E, int C, int D, int F) {
        int denominator = A * D - B * C;
        if (denominator == 0) return null; // 교차가 없는 경우

        int x = B * F - E * D;
        int y = E * C - A * F;

        // 정수인지 확인
        if (x % denominator != 0 || y % denominator != 0) {
            return null;
        }

        return new Position2D(x / denominator, y / denominator);
    }

    // 좌표 클래스
    public static class Position2D {
        private final int x;
        private final int y;

        public Position2D(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
