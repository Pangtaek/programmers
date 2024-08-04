package level01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Programmers12948 {

    public static void main(String[] args) throws IOException{

        System.out.println(new Programmers12948().solution("01033334444"));
    }

    public String solution(String phone_number) throws IOException {
        String answer = "";

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chArr = phone_number.toCharArray();

        for(int i=0; i<chArr.length-4; i++) {
            chArr[i] = '*';
        }

        answer = String.valueOf(chArr);
        return answer;
    }
}
