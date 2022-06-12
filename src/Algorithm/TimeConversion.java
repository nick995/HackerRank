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
	 * Complete the 'timeConversion' function below.
	 *
	 * The function is expected to return a STRING. The function accepts STRING s as
	 * parameter.
	 */

	public static String timeConversion(String s) {
		// Write your code here

		StringBuilder temp = new StringBuilder();
		int a = 0;
		int b = 0;
		int c = 0;
		if (s.charAt(s.length() - 2) == 'P') {
			a = Character.getNumericValue(s.charAt(0));
			b = Character.getNumericValue(s.charAt(1));

			temp.append(a);
			temp.append(b);
			System.out.println(temp);
			c = Integer.parseInt(temp.toString());

			if (c != 12) {
				c += 12;
			}
			System.out.println(c);
			temp.setLength(0);
			temp.append(String.valueOf(c));
			for (int i = 2; i < s.length() - 2; i++) {
				temp.append(s.charAt(i));
			}
			// AM
		} else {
			a = Character.getNumericValue(s.charAt(0));
			b = Character.getNumericValue(s.charAt(1));

			temp.append(a);
			temp.append(b);
			c = Integer.parseInt(temp.toString());
			temp.setLength(0);
			// special case
			if (c == 12) {
				c -= 12;
				temp.append('0');
			} else if (c < 12) {
				temp.append('0');
				temp.append(String.valueOf(c));
				for (int i = 2; i < s.length() - 2; i++) {
					temp.append(s.charAt(i));

				}
			} else {
				temp.append(String.valueOf(c));
				for (int i = 2; i < s.length() - 2; i++) {
					temp.append(s.charAt(i));

				}
			}

		}
		return temp.toString();

	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String s = bufferedReader.readLine();

		String result = Result.timeConversion(s);

		bufferedWriter.write(result);
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
