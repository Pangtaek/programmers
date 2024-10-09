package level02;

public class Programmers12905 {

    public static void main(String[] args) {
        int[][] board = {
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 0, 1, 0}
        };

        System.out.println(new Programmers12905().solution(board)); // 예상 출력: 9 (3*3)
    }

    public int solution(int[][] board) {
        if (board.length == 0 || board[0].length == 0) return 0;

        int maxSquareSize = 0;
        int rows = board.length;
        int cols = board[0].length;
        int[][] dp = new int[rows][cols];

        // DP 테이블 초기화 및 계산
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1; // 첫 번째 행 또는 열
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    }
                    maxSquareSize = Math.max(maxSquareSize, dp[i][j]); // 최대 정사각형의 변 길이 업데이트
                }
            }
        }

        return maxSquareSize * maxSquareSize; // 최대 정사각형의 면적 반환
    }
}
