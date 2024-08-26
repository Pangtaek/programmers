package level02;

import java.util.Arrays;

public class Programmers70129 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Programmers70129().solution("01110")));
    }

    public int[] solution(String s) {
        int[] answer = new int[2];
        int cnt1 = 0; // 변환 횟수
        int cnt2 = 0; // 제거된 '0'의 총 개수

        while (!s.equals("1")) {
            cnt1++;
            int originalLen = s.length();
            s = s.replace("0", "");     // 문자열에서 0 제거
            cnt2 += originalLen - s.length();             // 제거된 0의 개수를 count


            s = Integer.toBinaryString(s.length());      // 0이 제거된 s의 길이를 2진수로 변환
        }

        answer[0] = cnt1; // 변환 횟수
        answer[1] = cnt2; // 제거된 '0'의 수
        return answer;
    }


}
