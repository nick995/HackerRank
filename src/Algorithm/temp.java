package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class temp {
	public static void main(String[] args) {

		List<Integer> temp = new ArrayList<>(4);

		temp.add(1);
		temp.add(100);
		temp.add(10);
		temp.add(100);

		
		int max = temp.get(0);
		int count = 0;

		for (int i = 0; i < temp.size(); i++) {
			if (max < temp.get(i)) {
				max = temp.get(i);
				count = 1;
			} else if (max == temp.get(i)) {
				count++;
			}
		}
		System.out.println(max);
		
		System.out.println(count);
	}

}
