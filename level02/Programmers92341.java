package level02;

import java.time.Duration;
import java.time.LocalTime;
import java.util.*;

/*
* 문제: 주차 요금 계산
* 출제: 2022 KAKAO BLIND RECRUITMENT
* 풀이: java.time 라이브러리를 사용하여 시간을 표현한다면, 쉽게 풀 수 있다.
* */

public class Programmers92341 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(
                new int[]{
                        180,
                        5000,
                        10,
                        600
                }, new String[]{
                        "05:34 5961 IN",
                        "06:00 0000 IN",
                        "06:34 0000 OUT",
                        "07:59 5961 OUT",
                        "07:59 0148 IN",
                        "18:59 0000 IN",
                        "19:09 0148 OUT",
                        "22:59 5961 IN",
                        "23:00 5961 OUT"
                })));
    }

    public static int defaultTime;      // 기본 시간
    public static int defaultFee;       // 기본 요금
    public static int unitTime;         // 단위 시간
    public static int unitFee;          // 단위 요금

    public static Map<Integer, Integer> map = new HashMap<>(); // 차량 번호와 주차 시간 저장

    public static int[] solution(int[] fees, String[] records) {

        defaultTime = fees[0];
        defaultFee = fees[1];
        unitTime = fees[2];
        unitFee = fees[3];

        List<ParkingArea> list = new ArrayList<>();

        for (String record : records) {
            String[] tokens = record.split(" ");
            int carNumber = Integer.parseInt(tokens[1]);
            // IN
            if (tokens[2].equals("IN")) {
                ParkingArea pa = new ParkingArea(carNumber, tokens[0]);
                list.add(pa);
            }
            // OUT
            else {
                for (ParkingArea pa : list) {
                    if (pa.getCarNumber() == carNumber && pa.getEndTime() == null) {
                        pa.setEndTime(tokens[0]);
                        break;
                    }
                }
            }
        }

        for (ParkingArea pa : list) {
            if (pa.getEndTime() == null) {
                pa.setEndTime("23:59");
            }
            int totalMinutes = minDiff(pa.getStartTime(), pa.getEndTime());
            map.put(pa.getCarNumber(), map.getOrDefault(pa.getCarNumber(), 0) + totalMinutes);
        }

        return calculateFees();
    }

    public static int[] calculateFees() {
        int[] answer = new int[map.size()];
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys); // 차량 번호 오름차순 정렬

        for (int i = 0; i < keys.size(); i++) {
            int totalMinutes = map.get(keys.get(i));

            if (totalMinutes <= defaultTime) {
                answer[i] = defaultFee;
            } else {
                int overTime = totalMinutes - defaultTime;
                int additionalFees = ((int) Math.ceil((double) overTime / unitTime));
                answer[i] = defaultFee + additionalFees * unitFee; // 기본 요금 + 추가 요금
            }
        }

        return answer;
    }

    public static int minDiff(LocalTime start, LocalTime end) {
        Duration diff = Duration.between(start, end);
        return (int) diff.toMinutes(); // 분으로 반환
    }

    public static class ParkingArea {
        private int carNumber;
        private LocalTime startTime;
        private LocalTime endTime;

        public ParkingArea(int carNumber, String startTime) {
            this.carNumber = carNumber;
            String[] tokens = startTime.split(":");
            this.startTime = LocalTime.of(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
            this.endTime = null;
        }

        public int getCarNumber() {
            return carNumber;
        }

        public LocalTime getStartTime() {
            return startTime;
        }

        public LocalTime getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            String[] tokens = endTime.split(":");
            this.endTime = LocalTime.of(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
        }
    }
}