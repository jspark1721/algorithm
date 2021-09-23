package algorithm.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 프린터큐_1966 {

    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
            int size = Integer.parseInt(br.readLine());
            for (int i = 0; i < size; i++) {
                String[] conditions = br.readLine().split(" ");
                int docSize = Integer.parseInt(conditions[0]);
                int idx = Integer.parseInt(conditions[1]);
                String[] docList = br.readLine().split(" ");
                Integer[] arr = new Integer[docSize];
                Queue<int[]> q = new LinkedList<>();
                for (int j = 0; j < docSize; j++) {
                    int prior = Integer.parseInt(docList[j]);
                    arr[j] = prior;
                    q.add(new int[]{j, prior});
                }
                Arrays.sort(arr, Collections.reverseOrder());
                int chkIdx = 0;
                while (!q.isEmpty()) {
                    int[] data = q.poll();
                    if (data[1] >= arr[chkIdx]) {
                        chkIdx++;
                        if (data[0] == idx) {
                            break;
                        }
                    } else {
                        q.add(data);
                    }

                }
                System.out.println(chkIdx);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Scanner sc = new Scanner(System.in);

    }

}
