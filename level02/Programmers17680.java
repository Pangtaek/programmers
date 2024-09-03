package level02;

/* 문제: [1차] 캐시
 * 출처: 2018 KAKAO BLIND RECRUITMENT
 * 유형: 캐시
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/17680
 * 설명: Set을 이용하여 문제를 풀려고 했으나 특정 인덱스의 원소를 삭제하는게 불가능하다.
 *      LinkedHashMap을 사용하면 특정 사이즈보다 Map의 크기가 커지면 가장 오래된 순으로 삭제를 하는 기능이 구현되어 있다는 것을
 *      알게 되었다.
 * */

import java.util.LinkedHashMap;
import java.util.Map;

public class Programmers17680 {

    public static void main(String[] args) {
        String[] cities = {
                "Jeju", "Pangyo", "NewYork", "newyork"
        };

        System.out.println(new Programmers17680().solution(2, cities)); // 예상 출력: 16
    }

    public int solution(int cacheSize, String[] cities) {
        // 캐시 사이즈가 0인 경우
        if (cacheSize == 0) {
            return cities.length * 5;
        }

        // LRU 캐시를 위해 LinkedHashMap 사용
        Map<String, Integer> cache = new LinkedHashMap<>(cacheSize, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
                return size() > cacheSize; // 캐시 크기를 초과하면 가장 오래된 항목 제거
            }
        };

        int totalTime = 0;

        for (String city : cities) {
            String normalizedCity = city.toLowerCase(); // 대소문자 구분 없이 처리

            if (cache.containsKey(normalizedCity)) {
                totalTime += 1; // 캐시 히트
            } else {
                totalTime += 5; // 캐시 미스
            }
            cache.put(normalizedCity, 1); // 캐시에 추가 (존재하면 업데이트)
        }

        return totalTime;
    }
}