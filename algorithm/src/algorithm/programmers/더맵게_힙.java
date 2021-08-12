package algorithm.programmers;

import java.util.PriorityQueue;

class 더맵게_힙 {
    public int solution(int[] scoville, int K) {
	int answer = 0;

	PriorityQueue<Integer> scoList = new PriorityQueue<>();
	for (int i = 0; i < scoville.length; i++) {
	    scoList.add(scoville[i]);
	}

	while (!scoList.isEmpty()) {

	    int min = scoList.poll();
	    if (min >= K) {
		break;
	    }
	    if (scoList.size() < 1) {
		answer = -1;
		break;
	    }

	    answer++;
	    scoList.add(min + (scoList.poll() * 2));
	}
	return answer;
    }
}