package Algorithm;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Collectors;

public class practice {

	public static int originalPossible = 0;

	public static void main(String[] args) {

		// target list
		List<String> G = new ArrayList<String>();

		// that we have to find
		List<String> P = new ArrayList<String>();

		G.add("11111111");
		G.add("22222222");
		G.add("33033333");

		P.add("11");
		P.add("22");
		P.add("33");

		// x
		int row = P.get(0).length();
		// y
		int col = P.size();

		int temp = 0;

		int startIndex = 0;
		int endIndex = 0;
		int j = 0;

		int continious = 0;
		int count = 0;
		String tempString = "";
		String answer = "NO";

		for (String s : G) {

			//
			if (s.contains(P.get(0))) {

				startIndex = s.indexOf(P.get(0));
				endIndex = startIndex + row;
				continious = s.lastIndexOf(P.get(0));

				// List
				for (int i = temp; i < temp + col; i++, j++) {

					if (startIndex != continious) {

						int tempI = i;

						for (int z = startIndex; z < continious; z++) {

							while (count != col) {

								tempString = G.get(tempI).substring(z, z + row);

								if (tempString.equals(P.get(count))) {
									answer = "YES";
									tempI++;
									count++;

								} else {
									answer = "NO";
									tempI = i;
									count = 0;
									break;
								}
							}

							if (count == col) {
								System.out.println("return yes");
								break;
							}

						}

					}
					j = 0;

				}
				if (answer.equals("YES")) {
					break;
				}
				temp++;
			}

			System.out.println(answer);
		}
	}
}