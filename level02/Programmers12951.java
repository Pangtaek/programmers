package level02;

/* 문제: JadenCase 문자열 만들기
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12951
 * 후기: 마지막에 공백(" ")을 고려해야한다는 사실을 추후에 알게되었다. 흠...*/
public class Programmers12951 {

    public static void main(String[] args) {
        System.out.println(new Programmers12951().solution("   3people     unFollowed   me     "));
    }

    public String solution(String s) {

        String[] wordArr = s.split(" ");
        char end = s.charAt(s.length() - 1);

        String result = "";
        for (int i = 0; i < wordArr.length; i++) {

            for (int j = 0; j < wordArr[i].length(); j++) {
                char alpha = wordArr[i].charAt(j);

                if (j == 0) {
                    alpha = Character.toUpperCase(alpha);
                } else {
                    alpha = Character.toLowerCase(alpha);
                }

                result += alpha;
            }
            result += " ";
        }

        //마지막에 공백문자가 들어가면 그대로 출력하고 아니면 앞뒤 공백을 제거한 후, 반환
        if (end == ' ') {
            return result;
        }

        return result.trim();
    }
}
