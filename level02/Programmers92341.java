package level02;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/*
 * 문제: 주차 요금 계산
 * 출제: 2022 KAKAO BLIND RECRUITMENT
 * 풀이: java.time 라이브러리를 사용하여 시간을 표현한다면, 쉽게 풀 수 있다.
 * */

public class Programmers92341 {

    public static void main(String[] args) {
        int[] fees = { 180, 5000, 10, 600 }; // 기본 시간(분), 기본 요금(원), 단위 시간(분), 단위 요금(원)
        String[] records = {
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
        Map<Integer, LocalTime> timeMap = new HashMap<>();
        Map<Integer, Integer> chargeMap = new TreeMap<>(); // 차량번호를 오름차순으로 정렬
        Set<Integer> set = new TreeSet<>(); // 주차장에 남아있는 차량을 저장

        for (String record : records) {
            String[] data = record.split("\\s+");
            LocalTime time = LocalTime.parse(data[0]);
            int carNumber = Integer.parseInt(data[1]);
            String io = data[2];

            if (io.equals("IN")) {
                timeMap.put(carNumber, time);
                set.add(carNumber);
            } else { // OUT
                LocalTime startInclusive = timeMap.get(carNumber);
                Duration duration = Duration.between(startInclusive, time);

                chargeMap.put(carNumber, chargeMap.getOrDefault(carNumber, 0) + (int) duration.toMinutes());
                timeMap.remove(carNumber); // 출차했으므로 시간 기록 삭제
                set.remove(carNumber);
            }
        }

        // 출차 기록이 없는 차량을 23:59에 출차 처리
        for (int carNumber : set) {
            LocalTime startInclusive = timeMap.get(carNumber);
            Duration duration = Duration.between(startInclusive, LocalTime.of(23, 59));

            chargeMap.put(carNumber, chargeMap.getOrDefault(carNumber, 0) + (int) duration.toMinutes());
        }

        List<Integer> answer = new ArrayList<>();

        for (int duration : chargeMap.values()) {
            if (duration <= fees[0]) {
                answer.add(fees[1]); // 기본 시간 이내는 기본 요금
            } else {
                int extraFee = (int) Math.ceil((double) (duration - fees[0]) / fees[2]) * fees[3];
                answer.add(fees[1] + extraFee);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
