package level01;

public class Programmers250125 {
    public static void main(String[] args) {
        String[][] arr = {
                {"blue", "red", "orange", "red"},
                {"red", "red", "blue", "orange"},
                {"blue", "orange", "red", "red"},
                {"orange", "orange", "red", "blue"}};

        Programmers250125 app = new Programmers250125();

        System.out.println(app.solution(arr, 1, 1));
    }

    public int solution(String[][] board, int h, int w) {
        int answer = 0;

        if (h - 1 >= 0) {
            if (board[h][w].equals(board[h - 1][w])) {
                answer++;
            }
        }

        if (w - 1 >= 0) {
            if (board[h][w].equals(board[h][w - 1])) {
                answer++;
            }
        }

        if (w + 1 < board[0].length) {
            if (board[h][w].equals(board[h][w + 1])) {
                answer++;
            }
        }

        if (h + 1 < board.length) {
            if (board[h][w].equals(board[h + 1][w])) {
                answer++;
            }
        }

        return answer;
    }
}

