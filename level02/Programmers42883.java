package level02;

import java.util.ArrayList;
import java.util.List;

public class Programmers42883 {

    public static void main(String[] args) {
        System.out.println(new Programmers42883().solution("4177252841", 4));
    }

    public String solution(String number, int k) {
        String answer = "";

        if (number.charAt(0) == '0') {

            return "0";
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < number.length(); i++) {
            list.add(Character.getNumericValue(number.charAt(i)));
        }

        int i = 0;
        while (i < k) {

            int min = list.get(0);
            int elementIndex = 0;
            for (int index = 0; index < list.size(); index++) {


                if (list.get(index) < min) {
                    min = list.get(index);
                    elementIndex = index;
                }


            }
            list.remove(elementIndex);

            i++;
        }

        for (int num : list) {
            answer += num;
        }

        return answer;
    }
}
