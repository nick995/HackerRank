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
	 * Complete the 'queensAttack' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts following
	 * parameters: 1. INTEGER n = row and column 2. INTEGER k = number of obstacles.
	 * 3. INTEGER r_q = queen's row 4. INTEGER c_q = queen's column.
	 * 
	 * 5. 2D_INTEGER_ARRAY obstacles
	 */

	public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
		// Write your code here

		int original = getOriginal(n, r_q, c_q);

		int block = obstacleCount(n, r_q, c_q, k, obstacles);

		return original - block;

	}

	public static int getOriginal(int square, int x, int y) {
		int originalPossible = 0;
		int n = square;
		int r_q = x;
		int c_q = y;

		int rowSum = 0;
		int colSum = 0;
		int quadrant1 = 0;
		int quadrant2 = 0;
		int quadrant3 = 0;
		int quadrant4 = 0;

		rowSum = n - 1;
		colSum = n - 1;
		// quadrant1
		for (int x1 = r_q + 1, y1 = c_q + 1; x1 < n || y1 < n; x1++, y1++) {
			quadrant1++;
		}
		// quadrant2
		for (int x2 = r_q + 1, y2 = c_q - 1; x2 < n || y2 > 1; x2++, y2--) {
			quadrant2++;

		}

		// quadrant3
		for (int x3 = r_q - 1, y3 = c_q - 1; x3 > 1 || y3 > 1; x3--, y3--) {
			quadrant3++;
		}
		// quadrant3
		for (int x4 = r_q - 1, y4 = c_q + 1; x4 > 1 || y4 < n; x4--, y4++) {
			quadrant4++;
		}

		originalPossible = rowSum + colSum + quadrant1 + quadrant2 + quadrant3 + quadrant4;

		return originalPossible;

	}

	public static int obstacleCount(int n, int r_q, int c_q, int obstacleNum, List<List<Integer>> obstacles) {

		int row = 0;
		int col = 0;

		int blockCount = 0;

		int temp = 0;

		if (obstacles.get(0).size() != 0) {

			for (int i = 0; i < obstacles.get(0).size(); i++) {
				row = obstacles.get(i).get(0);
				col = obstacles.get(i).get(1);

				// case 1.
				if (row == r_q) {
					blockCount += Math.min(col - 0, n - col);
				}

				if (col == c_q) {
					blockCount += Math.min(row - 0, n - row);
				}

				if (Math.abs(row - r_q) == Math.abs(col - c_q)) {

					// quadrant 1.
					if (row > r_q && col > c_q) {
						blockCount += Math.min(n - row + 1, n - col + 1);
					} else if (row > r_q && col < c_q) {
						blockCount += Math.min(n - row + 1, col - 0 + 1);
					} else if (row < r_q && col < c_q) {
						blockCount += Math.min(row - 0 + 1, col - 0 + 1);
					} else if (row < r_q && col > c_q) {
						blockCount += Math.min(row - 0 + 1, n - col + 1);

					}
				}

			}
		}

		return blockCount;

	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int n = Integer.parseInt(firstMultipleInput[0]);

		int k = Integer.parseInt(firstMultipleInput[1]);

		String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int r_q = Integer.parseInt(secondMultipleInput[0]);

		int c_q = Integer.parseInt(secondMultipleInput[1]);

		List<List<Integer>> obstacles = new ArrayList<>();

		IntStream.range(0, k).forEach(i -> {
			try {
				obstacles.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
						.map(Integer::parseInt).collect(toList()));
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		int result = Result.queensAttack(n, k, r_q, c_q, obstacles);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
