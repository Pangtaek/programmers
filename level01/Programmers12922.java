package level01;

public class Programmers12922 {

    public static void main(String[] args) {
        System.out.println(new Programmers12922().solution(4));
    }

    public String solution(int n) {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
           if(i % 2 != 0){
               sb.append("수");
           }else{
               sb.append("박");
           }
        }

        return sb.toString();
    }
}
