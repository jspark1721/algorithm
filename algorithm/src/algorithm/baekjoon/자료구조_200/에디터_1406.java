package algorithm.baekjoon.자료구조_200;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class 에디터_1406 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String str = br.readLine();

            LinkedList<Character> list = new LinkedList<>();
            for (int i = 0; i < str.length(); i++) {
                list.add(str.charAt(i));
            }
            ListIterator<Character> iterator = list.listIterator();
            while (iterator.hasNext()) {
                iterator.next();
            }
            int size = Integer.parseInt(br.readLine());
            for (int i = 0; i < size; i++) {
                StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
                String command = tokenizer.nextToken();
                if (command.equals("L")) {
                    if (iterator.hasPrevious()) {
                        iterator.previous();
                    }
                } else if (command.equals("D")) {
                    if (iterator.hasNext()) {
                        iterator.next();
                    }
                } else if (command.equals("B")) {
                    if (iterator.hasPrevious()) {
                        iterator.previous();
                        iterator.remove();
                    }
                } else {
                    String word = tokenizer.nextToken();
                    iterator.add(word.charAt(0));
                }
            }
            StringBuilder sb = new StringBuilder();
            for (Character c : list) {
                sb.append(c);
            }
//            bw.flush();
//            bw.close();
            System.out.println(sb);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
