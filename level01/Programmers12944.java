package level01;

public class Programmers12944 {

    public double solution(int[] arr) {
        double answer = 0;

        for(int num : arr){
            answer += num;
        }

        return answer / arr.length;
    }
}
