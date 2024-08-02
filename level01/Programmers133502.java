package level01;

import java.util.Stack;

public class Programmers133502 {
    public static void main(String[] args) {
        int[] arr = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        System.out.println(new Programmers133502().solution(arr));
    }

    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < ingredient.length; i++) {
            stack.push(ingredient[i]);

            if (stack.size() >= 4) {
                int size = stack.size();
                if (stack.get(size - 4) == 1 &&
                        stack.get(size - 3) == 2 &&
                        stack.get(size - 2) == 3 &&
                        stack.get(size - 1) == 1) {
                    // 패턴을 찾으면 스택에서 원소 4개를 제거
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    answer++;
                }
            }
        }

        return answer;
    }
}
