package level02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* 문제: 귤 고르기
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/138476
 * 설명: 크기별 개수를 맵에 저장한 후, 개수별 내림차순으로 정렬한다. 이후 제일 많은 것부터 박스에 넣고 개수를 카운트한 후 개수를 만족하면 반환한다.
 * 문제는 어렵지 않지만, 문제를 이해하는데 시간이 많이 들었다.
 * */

public class Programmers138476 {

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 2, 2, 2, 3};

        System.out.println(new Programmers138476().solution(2, arr));
    }

    public int solution(int k, int[] tangerine) {
        int answer = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int one : tangerine) {
            map.put(one, map.getOrDefault(one, 0) + 1);
        }

        // 크기별 리스트 생성
        List<Integer> keyList = new ArrayList<>(map.keySet());
        // map 을 활용하여 크기별 개수로 내림차순 정렬
        keyList.sort((o1, o2) -> map.get(o2) - map.get(o1));


        // k가 0이하이면 더이상 필요 없음
        for (Integer i : keyList) {
            if (k <= 0) {
                break;
            }
            answer++;
            k -= map.get(i);
        }

        return answer;
    }
}
