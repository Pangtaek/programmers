package level01;

public class Programmers17682 {
    public static void main(String[] args) {
        System.out.println(new Programmers17682().solution("1D2S3T*"));
    }

    /* 결과: 59 */

    public int solution(String dartResult) {
        int[] scores = new int[3]; // 최대 3개의 점수가 나올 수 있음
        char[] chars = dartResult.toCharArray();
        int scoreIndex = -1;
        int i = 0;

        while (i < chars.length) {
            int score = 0;
            // 숫자 처리
            if (Character.isDigit(chars[i])) {
                if (i + 1 < chars.length && chars[i] == '1' && chars[i + 1] == '0') {
                    score = 10;
                    i++;
                } else {
                    score = Character.getNumericValue(chars[i]);
                }
                scoreIndex++;
                i++;
            }

            // 보너스 처리
            if (i < chars.length && (chars[i] == 'S' || chars[i] == 'D' || chars[i] == 'T')) {
                score = switch (chars[i]) {
                    case 'S' -> (int) Math.pow(score, 1);
                    case 'D' -> (int) Math.pow(score, 2);
                    case 'T' -> (int) Math.pow(score, 3);
                    default -> score;
                };
                scores[scoreIndex] = score;
                i++;
            }

            // 옵션 처리
            if (i < chars.length && (chars[i] == '*' || chars[i] == '#')) {
                if (chars[i] == '*') {
                    scores[scoreIndex] *= 2;
                    if (scoreIndex > 0) {
                        scores[scoreIndex - 1] *= 2;
                    }
                } else if (chars[i] == '#') {
                    scores[scoreIndex] *= -1;
                }
                i++;
            }
        }

        int answer = 0;
        for (int s : scores) {
            answer += s;
        }
        return answer;
    }
}
