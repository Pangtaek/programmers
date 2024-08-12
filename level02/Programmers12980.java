package level02;

public class Programmers12980 {
    public static void main(String[] args) {
        System.out.println(new Programmers12980().solution(6));
    }

    public int solution(int n) {
        int ans = 0;

        while (n > 0) {
            // 짝수
            if (n % 2 == 0) {
                n /= 2;
            }
            // 홀수
            else {
                ans++;
                n--;
            }
        }

        return ans;
    }
}
