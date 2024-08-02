package level01;

import java.lang.StringBuilder;

public class Programmers67256 {

    public static void main(String[] args) {
        int[] arr = { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 };
        // Keypad 객체를 생성하고 solution 메서드를 호출하여 결과를 출력합니다.
        System.out.println(new Programmers67256().solution(arr, "right"));
    }

    public String solution(int[] numbers, String hand) {
        // 문자열을 효율적으로 생성하기 위해 StringBuilder를 사용합니다.
        StringBuilder answer = new StringBuilder();

        // 초기 왼손 위치는 '*' (keypad의 왼쪽 아래)
        Position leftPos = new Position(3, 0);
        // 초기 오른손 위치는 '#' (keypad의 오른쪽 아래)
        Position rightPos = new Position(3, 2);

        for (int number : numbers) {
            Position numPos;
            // 숫자 0의 위치는 따로 처리합니다.
            if (number == 0) {
                numPos = new Position(3, 1); // '0' 위치
            } else {
                // 숫자의 위치를 계산합니다.
                numPos = new Position((number - 1) / 3, (number - 1) % 3);
            }

            // 숫자가 1, 4, 7인 경우 왼손으로 누릅니다.
            if (number == 1 || number == 4 || number == 7) {
                answer.append("L");
                leftPos = numPos; // 왼손 위치 업데이트
            }
            // 숫자가 3, 6, 9인 경우 오른손으로 누릅니다.
            else if (number == 3 || number == 6 || number == 9) {
                answer.append("R");
                rightPos = numPos; // 오른손 위치 업데이트
            }
            // 나머지 숫자 (2, 5, 8, 0)의 경우
            else {
                int leftDist = leftPos.getDistance(numPos); // 왼손과 목표 위치 간 거리 계산
                int rightDist = rightPos.getDistance(numPos); // 오른손과 목표 위치 간 거리 계산

                // 왼손이 더 가까운 경우
                if (leftDist < rightDist) {
                    answer.append("L");
                    leftPos = numPos; // 왼손 위치 업데이트
                }
                // 오른손이 더 가까운 경우
                else if (leftDist > rightDist) {
                    answer.append("R");
                    rightPos = numPos; // 오른손 위치 업데이트
                }
                // 거리가 같은 경우
                else {
                    // 주 손에 따라 결정합니다.
                    if (hand.equals("left")) {
                        answer.append("L");
                        leftPos = numPos; // 왼손 위치 업데이트
                    } else {
                        answer.append("R");
                        rightPos = numPos; // 오른손 위치 업데이트
                    }
                }
            }
        }

        // 최종 결과를 문자열로 반환합니다.
        return answer.toString();
    }

    class Position {
        int row;
        int col;

        // Position 생성자
        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        // 두 위치 간의 거리를 계산하는 메서드
        public int getDistance(Position newPos) {
            return Math.abs(this.row - newPos.row) + Math.abs(this.col - newPos.col);
        }
    }
}
