package level01;

public class Programmers147355 {

    public int solution(String t, String p) {
        int answer = 0;
        int pLength = p.length();
        long pValue = Long.parseLong(p); // p를 미리 long으로 변환하여 비교에 사용

        // t의 모든 부분 문자열을 확인
        for (int i = 0; i <= t.length() - pLength; i++) {
            // t에서 p의 길이만큼의 부분 문자열 추출
            String substring = t.substring(i, i + pLength);
            long substringValue = Long.parseLong(substring); // 부분 문자열을 long으로 변환

            // 부분 문자열이 p보다 작거나 같으면 카운트 증가
            if (substringValue <= pValue) {
                answer++;
            }
        }

        return answer;
    }
}
