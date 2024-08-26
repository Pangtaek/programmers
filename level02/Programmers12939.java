package level02;

import java.util.StringTokenizer;

public class Programmers12939 {

    public static void main(String[] args) {
        System.out.println(new Programmers12939().solution(	"-1 -2 -3 -4"));
    }

    public String solution(String s) {
        String answer = "";

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        StringTokenizer st = new StringTokenizer(s);

        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            min = Math.min(num, min);
            max = Math.max(num, max);
        }

        answer = String.valueOf(min) + " " + String.valueOf(max);

        return answer;
    }
}
