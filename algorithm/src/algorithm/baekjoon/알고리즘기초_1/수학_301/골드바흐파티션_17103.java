package algorithm.baekjoon.알고리즘기초_1.수학_301;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 골드바흐파티션_17103 {

    static boolean[] primes;

    public static int getNextPrime(int max, int min) {
        int primeIdx = -1;
        for (int i = min; i <= max; i++) {
            if (!primes[i]) {
                primeIdx = i;
                break;
            }
        }
        return primeIdx;
    }

    public static int getPrevPrime(int max, int min) {
        int primeIdx = -1;
        for (int i = max; i >= min; i--) {
            if (!primes[i]) {
                primeIdx = i;
                break;
            }
        }
        return primeIdx;
    }

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int size = Integer.parseInt(br.readLine());
            int[] tCase = new int[size];
            int maxNum = 0;
            for (int i = 0; i < size; i++) {
                int num = Integer.parseInt(br.readLine());
                tCase[i] = num;
                maxNum = maxNum < num ? num : maxNum;
            }
            primes = new boolean[maxNum + 1];
            primes[0] = true;
            primes[1] = true;

            for (int i = 2; i * i <= maxNum; i++) {
                if (primes[i]) {
                    continue;
                }
                for (int j = i + i; j <= maxNum; j += i) {
                    primes[j] = true;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int caseNum : tCase) {
                int min = 2;
                int max = caseNum;
                int count = 0;

                while (min <= max) {
                    int total = min + max;
                    if (total == caseNum) {
                        count++;
                        min = getNextPrime(max, min + 1);
                    } else if (total < caseNum) {
                        min = getNextPrime(max, min + 1);
                    } else {
                        max = getPrevPrime(max - 1, min);
                    }
                    if (max == -1 || min == -1) {
                        break;
                    }
                }
                sb.append(count + "\n");
            }
            System.out.println(sb);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
