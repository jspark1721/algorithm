package algorithm.baekjoon.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 수정렬하기3_10989 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 8);) {
            int size = Integer.parseInt(br.readLine());
            int[] arr = new int[10001];
            for (int i = 0; i < size; i++) {
                arr[Integer.parseInt(br.readLine())]++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < 10001; i++) {
                for (int j = 0; j < arr[i]; j++) {
                    sb.append(i).append("\n");
                }

            }
            System.out.print(sb);
        } catch (Exception e) {

        }

    }

}
//public static void main(String[] args) {
//        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 8);) {
//            int size = Integer.parseInt(br.readLine());
//            int[] arr = new int[10001];
//            for (int i = 0; i < size; i++) {
//                arr[Integer.parseInt(br.readLine())]++;
//            }
//            StringBuilder sb = new StringBuilder();
//            for (int i = size-1; i > -1; i--) {
//                for (int j = 0; j < arr[i]; j++) {
//                    sb.append(i).append("\n");
//                }
//
//            }
//            System.out.println(sb);
//        } catch (Exception e) {
//
//        }
//
//    }