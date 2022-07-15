package Algorithm;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Collectors;

public class practice {

	public static int originalPossible = 0;

	public static void main(String[] args) {

		int[] numbers = new int[5];
		int[] answer = {};

		int possible = 0;
		numbers[0] = 2;
		numbers[1] = 1;
		numbers[2] = 3;
		numbers[3] = 4;
		numbers[4] = 1;
		ArrayList<Integer> temp = new ArrayList<Integer>();

		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				possible = numbers[i] + numbers[j];
				temp.add(possible);
			}
		}

		Collections.sort(temp);

		temp = (ArrayList<Integer>) temp.stream().distinct().collect(Collectors.toList());
		int tempInt = 0 ;
		for(int i : temp) {
			answer[tempInt] = i;
			tempInt++;
		}
		tempInt = 0;
		
		
		
		
	}
}
