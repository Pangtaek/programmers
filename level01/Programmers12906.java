package level01;

import java.util.ArrayList;

public class Programmers12906 {

    public int[] solution(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        int current = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != current) {
                list.add(arr[i]);
                current = arr[i];
            }
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}
