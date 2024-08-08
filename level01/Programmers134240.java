package level01;

public class Programmers134240 {

    public StringBuilder solution(int[] food) {
        StringBuilder answer = new StringBuilder();

        for (int i = 1; i < food.length; i++) {
            int count = food[i] / 2;
            for (int j = 0; j < count; j++) {
                answer.append(i);
            }
        }

        StringBuilder reverse = new StringBuilder(answer).reverse();
        answer.append(0).append(reverse);

        return answer;
    }
}
