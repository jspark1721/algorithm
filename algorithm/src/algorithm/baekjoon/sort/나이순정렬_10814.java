package algorithm.baekjoon.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class 나이순정렬_10814 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
            int size = Integer.parseInt(br.readLine());
            CustomerJudge[] list = new CustomerJudge[size];
            for (int i = 0; i < size; i++) {
                String[] info = br.readLine().split(" ");
                list[i] = new CustomerJudge(Integer.parseInt(info[0]), info[1], i);
            }
            Arrays.sort(list, new Comparator<CustomerJudge>() {
                @Override
                public int compare(CustomerJudge o1, CustomerJudge o2) {
                    int retVal = o1.age - o2.age;
                    if (retVal == 0) {
                        retVal = o1.idx - o2.idx;
                    }
                    return retVal;
                }
            });
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.length; i++) {
                sb.append(list[i].age + " " + list[i].name).append("\n");
            }
            System.out.println(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

class CustomerJudge {

    int age;
    String name;
    int idx;

    CustomerJudge(int age, String name, int idx) {
        this.age = age;
        this.name = name;
        this.idx = idx;
    }

}
