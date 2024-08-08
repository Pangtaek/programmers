package level01;

public class Programmers250137 {
    public static void main(String[] args) {
        /* 입력 1*/
        int[] bandage = {5, 1, 5};      // 시전 시간, 초당 회복량, 추가 회복량
        int hp = 30;
        int[][] attacks = {{2, 10}, {9, 15}, {10, 5}, {11, 5}};
        /* 출력: 5*/
        System.out.println(new Programmers250137().solution(bandage, hp, attacks));
    }

    public int solution(int[] bandage, int hp, int[][] attacks) {
        final int MAX_HP = hp;
        int turn = 0;
        int gauge = 0;

        // 공격이 끝날때까지 반복
        while (turn <= attacks[attacks.length - 1][0]) {
            // 이번 턴에 공격당함 여부 확인
            int attackIndex = getAttackIndex(attacks, turn);
            if (attackIndex != -1) { // 공격이 발생한 경우
                hp = calclateHp(hp, attacks[attackIndex][1]);
                gauge = 0;
                // 체력이 0 이하이면 게임 오버
                if (hp <= 0) {
                    return hp;
                }
            } else { // 공격이 발생하지 않은 경우
                hp = bandaging(hp, bandage[1], MAX_HP); // 초당 회복량만큼 체력 회복
                gauge++;
                // 시전 시간 완료
                if (gauge >= bandage[0]) {
                    gauge = 0;
                    hp = bandaging(hp, bandage[2], MAX_HP); // 추가 회복량만큼 체력 회복
                }
            }
            turn++;
        }

        return hp;
    }

    public int bandaging(int hp, int healingPoint, int MAX_HP) {
        hp += healingPoint;
        if (hp > MAX_HP) {
            hp = MAX_HP;
        }
        return hp;
    }

    public int calclateHp(int health, int damage) {
        health -= damage;
        if (health <= 0) {
            health = -1;
        }
        return health;
    }

    public int getAttackIndex(int[][] attacks, int turn) {
        // attacks 배열을 순회하면서 해당 턴에 공격이 있는지 확인
        for (int i = 0; i < attacks.length; i++) {
            if (attacks[i][0] == turn) {
                return i; // 공격이 발생한 인덱스를 반환
            }
        }
        return -1; // 공격이 발생하지 않으면 -1 반환
    }

}
