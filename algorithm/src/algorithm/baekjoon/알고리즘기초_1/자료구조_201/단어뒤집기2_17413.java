package algorithm.baekjoon.알고리즘기초_1.자료구조_201;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 단어뒤집기2_17413 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String str = br.readLine();
            StringBuilder sb = new StringBuilder();
            StringBuilder word = new StringBuilder();
            boolean isTag = false;
            for (char c : str.toCharArray()) {
                if (!isTag && c == ' ') {
                    if (word.length() > 0) {
                        sb.append(word.reverse());
                    }
                    sb.append(c);
                    word = new StringBuilder();
                    continue;
                }

                if (c == '<') {
                    if (word.length() > 0) {
                        sb.append(word.reverse());
                        word = new StringBuilder();
                    }
                    word.append(c);
                    isTag = true;
                } else if (c == '>') {
                    word.append(c);
                    isTag = false;
                    sb.append(word);
                    word = new StringBuilder();
                } else if (isTag) {
                    word.append(c);
                } else {
                    if (c == ' ') {
                        sb.append(word.reverse());
                        word = new StringBuilder();
                        sb.append(c);
                    } else {
                        word.append(c);
                    }
                }
            }
            if (word.length() > 0) {
                sb.append(word.reverse());
            }
            System.out.println(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
