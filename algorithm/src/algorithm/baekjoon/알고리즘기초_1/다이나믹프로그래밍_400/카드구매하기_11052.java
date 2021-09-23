package algorithm.baekjoon.알고리즘기초_1.다이나믹프로그래밍_400;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 카드구매하기_11052 {

    public static Card[] cards;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            cards = new Card[N + 1];
            cards[0] = new Card(0, 0);
            String[] infos = br.readLine().split(" ");

            for (int i = 0; i < N; i++) {
                cards[i + 1] = new Card(i + 1, Integer.parseInt(infos[i]));
            }
            if (N > 1) {
                Card card1 = cards[1];
                Card card2 = cards[2];

                if (card1.amount * 2 > card2.amount) {
                    cards[2] = new Card(2, card1.amount * 2);
                }
            }

            for (int i = 3; i < cards.length; i++) {
                int start = 1;
                int end = i - 1;
                int max = cards[i].amount;
                for (int j = 0; j < i / 2; j++) {
                    int amount = cards[start + j].amount + cards[end - j].amount;
                    max = Math.max(max, amount);
                }
                cards[i] = new Card(i, max);
            }
            int count = N;
            int check = N;
            int total = 0;
            while (count > 0) {
                Card card = cards[check++];
                total += (count / card.count) * card.amount;
                count = count % card.count;
            }

            System.out.println(total);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class Card {

        int count;
        int amount;

        public Card(int count, int amount) {
            this.count = count;
            this.amount = amount;
        }


    }

}
