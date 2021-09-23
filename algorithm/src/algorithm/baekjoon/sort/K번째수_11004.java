package algorithm.baekjoon.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class K번째수_11004 {

    public static int[] arr;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
            String[] s = br.readLine().split(" ");
            int size = Integer.parseInt(s[0]);
            int idx = Integer.parseInt(s[1]);
            arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            arr = mergeSort(arr);
            System.out.println(arr[idx - 1]);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static int[] mergeSort(int[] array) {
        if (array.length < 2) {
            return array;
        }
        int mid = array.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(array, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(array, mid, array.length));

        return merge(left, right);

    }

    public static int[] merge(int[] left, int[] right) {
        int lp = 0;
        int rp = 0;
        int[] mergeArr = new int[left.length + right.length];
        for (int i = 0; i < mergeArr.length; i++) {
            if (lp >= left.length) {
                mergeArr[i] = right[rp++];
            } else if (rp >= right.length) {
                mergeArr[i] = left[lp++];
            } else if (left[lp] > right[rp]) {
                mergeArr[i] = right[rp++];
            } else {
                mergeArr[i] = left[lp++];
            }
        }
        return mergeArr;
    }

}
