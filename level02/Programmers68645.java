package level02;

public class Programmers68645 {
    public static void main(String[] args) {
    }

    public int[] solution(int n) {
        int max = n * (n + 1) / 2; //등비수열합
        int[][] arr = new int[n][n];
        int[] answer = new int[max];

        // 시작 지점
        int x = -1, y = 0;
        int num = 1;

        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                if (i % 3 == 0) {
                    ++x; // 세로
                } else if (i % 3 == 1) {
                    ++y; // 가로
                } else if (i % 3 == 2) {
                    // 대각선
                    --x;
                    --y;
                }
                arr[x][y] = num++;
            }
        }

        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <= i; j++) {
                answer[idx] = arr[i][j];
                idx++;
            }
        }

        return answer;
    }
}

