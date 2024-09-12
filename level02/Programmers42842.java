package level02;

public class Programmers42842 {

    public static void main(String[] args) {
        System.out.println(new Programmers42842().solution(10, 2));
    }

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        for (int bh = 1; bh <= brown / 2; bh++) {
            int bw = (brown - 2 * bh + 4) / 2;
            int yw = bw - 2;
            int yh = bh - 2;

            if (yellow == (yw * yh) && (brown + yellow) == bh * bw) {
                answer[0] = bh;
                answer[1] = bw;
            }
        }


        return answer;
    }
}
