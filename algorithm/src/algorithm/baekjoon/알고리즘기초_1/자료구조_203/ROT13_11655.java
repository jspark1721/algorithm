package algorithm.baekjoon.알고리즘기초_1.자료구조_203;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ROT13_11655 {

    public static void main(String[] args) {
        System.out.println(123 % 122);
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String str = br.readLine();
            for (char c : str.toCharArray()) {
                if (c >= 'a' && c <= 'z') {
                    char word = (char) (c + 13);
                    if (c + 13 > 'z') {
                        word = (char) ((c + 13) % 'z' + 'a' - 1);
                    }
                    sb.append(word);
                } else if (c >= 'A' && c <= 'Z') {
                    char word = (char) (c + 13);
                    if (c + 13 > 'Z') {
                        word = (char) ((c + 13) % 'Z' + 'A' - 1);
                    }
                    sb.append(word);
                } else {
                    sb.append(c);
                }
            }
            System.out.println(sb);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}