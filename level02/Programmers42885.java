package level02;

import java.util.Arrays;

/* 문제: 구명보트
 * 유형: 탐욕법
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42885
 * 설명: 문제에 보트에는 최대 2명까지 태울 수 있다고 나와있지만, 최대 인원을 고려하지 않고 코드를 짰다. while 문이 있는 코드는 그것을 보여준다. 최대 2명까지라면 if문 만 사용하여 투포인터로 풀면된다. */
public class Programmers42885 {

    public static void main(String[] args) {
        int[] array = {15, 15, 15, 100};

        System.out.println(new Programmers42885().solution(array, 110));
    }

    public int solution(int[] people, int limit) {
        Arrays.sort(people); // 사람 몸무게 정렬
        int left = 0; // 가장 가벼운 사람
        int right = people.length - 1; // 가장 무거운 사람
        int boats = 0; // 보트 수

        while (left <= right) {
            // 가장 가벼운 사람과 가장 무거운 사람을 함께 태울 수 있는지 확인
            int sum = 0;
            while(people[left] + people[right] + sum <= limit){
                sum += people[left];
                left++;
            }

//            if (people[left] + people[right] <= limit) {
//                left++; // 가벼운 사람을 태움
//            }

            // 무거운 사람은 항상 태움
            right--;
            boats++; // 보트 수 증가
        }

        return boats;
    }
}