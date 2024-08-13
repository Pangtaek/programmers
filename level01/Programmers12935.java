package level01;

import java.util.Arrays;

public class Programmers12935 {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1};
        System.out.println(Arrays.toString(new Programmers12935().solution(arr)));
    }

    public int[] solution(int[] arr) {
        if (arr == null || arr.length <= 1)
            return new int[]{-1};
        else {
            int min = Arrays.stream(arr).min().getAsInt();
            return Arrays.stream(arr)
                    .filter(num -> num != min)
                    .toArray();
        }
    }
}

