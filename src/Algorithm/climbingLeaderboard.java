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
	 * Complete the 'climbingLeaderboard' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY. The function accepts
	 * following parameters: 1. INTEGER_ARRAY ranked 2. INTEGER_ARRAY player
	 */

	public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
		// Write your code here

		ArrayList<Integer> temp = new ArrayList<Integer>();
		ArrayList<Integer> answer = new ArrayList<Integer>();

		Collections.sort(ranked.stream().distinct().toList());

		System.out.println(ranked);
		
		int max = temp.get(temp.size() - 1);
		System.out.println(max);

		for (int i = 0; i < player.size(); i++) {
			for (int j = 0; j < temp.size(); j++) {
				if (player.get(i) < temp.get(j)) {
					answer.add(temp.size() - j + 1);
					
					break;
				} else if (player.get(i) == temp.get(j)) {
					answer.add(temp.size() - j);
					break;
				}

				if (player.get(i) > max) {
					answer.add(1);
					break;
				}

			}

		}

		return answer;
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt).collect(toList());

		int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt).collect(toList());

		List<Integer> result = Result.climbingLeaderboard(ranked, player);

		bufferedWriter.write(result.stream().map(Object::toString).collect(joining("\n")) + "\n");

		bufferedReader.close();
		bufferedWriter.close();
	}
}
