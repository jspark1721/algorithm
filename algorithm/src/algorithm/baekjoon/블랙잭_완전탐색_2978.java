package algorithm.baekjoon;

import java.util.Scanner;

public class 블랙잭_완전탐색_2978 {

    public static boolean[] visited;
    public static int[] cards;
    public static int gap = Integer.MAX_VALUE;
    public static int retVal = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int total = sc.nextInt();

        cards = new int[size];
        visited = new boolean[size];

        for (int i = 0; i < size; i++) {
            cards[i] = sc.nextInt();
        }
        getCard(0, 0, total);

        System.out.println(retVal);
    }

    public static void getCard(int depth, int sum, int total) {
        if (depth == 3) {
            int diff = total - sum;
            if (diff > -1 && gap > diff) {
                gap = diff;
                retVal = sum;
            }
            return;
        }

        for (int i = 0; i < cards.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                getCard(depth + 1, sum + cards[i], total);
                if (depth != 0) {
                    visited[i] = false;
                }
            }
        }
    }

}
