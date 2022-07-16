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

		G.add("7283455864");
		G.add("6731158619");
		G.add("8988242643");
		G.add("3830589324");
		G.add("2229505813");
		G.add("5633845374");
		G.add("6473530293");
		G.add("7053106601");
		G.add("0834282956");
		G.add("4607924137");

		P.add("9505");
		P.add("3845");
		P.add("3530");

		// x
		int row = P.get(0).length();
		// y
		int col = P.size();

		int temp = 0;

		int startIndex = 0;
		int endIndex = 0;
		int j = 0;
		String tempString = " ";
		String answer = "NO";

		for (String s : G) {

			if (s.contains(P.get(0))) {

				startIndex = s.indexOf(P.get(0));
				endIndex = startIndex + row;
				// List
				for (int i = temp; i < temp + col; i++, j++) {
					tempString = G.get(i).substring(startIndex, endIndex);
					System.out.println(tempString);

					if(tempString.equals(P.get(j))) {
						answer = "YES";
						System.out.println(answer);
					}else {
						answer = "NO";
						break;
					}
				}
				j = 0;

			}
			temp++;
		}
		
		System.out.println(answer);
	}
}
