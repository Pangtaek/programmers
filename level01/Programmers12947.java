package level01;

public class Programmers12947 {
    public static void main(String[] args) {
        System.out.println(new Programmers12947().solution(11));
    }

    public boolean solution(int x) {
        boolean answer = false;

        int n = 0;
        while (x > 0) {
            n += x % 10;
            x /= 10;
        }

        if (x % n == 0) {
            return true;
        } else {
            return false;
        }
    }
}
