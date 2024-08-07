package level01;

public class Programmers258712 {
    public static void main(String[] args) {

        // 예제 1
        String[] friends = {"muzi", "ryan", "frodo", "neo"};
        String[] gifts = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};

        // 예제 2
//        String[] friends = {"joy", "brad", "alessandro", "conan", "david"};
//        String[] gifts = {"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"};

        // res: 4
        System.out.println(new Programmers258712().solution(friends, gifts));

    }

    public int solution(String[] friends, String[] gifts) {
        int answer = 0;

        int[][] matrix = this.getMatrix(friends, gifts);

//        this.printMatrix(matrix);

        int[] nextMonthGiftsReceiveCount = this.getNextMonthGiftsReceiveCount(matrix);
//        this.printArray(nextMonthGiftsReceiveCount);

        answer = nextMonthGiftsReceiveCount[0];

        // 가장 많이 받는 선물의 개수 확인
        for (int score : nextMonthGiftsReceiveCount) {
            if (score > answer) {
                answer = score;
            }
        }

        return answer;
    }

    public void printArray(int[] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // 다음달에 인원별 선물을 받을 개수를 배열에 저장하고 반환하는 메소드
    public int[] getNextMonthGiftsReceiveCount(int[][] matrix) {
        int[] nextMonthGiftsCount = new int[matrix.length];

        for (int giver = 0; giver < matrix.length; giver++) {
            for (int receiver = 0; receiver < matrix[giver].length; receiver++) {
                // 자기 자신일 경우는 넘어간다.
                if (giver == receiver) {
                    continue;
                }

                int giftsGivenCount = matrix[giver][receiver];
                int giftsReceiveCount = matrix[receiver][giver];

                if (giftsGivenCount > giftsReceiveCount) {
                    nextMonthGiftsCount[giver]++;
//                    System.out.println(receiver + " -> " + giver);
//                    System.out.println("Giver: " + giver + ", Receiver: " + receiver + ", nextMonthGiftsCount[giver]: " + nextMonthGiftsCount[giver] + "\n");
                } else if (giftsGivenCount < giftsReceiveCount) {
                    continue;
                } else if (giftsGivenCount == giftsReceiveCount) {
//                    System.out.println(giver + "와 개수 동일 " + receiver + " 선물한 개수가 동일");
                    // giver와 receiver의 선물 포인트를 계산
                    int giverGiftPoint = getGiftPoint(matrix, giver);
                    int receiverGiftPoint = getGiftPoint(matrix, receiver);

//                    System.out.println(giver + ": giverGiftPoint: " + giverGiftPoint + "\n" + receiver + ": receiverGiftPoint: " + receiverGiftPoint);
//                    System.out.println();

                    // 포인트 비교
                    if (giverGiftPoint > receiverGiftPoint) {
                        // giver의 포인트가 더 높으면 다음 달 선물 카운트를 증가
                        nextMonthGiftsCount[giver]++;
//                        System.out.println("Giver: " + giver + ", Receiver: " + receiver + ", nextMonthGiftsCount[giver]: " + nextMonthGiftsCount[giver]);
                    } else if (giverGiftPoint < receiverGiftPoint) {
                        // receiver의 포인트가 더 높으면 다음 달 선물 카운트를 증가
//                        nextMonthGiftsCount[receiver]++;
//                        System.out.println("Giver: " + giver + ", Receiver: " + receiver + ", nextMonthGiftsCount[receiver]: " + nextMonthGiftsCount[receiver]);
                    }
                }

            }
        }

        return nextMonthGiftsCount;
    }

    private int getGiftPoint(int[][] matrix, int personIndex) {
        int giftsGivenScore = 0;
        int giftsReceivedScore = 0;

        for (int i = 0; i < matrix[personIndex].length; i++) {
            giftsGivenScore += matrix[personIndex][i];
        }

        for (int i = 0; i < matrix.length; i++) {
            giftsReceivedScore += matrix[i][personIndex];
        }

        return giftsGivenScore - giftsReceivedScore;
    }

    // 선물결과를 2차원 배열로 반환하는 메소드
    public int[][] getMatrix(String[] friends, String[] gifts) {
        int[][] matrix = new int[friends.length][friends.length];

        String[] tokens;
        for (int i = 0; i < gifts.length; i++) {
            tokens = gifts[i].split(" ");

            int giverIndex = 0, receiverIndex = 0;
            for (int j = 0; j < friends.length; j++) {
                if (tokens[0].equals(friends[j])) {
                    giverIndex = j;
                }
                if (tokens[1].equals(friends[j])) {
                    receiverIndex = j;
                }
            }

            if (giverIndex != receiverIndex) {
                matrix[giverIndex][receiverIndex]++;
            }
        }

        return matrix;
    }
}
