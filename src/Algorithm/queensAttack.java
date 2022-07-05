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

		int rowSum = 0;
		int colSum = 0;
		int quadrant1 = 0;
		int quadrant2 = 0;
		int quadrant3 = 0;
		int quadrant4 = 0;

		int originalPossible = 0;

		rowSum = n - 1;
		colSum = n - 1;
		
		for(int x1 = r_q, y1 = c_q; x1<= 5 || y1<= 5; x1++, y1++) {
			
			quadrant1++;
			
		}
		
		
		
		
		
		originalPossible = rowSum + colSum + quadrant1 + quadrant2 + quadrant3 + quadrant4;

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
