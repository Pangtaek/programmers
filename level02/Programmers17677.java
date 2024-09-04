package level02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 문제: [1차] 뉴스 클러스터링
 * 출처: 2018 KAKAO BLIND RECRUITMENT
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/17677
 * 설명: 정규표현식을 사용하여 문자열을 2글자씩 자를때 알파벳을 제외한 모든 문자를 제거했다.
 *      그 후 문자열을 비교하며 두 배열에 공통인 것은 교집합 배열에 추가하고 다른것은 합집합 배열에 추가하여 해결
 * 참고: https://minhamina.tistory.com/108 */

public class Programmers17677 {

    public int solution(String str1, String str2) {
        int answer = 0;

        // 소문자로 변환
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();

        ArrayList<String> intersection = new ArrayList<>();
        ArrayList<String> union = new ArrayList<>();

        // 정규 표현식 패턴 정의
        Pattern pattern = Pattern.compile("[^a-z]");

        for (int i = 0; i < str1.length() - 1; i++) {
            String str = str1.substring(i, i + 2);
            Matcher matcher = pattern.matcher(str);
            if (!matcher.find()) {
                list1.add(str);
            }
        }

        for (int i = 0; i < str2.length() - 1; i++) {
            String str = str2.substring(i, i + 2);
            Matcher matcher = pattern.matcher(str);
            if (!matcher.find()) {
                list2.add(str);
            }
        }

        // 중복 원소 처리를 위해 두 집합 정렬
        Collections.sort(list1);
        Collections.sort(list2);

        // 교집합 구하기
        for (String s : list1) {
            if (list2.remove(s)) { // 집합1에 집합2가 포함된다면 삭제후, 교집합에 추가
                intersection.add(s);
            }
            union.add(s);
        }

        // 합집합 구하기
        for (String s : list2) { // 교집합에서 제외된 것 뺀 나머지 합집합에 추가
            union.add(s);
        }

        // 자카드 유사도 구하기
        double a = intersection.size();
        double b = union.size();

        double jakard = 0;

        if (union.size() == 0)
            jakard = 1;    // 공집합일 경우 1
        else
            jakard = (double) intersection.size() / (double) union.size();

        return (int) (jakard * 65536);
    }
}
