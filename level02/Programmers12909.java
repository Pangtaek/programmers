package level02;

import java.util.Stack;

public class Programmers12909 {
    public static void main(String[] args) {
        System.out.println(new Programmers12909().solution("(())()"));
    }

    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty() ? true : false;
    }
}
