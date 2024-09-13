package level01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Programmers12969 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String input = br.readLine();
            String[] tokens = input.split(" ");
            int a = Integer.parseInt(tokens[0]);
            int b = Integer.parseInt(tokens[1]);

            for(int i=0; i<b; i++){
                for(int j=0; j<a; j++){
                    System.out.print("*");
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("유근웅");
        }
    }
}
