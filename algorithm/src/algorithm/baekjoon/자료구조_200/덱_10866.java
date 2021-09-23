package algorithm.baekjoon.자료구조_200;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 덱_10866 {

    public static void main(String[] args) {
        Deque<Integer> dq = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        Integer num;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int size = Integer.parseInt(br.readLine());
            while (size-- > 0) {
                StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
                switch (tokenizer.nextToken()) {
                    case "push_front":
                        dq.addFirst(Integer.parseInt(tokenizer.nextToken()));
                        break;
                    case "push_back":
                        dq.addLast(Integer.parseInt(tokenizer.nextToken()));
                        break;
                    case "pop_front":
                        num = dq.pollFirst();
                        num = num != null ? num : -1;
                        sb.append(num + "\n");
                        break;
                    case "pop_back":
                        num = dq.pollLast();
                        num = num != null ? num : -1;
                        sb.append(num + "\n");
                        break;
                    case "size":
                        sb.append(dq.size() + "\n");
                        break;
                    case "empty":
                        sb.append(dq.isEmpty() ? 1 : 0);
                        sb.append("\n");
                        break;
                    case "front":
                        sb.append(dq.peekFirst() != null ? dq.peekFirst() : -1);
                        sb.append("\n");
                        break;
                    case "back":
                        sb.append(dq.peekFirst() != null ? dq.peekLast() : -1);
                        sb.append("\n");
                        break;
                }
            }
            System.out.println(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
