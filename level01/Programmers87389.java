package level01;

public class Programmers87389 {
    public static void main(String[] args) {

    }

    public int solution(int n) {
        int answer = 0;

        for(int i=3; i<n;i+=2){
            if(n%i==1){
                return i;
            }
        }

        return answer;
    }
}
