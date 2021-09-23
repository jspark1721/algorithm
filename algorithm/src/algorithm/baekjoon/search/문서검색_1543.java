package algorithm.baekjoon.search;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 문서검색_1543 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String str = br.readLine();
            String word = br.readLine();
            int idx = 0;
            int count = 0;
            while ((idx = str.indexOf(word, idx)) != -1) {
                count++;
                idx += word.length();
            }
            System.out.println(count);
        } catch (Exception e) {

        }
    }

}
