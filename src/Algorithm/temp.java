package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class temp {
	public static void main(String[] args) {

		List<Integer> temp = new ArrayList<>(5);

		temp.add(1);
		temp.add(100);
		temp.add(10);
		temp.add(1000);
		temp.add(10000);

		
		int[] tempArray = new int[5];

		for (int i = 0; i < temp.size(); i++) {
			tempArray[i] = temp.get(i);
		}
		
		for(int i : tempArray) {
			System.out.print(i + " ");
		}

		System.out.println();
		Arrays.sort(tempArray);
		
		for(int i : tempArray) {
			System.out.print(i + " ");
		}
				
		int min = 0;
		int max = 0;

		for (int i = 0; i < temp.size() - 1; i++) {
			min += tempArray[i];
		}

		for (int i = 1; i < temp.size(); i++) {
			max += tempArray[i];
		}

//		System.out.println(min + " " + max);

	}

}
