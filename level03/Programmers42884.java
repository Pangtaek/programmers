package level03;

import java.util.Arrays;
import java.util.Comparator;

public class Programmers42884 {
    class Solution {
        public int solution(int[][] routes) {
            // 1. 차량의 "출구" 기준으로 정렬
            Arrays.sort(routes, Comparator.comparingInt(route -> route[1]));

            int cameras = 0;  // 설치된 카메라 개수
            int lastCamera = Integer.MIN_VALUE;  // 마지막으로 설치한 카메라 위치

            // 2. 차량을 하나씩 확인하며 카메라 설치
            for (int[] route : routes) {
                int start = route[0];
                int end = route[1];

                // 현재 차량의 진입 지점이 마지막 설치된 카메라 이후라면, 새로운 카메라 설치
                if (start > lastCamera) {
                    cameras++;  // 새로운 카메라 설치
                    lastCamera = end;  // 카메라 위치를 현재 차량의 출구로 설정
                }
            }

            return cameras;
        }
    }
}
