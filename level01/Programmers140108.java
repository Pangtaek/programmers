package level01;

public class Programmers140108 {
    public static void main(String[] args) {
        System.out.println("result: " + new Programmers140108().solution("abracadabra"));
    }

    /*
     * https://school.programmers.co.kr/learn/courses/30/lessons/140108
     */

    public int solution(String s) {
        int answer = 0;

        char[] arr = s.toCharArray();
        char ch1 = arr[0];
        int cnt1 = 1;
        int cnt2 = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == ch1) {
                cnt1++;
            } else {
                cnt2++;
            }

            if (cnt1 == cnt2) {
                answer++;
                if (i + 1 < arr.length) {
                    ch1 = arr[++i];
                    cnt1 = 1;
                    cnt2 = 0;
                }
            }
        }

        // 남아있는 부분이 있다면 추가로 하나의 구간으로 간주
        if (cnt1 != cnt2) {
            answer++;
        }

        return answer;
    }
}
