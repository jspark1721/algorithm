package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 스택_10828 {

    public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int num = Integer.parseInt(br.readLine());
	Stack stack = new Stack(num);
	for (int i = 0; i < num; i++) {
	    String comm = br.readLine();
	    stack.comm(comm);
	}
    }
}

class Stack {
    int top;
    int stack[];
    int size;

    public Stack(int size) {
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