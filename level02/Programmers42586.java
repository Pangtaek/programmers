package level02;

import java.util.ArrayList;

public class Programmers42586 {
    public static void main(String[] args) {
        int[] progress = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1}; // speeds 배열 수정

        System.out.println(new Programmers42586().solution(progress, speeds));
    }

    /* [95, 90, 99, 99, 80, 99]
     *  [1, 1, 1, 1, 1, 1]
     *  [1, 3, 2]
     */
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        int[] arr = new int[progresses.length]; // 각 프로세스가 끝나는 시간을 저장
        ArrayList<Integer> result = new ArrayList<>();

        // 각 프로세스의 완료 시간을 계산
        for (int i = 0; i < progresses.length; i++) {
            int time = 0; // 걸리는 시간 초기화
            while (progresses[i] + time * speeds[i] < 100) {
                time++;
            }
            arr[i] = time; // 완료 시간 저장
        }

        // 배포 가능한 작업 수 카운트
        int count = 1;
        int x = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (x >= arr[i]) {
                count++;
            } else {
                result.add(count);
                x = arr[i];
                count = 1;
            }
        }
        result.add(count); // 마지막 카운트 추가

        return result;
    }

    public int checkBeforeProgress(int[] arr, int index) {
        // 이전 프로세스보다 걸리는 시간이 짧으면 이전 프로세스의 시간을 기다려야 하기에 이전 프로세스의 시간으로 변경한다.
        if (arr[index - 1] > arr[index]) {
            return arr[index - 1];
        }

        // 아니면 현재 시간을 반환
        return arr[index];
    }
}
