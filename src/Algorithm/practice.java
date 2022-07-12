package Algorithm;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class practice {

	public static int originalPossible = 0;

	public static void main(String[] args) {

		String s = "haveaniceday";
		
		int row = (int) Math.sqrt(s.length());
		
		int col =  (int) Math.ceil(Math.sqrt(s.length()));
		
		HashMap<Integer, List<Character>> temp = new HashMap<Integer, List<Character>>();
		// initializing
		for (int i = 0; i < col; i++) {
			temp.put(i, new ArrayList<Character>());
		}

		for (int i = 0; i < s.length(); i++) {

			temp.get(i % col).add(s.charAt(i));
		}
		StringBuilder tempanswer = new StringBuilder();

		for (Entry<Integer, List<Character>> l : temp.entrySet()) {

			for (char c : l.getValue()) {
				tempanswer.append(c);
			}
			tempanswer.append(" ");

		}
		System.out.println(tempanswer.toString());

	}
}
