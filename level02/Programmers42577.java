package level02;

import java.util.Arrays;

/* 문제: 전화번호 목록
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42577
 * 풀이: startsWith() 메소드를 알게 되었다. 이 메소드를 사용하면 해당 문자로 시작하는지의 여부를 반환한다. 유사한 메소드로
 * endsWith() 메소드가 있다.*/

public class Programmers42577 {

    public boolean solution(String[] phoneBook) {
        // 1. phoneBook을 sorting한다.
        Arrays.sort(phoneBook);

        // 2. 1중 Loop을 돌며 앞 번호가 뒷 번호의 접두어인지 확인한다.
        for (int i = 0; i < phoneBook.length - 1; i++)
            if (phoneBook[i + 1].startsWith(phoneBook[i]))
                return false;

        // 3. 여기까지 오면 접두어가 없다는 것이다.
        return true;
    }
}

