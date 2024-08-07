package level01;

public class Programmer12944 {

    public double solution(int[] arr) {
        double answer = 0;

        for(int num : arr){
            answer += num;
        }

        return answer / arr.length;
    }
}
