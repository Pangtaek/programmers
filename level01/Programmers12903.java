package level01;

public class Programmers12903 {

    public static void main(String[] args) {
        System.out.println(new Programmers12903().solution("qwer"));
    }

    public String solution(String s) {
        String answer = "";

        char[] carr = s.toCharArray();
        if (carr.length % 2 != 0) {
            answer = carr[carr.length / 2] + "";
        } else {
            answer = Character.toString(carr[carr.length / 2 - 1]) + Character.toString(carr[carr.length / 2]);
        }

        return answer;
    }
}
