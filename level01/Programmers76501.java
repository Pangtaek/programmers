package level01;

public class Programmers76501 {
    public static void main(String[] args) {

    }

    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for (int i = 0; i < absolutes.length; i++) {
            int num = Math.abs(absolutes[i]);
            if (signs[i] == true) {
                answer += num;
            } else {
                answer -= num;
            }
        }

        return answer;
    }
}
