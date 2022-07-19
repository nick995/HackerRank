import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

	/*
	 * Complete the 'absolutePermutation' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY. The function accepts
	 * following parameters: 1. INTEGER n 2. INTEGER k
	 */

	public static List<Integer> absolutePermutation(int n, int k) {
		// Write your code here
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
			// two possible number.
			low = i - k;
			high = i + k;

			if (k >= i) {
				answer.add(high);
				checker.replace(high, true);
			} else if (k < i) {
				if (checker.get(low) == true) {
					answer.add(high);
					checker.replace(high, true);
				} else {
					answer.add(low);
					checker.replace(low, true);
				}
			}
		}

		if (checker.containsValue(false)) {
			answer.clear();
			answer.add(-1);
			return answer;
		} else {
			return answer;
		}

	}
	//fail version
/*
	public static List<Integer> absolutePermutation(int n, int k) {
		int value = 0;

		List<Integer> temp = new ArrayList<Integer>();

		List<Integer> answer = new ArrayList<Integer>();

		for (int i = 1; i <= n; i++) {
			temp.add(i);
		}

		for (int i : temp) {
			if (i <= k) {

				value = i + k;

				if ((int) Math.abs(value - i) == k) {
					answer.add(value);
				}

			} else if (i > k) {

				value = i - k;

				if (Math.abs(i - value) == k) {
					answer.add(i - k);
				}

			}
		}

		List<Integer> tempAnswer = new ArrayList<Integer>(answer);

		Collections.sort(tempAnswer);

		if (!temp.equals(tempAnswer)) {
			answer.clear();
			answer.add(-1);
			return answer;
		} else {
			return answer;
		}

	}

} 
*/

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int t = Integer.parseInt(bufferedReader.readLine().trim());

		IntStream.range(0, t).forEach(tItr -> {
			try {
				String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

				int n = Integer.parseInt(firstMultipleInput[0]);

				int k = Integer.parseInt(firstMultipleInput[1]);

				List<Integer> result = Result.absolutePermutation(n, k);

				bufferedWriter.write(result.stream().map(Object::toString).collect(joining(" ")) + "\n");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		bufferedReader.close();
		bufferedWriter.close();
	}
}
