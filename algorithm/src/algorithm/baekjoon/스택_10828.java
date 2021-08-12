package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 스택_10828 {

    public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int num = Integer.parseInt(br.readLine());
	StackTest stack = new StackTest(num);
	for (int i = 0; i < num; i++) {
	    String comm = br.readLine();
	    stack.comm(comm);
	}
	Map<String, String> tes = new HashMap<>();
	List<String> genres = new ArrayList<>();
	tes.keySet().stream().forEach(item -> {
	    genres.add(item);
	});

	Collections.sort(genres);

	for (int i = 0; i < 2; i++) {

	    for (int j = 0; j < 2; j++) {
//		genres.get(i).get
	    }
	}

	Collection<String> values = tes.values();

    }
}

class StackTest {
    int top;
    int stack[];
    int size;

    public StackTest(int size) {
	top = -1;
	stack = new int[size];
	this.size = size;
    }

    public void comm(String comm) {
	String str = comm.substring(0, 3);
	if (str.equals("pus")) {
	    push(Integer.parseInt(comm.substring(5)));
	} else if (str.equals("pop")) {
	    pop();
	} else if (str.equals("siz")) {
	    size();
	} else if (str.equals("emp")) {
	    empty();
	} else if (str.equals("top")) {
	    top();
	}
    }

    public void push(int num) {
	stack[++top] = num;
    }

    public void pop() {
	if (top == -1) {
	    System.out.println("-1");
	} else {
	    System.out.println(stack[top--]);
	}
    }

    public void size() {
	System.out.println(top + 1);
    }

    public void empty() {
	if (top == -1)
	    System.out.println(1);
	else
	    System.out.println(0);
    }

    public void top() {
	if (top == -1) {
	    System.out.println(-1);
	} else {
	    System.out.println(stack[top]);
	}
    }
}