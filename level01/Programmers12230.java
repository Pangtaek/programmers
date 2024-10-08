package level01;

public class Programmers12230 {

    public static void main(String[] args) {
        int[][] array = {
                {60, 50},
                {30, 70},
                {60, 30},
                {80, 40}
        };

        System.out.println(new Programmers12230().solution(array));
    }

    public int solution(int[][] sizes) {
        int max_v = 0;
        int max_h = 0;
        for (int i = 0; i < sizes.length; i++) {
            int v = Math.max(sizes[i][0], sizes[i][1]);
            int h = Math.min(sizes[i][0], sizes[i][1]);
            max_v = Math.max(max_v, v);
            max_h = Math.max(max_h, h);
        }
        return max_v * max_h;
    }
}
