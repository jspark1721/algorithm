package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 큐_10845 {

    public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int num = Integer.parseInt(br.readLine());
	Queue queue = new Queue(num);
	for (int i = 0; i < num; i++) {
	    String comm = br.readLine();
	    queue.comm(comm);
	}
    }
}

class Queue {

    int rear = -1;
    int front = 0;
    int maxsize = 0;
    int[] queue;

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
	} else if (str.equals("fro")) {
	    front();
	} else if (str.equals("bac")) {
	    back();
	}
    }

    public Queue(int maxsize) {
	queue = new int[maxsize];
	this.maxsize = maxsize;

    }

    public void push(int num) {
	queue[++rear] = num;
    }

    public void pop() {
	if (front > rear) {
	    System.out.println(-1);
	} else {
	    int num = queue[front++];
	    System.out.println(num);
	}
    }

    public void size() {
	System.out.println(rear - front + 1);
    }

    public void empty() {
	if ((rear - front + 1) == 0)
	    System.out.println(1);
	else
	    System.out.println(0);
    }

    public void front() {
	if (front > rear) {
	    System.out.println(-1);
	} else {
	    System.out.println(queue[front]);
	}
    }

    public void back() {
	if (front > rear) {
	    System.out.println(-1);
	} else {
	    System.out.println(queue[rear]);
	}
    }
}