package level01;

public class Programmers82612 {

    public long solution(int price, int money, int count) {
        long result = 0;

        for (int i = 1; i <= count; i++) {
            result += price * i;
        }

        return money > result ? 0 : result - money;
    }
}
