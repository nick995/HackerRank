package InterviewPreparationKit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class practice {
	public static void main(String[] args) {
		ArrayList<Integer> q = new ArrayList<Integer>();

//		q.add(1);
//		q.add(2);
//		q.add(5);
//		q.add(3);
//		q.add(7);
//		q.add(8);
//		q.add(6);
//		q.add(4);

		// 5 1 2 3 7 8 6 4

//		q.add(5);
//		q.add(1);
//		q.add(2);
//		q.add(3);
//		q.add(7);
//		q.add(8);
//		q.add(6);
//		q.add(4);

		// 2 1 5 3 4

		q.add(2);
		q.add();
		q.add(1);
		q.add(3);
		q.add(4);

		HashMap<Integer, Integer> counting = new HashMap<Integer, Integer>();

		int key = 0;

		int countingUp = 0;

		int sum = 0;

		boolean chao = false;

		int ideal = 0;

		int idealIdx = 0;

		int current = 0;

		for (int i = 1; i <= q.size(); i++) {
			counting.put(i, 0);
		}

		for (int i = 0; i < q.size(); i++) {

			ideal = i + 1;

			if (q.get(i) != ideal) {
				current = q.get(i);

				idealIdx = q.get(i) - 1;

				if (idealIdx - i > 2) {
					System.out.println("Too chaotic");
					chao = true;
					break;

				}

			}

			for (int j = i - 1; j >= 0; j--) {

				if (q.get(i) < q.get(j)) {

					key = q.get(j);

					countingUp = counting.get(key);

					countingUp++;
					counting.put(key, countingUp);
				}
			}
			if (chao == true) {
				break;
			}
		}

		if (chao != true) {
			for (Integer i : counting.keySet()) {
				sum += counting.get(i);
			}
			System.out.println(sum);
		}
	}
}
