package level01;

public class Programmers12918 {

    public boolean solution(String s) {

        if (!(s.length() == 4 || s.length() == 6)) {
            return false;
        }

        return s.chars().allMatch(Character::isDigit);
    }
}
