package level01;

public class Programmers12931 {
    public static void main(String[] args) {

    }

    public int solution(int n) {
        int answer = 0;

        while(n > 0){
            answer += n % 10;
            n /= 10;
        }

        return answer;
    }
}
