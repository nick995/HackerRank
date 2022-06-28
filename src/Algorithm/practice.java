package Algorithm;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class practice {
	public static void main(String[] args) {

		List<Integer> s = new ArrayList<Integer>();
		int k = 3;
		s.add(1);
		s.add(7);
		s.add(2);
		s.add(4);

		// ==============================================

		int[] bucket = new int[k];
		int answer = 0;
		// place to the bucket.
		for (int i : s) {
			bucket[i % k]++;
		}

		for (int i = 0; i <= bucket.length / 2; i++) {

			if ((k - i) % k == i) {
				if (bucket[i] > 0) {
					answer++;
				}
			} else {
				if (bucket[i] > bucket[(k - i) % k]) {
					answer += bucket[i];
				} else {
					answer += bucket[(k - i) % k];
				}
			}
		}
		System.out.println(answer);
	}
}
