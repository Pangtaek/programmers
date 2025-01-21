package level02;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/*
 * 문제: 주차 요금 계산
 * 출제: 2022 KAKAO BLIND RECRUITMENT
 * 풀이: java.time 라이브러리를 사용하여 시간을 표현한다면, 쉽게 풀 수 있다.
 * */

public class Programmers92341 {

    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};  // 기본 시간(분), 기본 요금(원), 단위 시간(분), 단위 요금(원)
        String[] records = {                // 입출력 시간, 차량 번호, 입출력 정보
                "05:34 5961 IN",
                "06:00 0000 IN",
                "06:34 0000 OUT",
                "07:59 5961 OUT",
                "07:59 0148 IN",
                "18:59 0000 IN",
                "19:09 0148 OUT",
                "22:59 5961 IN",
                "23:00 5961 OUT"
        };

        System.out.println(Arrays.toString(solution(fees, records)));
    }

    public static int[] solution(int[] fees, String[] records) {
        HashMap<String, LocalTime> inTimeMap = new HashMap<>();  // 차량 번호, 입차 시간
        TreeMap<String, Integer> totalParkingTime = new TreeMap<>(); // 차량 번호, 총 주차 시간

        for (String record : records) {
            String[] tokens = record.split(" ");
            LocalTime time = LocalTime.parse(tokens[0]);

            // 차량이 주차장에 입차하는 경우
            if (tokens[2].equals("IN")) {
                inTimeMap.put(tokens[1], time);
            } else { // 차량이 주차장에서 출차하는 경우
                LocalTime inTime = inTimeMap.remove(tokens[1]);
                Duration duration = Duration.between(inTime, time);
                totalParkingTime.put(tokens[1], totalParkingTime.getOrDefault(tokens[1], 0) + (int) duration.toMinutes());
            }
        }

        // 출차하지 않은 차량 처리 (23:59에 출차한 것으로 간주)
        LocalTime endOfDay = LocalTime.of(23, 59);
        for (Map.Entry<String, LocalTime> entry : inTimeMap.entrySet()) {
            String carNumber = entry.getKey();
            LocalTime inTime = entry.getValue();
            Duration duration = Duration.between(inTime, endOfDay);
            totalParkingTime.put(carNumber, totalParkingTime.getOrDefault(carNumber, 0) + (int) duration.toMinutes());
        }

        // 요금 계산
        int[] answer = new int[totalParkingTime.size()];
        int index = 0;

        for (String carNumber : totalParkingTime.keySet()) {
            int totalMinutes = totalParkingTime.get(carNumber);
            int fee = fees[1]; // 기본 요금

            if (totalMinutes > fees[0]) { // 기본 시간 초과
                int extraMinutes = totalMinutes - fees[0];
                fee += (int) (Math.ceil((double) extraMinutes / fees[2]) * fees[3]);
            }

            answer[index++] = fee;
        }

        return answer;
    }
}