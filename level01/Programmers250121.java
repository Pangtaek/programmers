package level01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Programmers250121 {
    public static void main(String[] args) {

        int[][] data = {
                {1, 20300104, 100, 80},
                {2, 20300804, 847, 37},
                {3, 20300401, 10, 8},};

        data = new Programmers250121().solution(data, "date", 20300501, "remain");
        for(int[] row : data){
            System.out.println(Arrays.toString(row));
        }
    }


    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};

        int j = switch (ext){
            case "code" -> 0;
            case "date" -> 1;
            case "maximum" -> 2;
            case "remain" -> 3;
            default -> -1;
        };

        ArrayList<int[]> filteredList = new ArrayList<>();
        if(!(j == -1)){
            for (int[] row : data) {
                if (row[j] < val_ext) {
                    filteredList.add(row);
                }
            }
        }


        // ArrayList를 배열로 변환합니다.
        answer = filteredList.toArray(new int[filteredList.size()][]);

        // `sort_by`에 따라 정렬합니다.
        int sortIndex = switch (sort_by) {
            case "code" -> 0;
            case "date" -> 1;
            case "maximum" -> 2;
            case "remain" -> 3;
            default -> throw new IllegalArgumentException("Unexpected value: " + sort_by);
        };

        Arrays.sort(answer, Comparator.comparingInt(row -> row[sortIndex]));

        return answer;
    }
}