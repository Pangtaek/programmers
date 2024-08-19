package level02;

import java.util.Arrays;

public class Programmers42746 {
    public static void main(String[] args) {
        int[] numbers = {3, 30, 34, 5, 9};

        System.out.println(new Programmers42746().solution(numbers));
    }

    public String solution(int[] numbers) {
        // 숫자를 문자열로 변환
        String[] strNumbers = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        Arrays.sort(strNumbers, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));


        // 정렬된 문자열 배열을 합친다
        StringBuilder answer = new StringBuilder();
        for (String str : strNumbers) {
            answer.append(str);
        }

        // 만약 결과가 0으로만 이루어져 있다면 "0"을 반환
        if (answer.charAt(0) == '0') {
            return "0";
        }

        return answer.toString();
    }
}
