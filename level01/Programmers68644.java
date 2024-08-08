package level01;

import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Programmers68644 {
    public static void main(String[] args) {

    }

    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();

        // 두 수의 곱을 집합에 추가
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        // 집합을 리스트로 변환하고 정렬
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        // 리스트를 배열로 변환
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
