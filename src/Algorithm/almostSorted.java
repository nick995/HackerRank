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
	 * Complete the 'almostSorted' function below.
	 *
	 * The function accepts INTEGER_ARRAY arr as parameter.
	 */

	public static void almostSorted(List<Integer> arr) {
		// Write your code here

		ArrayList<Integer> list = new ArrayList<Integer>(arr);

		int targetInt = list.get(0);
		
		int index = 0;

		boolean availaible = false;

		for (int i = 1; i < list.size(); i++) {

			if(list.get(i) > targetInt) {
				availaible = true;
			}else {
				availaible = false;
			}
			
			if(availaible = false) {
				index = i;
				while(availaible = false) {
					i++;
				}
			}
			
			
		}
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt).collect(toList());

		Result.almostSorted(arr);

		bufferedReader.close();
	}
}
