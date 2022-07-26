package Algorithm;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Collectors;

public class practice {

	public static int originalPossible = 0;

	public static void main(String[] args) {

		int n = 2;

		List<String> grid = new ArrayList<String>();
		grid.add(".......");
		grid.add("...O...");
		grid.add("....O..");
		grid.add(".......");
		grid.add("OO.....");
		grid.add("OO.....");

		// =============================================================

		ArrayList<String> answer = new ArrayList<String>();

		ArrayList<StringBuilder> temp = new ArrayList<StringBuilder>();

		StringBuilder tempSb = new StringBuilder();

		String tempS = "";

		int cycle = 0;
		// nothing happen
		if (n == 1) {
			return grid;
		} 
		
		
		for (int i = 0; i < grid.get(0).length(); i++) {
			tempS += "O";
		}

		for (int i = 0; i < grid.size(); i++) {
			tempSb = new StringBuilder(tempS);
			temp.add(tempSb);
		}

		// first case all bomb.
		if (n % 2 == 0) {
			for (StringBuilder sb : temp) {
				answer.add(sb.toString());
			}
			return answer;
		}

		//

		for (int i = 0; i < grid.size(); i++) {
			for (int j = 0; j < grid.get(0).length(); j++) {

				System.out.println("i = " + i + " J = " + j);
				if (grid.get(i).charAt(j) == 'O') {

					// middle
					temp.get(i).setCharAt(j, '.');

					// up side
					if (i - 1 >= 0) {
						temp.get(i - 1).setCharAt(j, '.');
					} // left side
					if (j - 1 >= 0) {
						temp.get(i).setCharAt(j - 1, '.');
					} // right side
					if (j + 1 < grid.get(0).length()) {
						temp.get(i).setCharAt(j + 1, '.');
					} // down side.
					if (i + 1 < grid.size()) {
						temp.get(i + 1).setCharAt(j, '.');
					}
				}
			}
		}

	}

	public static List<StringBuilder> explosionCalculate(List<String> grid, int n) {

		ArrayList<StringBuilder> temp = new ArrayList<StringBuilder>();

		StringBuilder tempSb = new StringBuilder();

		String tempS = "";

		for (int i = 0; i < grid.get(0).length(); i++) {
			tempS += "O";
		}

		for (int i = 0; i < grid.size(); i++) {
			tempSb = new StringBuilder(tempS);
			temp.add(tempSb);
		}

		if (n % 2 != 0) {

		}

		for (int i = 0; i < grid.size(); i++) {
			for (int j = 0; j < grid.get(0).length(); j++) {

				System.out.println("i = " + i + " J = " + j);
				if (grid.get(i).charAt(j) == 'O') {

					// middle
					temp.get(i).setCharAt(j, '.');

					// up side
					if (i - 1 >= 0) {
						temp.get(i - 1).setCharAt(j, '.');
					} // left side
					if (j - 1 >= 0) {
						temp.get(i).setCharAt(j - 1, '.');
					} // right side
					if (j + 1 < grid.get(0).length()) {
						temp.get(i).setCharAt(j + 1, '.');
					} // down side.
					if (i + 1 < grid.size()) {
						temp.get(i + 1).setCharAt(j, '.');
					}
				}
			}
		}

		return temp;

	}
}
