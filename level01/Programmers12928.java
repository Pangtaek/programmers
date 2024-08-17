package level01;

public class Programmers12928 {
    public static void main(String[] args) {
        System.out.println(new Programmers12928().solution(12));
    }

    public int solution(int n) {
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                answer = answer + i;
            }
        }

        return answer;
    }
}
