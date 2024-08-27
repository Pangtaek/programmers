package level01;

import java.util.ArrayList;
import java.util.List;

public class Programmers42840 {

    public static int[] solution(int[] answers) {
        int[] answer = {};

        int[] spj1 = {1,2,3,4,5};
        int[] spj2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] spj3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] score = {0,0,0};

        for(int i=0; i<answers.length; i++){
            if(answers[i] == spj1[i%5]) score[0]++;
            if(answers[i] == spj2[i%8]) score[1]++;
            if(answers[i] == spj3[i%10]) score[2]++;
        }

        List<Integer> answerList = new ArrayList<Integer>();
        int max = Math.max(score[0], Math.max(score[1], score[2]));

        for(int i=0; i<3; i++){
            if(max == score[i]) answerList.add(i+1);
        }
        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
}
