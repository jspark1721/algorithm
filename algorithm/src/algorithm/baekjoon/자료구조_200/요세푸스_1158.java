package algorithm.baekjoon.자료구조_200;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 요세푸스_1158 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
            int size = Integer.parseInt(tokenizer.nextToken());
            int term = Integer.parseInt(tokenizer.nextToken());
            StringBuilder sb = new StringBuilder("<");
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 1; i < size + 1; i++) {
                list.add(i);
            }
            int idx = 0;
            while (list.size() > 1) {
                idx = (idx + term - 1) % list.size();
                sb.append(list.get(idx) + ", ");
                list.remove(idx);
            }
            System.out.println(sb.append(list.get(0) + ">"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
