package level01;

public class Programmers12954 {
    public static void main(String[] args) {

    }

    public long[] solution(int x, int n) {
        long[] answer = new long[n];

        for(int i =0; i < n; i++) {
            answer[i] = x * ((long)i + 1);
        }
        return answer;
    }
}
