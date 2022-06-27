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
	 * Complete the 'formingMagicSquare' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts
	 * 2D_INTEGER_ARRAY s as parameter.
	 */

	public static int formingMagicSquare(List<List<Integer>> s) {
		// Write your code here

		int[] idealArray = new int[9];

		idealArray[0] = 8;
		idealArray[1] = 3;
		idealArray[2] = 4;
		idealArray[3] = 9;
		idealArray[4] = 2;
		idealArray[5] = 7;
		idealArray[6] = 6;
		idealArray[7] = 1;

		int answer = Integer.MAX_VALUE;
		int tempSum = 0;
		int size = s.get(0).size() * s.size();
		int t = 0
				;
		int temp = 0;

		int middleGap = 0;

		int[] tempArray = new int[size];

		Deque<Integer> q = new LinkedList<Integer>();
		for (List<Integer> list : s) {
			for (int j : list) {
				if (t == 4) {
					middleGap += Math.abs(5 - j);
				} else {
					q.add(j);
				}
				t++;
			}
		}

		for (int i = 0; i < size - 1; i++) {
			Iterator<Integer> iq = q.iterator();
			tempSum = 0;

			for (int x = 0; x < size - 1; x++) {
				tempSum += Math.abs(idealArray[x] - iq.next());
			}
			tempSum += middleGap;
			if (tempSum < answer) {
				answer = tempSum;
			}

			temp = q.poll();
			q.addLast(temp);
		}

		return answer;

	}

	public class Solution {
		public static void main(String[] args) throws IOException {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

			List<List<Integer>> s = new ArrayList<>();

			IntStream.range(0, 3).forEach(i -> {
				try {
					s.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt)
							.collect(toList()));
				} catch (IOException ex) {
					throw new RuntimeException(ex);
				}
			});

			int result = Result.formingMagicSquare(s);

			bufferedWriter.write(String.valueOf(result));
			bufferedWriter.newLine();

			bufferedReader.close();
			bufferedWriter.close();
		}
	}
}
