package level01;

public class Programmers12912 {
    public static void main(String[] args) {
        System.out.println(new Programmers12912().solution(3, 5));
    }

    public long solution(int a, int b) {
        long answer = 0;

        if(a > b) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        for(int i = a; i <= b; i++) {
            answer += i;
        }

        return answer;
    }
}
