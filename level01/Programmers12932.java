package level01;

import java.util.ArrayList;

public class Programmers12932 {
    public int[] solution(long n) {
        ArrayList<Integer> list = new ArrayList<>();

        // n이 0이 아닐 때까지 반복
        while (n > 0) {
            list.add((int) (n % 10)); // 각 자리수를 리스트에 추가
            n = n / 10; // n을 10으로 나눔
        }

        // 리스트를 int 배열로 변환
        return list.stream().mapToInt(i -> i).toArray();
    }

}
