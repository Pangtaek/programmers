package level01;

public class Programmers12901 {
    public static void main(String[] args) {
        System.out.println(new Programmers12901().solution(5, 24));
//        System.out.println(new Programmers12901().solution(1, 7));
    }

    public String solution(int a, int b) {
        String answer = "";
        int[] daysOfMonth = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] dayOfTheWeek = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int totalDays = -1;

        if (a == 1) {
            totalDays += b;
        } else {
            for (int i = 0; i < a - 1; i++) {
                totalDays += daysOfMonth[i];
            }
            totalDays += b;
        }

        answer = dayOfTheWeek[totalDays % 7];

        return answer;
    }
}
