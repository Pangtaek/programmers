package level01;

import java.util.Stack;

public class Programmers64061 {
    public static void main(String[] args) {
        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}
        };

        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        System.out.println(new Programmers64061().solution(board, moves));
    }

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int move : moves) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][move - 1] != 0) {
                    int doll = board[j][move - 1];
                    board[j][move - 1] = 0;

                    if (!stack.isEmpty() && stack.peek() == doll) {
                        stack.pop();
                        answer += 2; // 두 개의 인형이 터지므로 2를 더합니다.
                    } else {
                        stack.push(doll);
                    }
                    break;
                }
            }
        }

        return answer;
    }
}
