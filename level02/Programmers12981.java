package level02;

import java.util.Arrays;
import java.util.HashSet;

/* 문제: 영어 끝말잇기
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12981
 * */
public class Programmers12981 {
    public static void main(String[] args) {
        int n = 3;
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};

        System.out.println(Arrays.toString(new Programmers12981().solution(n, words)));
    }

    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        HashSet<String> prevWords = new HashSet<>();    // 말한 단어들은 여기에 들어가야됨.

        for (int idx = 0; idx < words.length; idx++) {
            // 첫 번째 단어는 무조건 추가
            if (idx == 0) {
                prevWords.add(words[idx]);
                continue;
            }

            // 규칙 확인
            if (checkRule(words[idx], words[idx - 1])) {
                // 새로운 단어를 말한 경우
                if (checkPrevWord(words[idx], prevWords)) {
                    prevWords.add(words[idx]);
                }
                // 이전에 말했던 단어를 말한 경우
                else {
                    answer[0] = idx % n + 1;        // 몇 번째 사람
                    answer[1] = idx / n + 1;        // 몇 번째 턴
                    return answer;
                }
            }
            // 규칙을 어긴 경우
            else {
                answer[0] = idx % n + 1;            // 몇 번째 사람
                answer[1] = idx / n + 1;            // 몇 번째 턴
                return answer;
            }
        }

        return answer;
    }

    // 규칙을 지킴: true || 어김: false
    public boolean checkRule(String newWord, String prevWord) {
        return prevWord.charAt(prevWord.length() - 1) == newWord.charAt(0);
    }

    // 새로운 단어: true || 이전에 말한 단어: false
    public boolean checkPrevWord(String word, HashSet<String> previousWords) {
        return !previousWords.contains(word);
    }
}
