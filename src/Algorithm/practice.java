package Algorithm;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Collectors;

public class practice {

	public static int originalPossible = 0;

	public static void main(String[] args) {

		int n = 10;
		int k = 9;

		int value = 0;

		List<Integer> temp = new ArrayList<Integer>();

		List<Integer> answer = new ArrayList<Integer>();

		HashMap<Integer, Boolean> checker = new HashMap<Integer, Boolean>();

		for (int i = 1; i <= n; i++) {
			checker.put(i, false);
			temp.add(i);
		}

		int low = 0;
		int high = 0;

		for (int i : temp) {
			//two possible number.
			low = i - k;
			high = i + k;
			
			if(k>=i) {
				answer.add(high);
				checker.replace(high, true);
			}else if(k<i) {
				if(checker.get(low)== true) {
					answer.add(high);
					checker.replace(high, true);
				}else {
					answer.add(low);
					checker.replace(low, true);
				}
			}
		}
		
		if(checker.containsValue(false)) {
			answer.clear();
			answer.add(-1);
			System.out.println(answer);
		}else {
			System.out.println(answer);
		}

//		for (int i : temp) {
//			if (i <= k) {
//
//				value = i + k;
//
//				if ((int) Math.abs(value - i) == k) {
//					answer.add(value);
//				}
//
//			} else if (i > k) {
//
//				value = i - k;
//
//				if (Math.abs(i - value) == k) {
//					answer.add(i - k);
//				}
//
//			}
//		}
//
//		List<Integer> tempAnswer = new ArrayList<Integer>(answer);
//
//		System.out.println(answer);
//
//		Collections.sort(tempAnswer);
//
//		if (!temp.equals(tempAnswer)) {
//			answer.clear();
//			answer.add(-1);
//			System.out.println(answer);
//		} else {
//			System.out.println(answer);
//		}

	}
}
