package algorithm.baekjoon.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 베스트셀러_1302 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            Map<String, BestBook> cache = new HashMap<>();
            int size = Integer.parseInt(br.readLine());
            List<BestBook> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                String book = br.readLine();
                BestBook bestBook = cache.get(book);
                if (bestBook == null) {
                    bestBook = new BestBook(book, 0);
                    list.add(bestBook);
                    cache.put(book, bestBook);
                }
                bestBook.count++;
            }

            list.sort(new Comparator<BestBook>() {
                @Override
                public int compare(BestBook o1, BestBook o2) {
                    int retVal = 0;
                    retVal = o2.count - o1.count;
                    if (retVal == 0) {
                        retVal = o1.title.compareTo(o2.title);
                    }
                    return retVal;
                }
            });
            System.out.println(list.get(0).title);
        } catch (Exception e) {

        }
    }

}

class BestBook {

    String title;
    int count;

    BestBook(String title, int count) {
        this.title = title;
        this.count = count;
    }


}