package Algorithm;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Collectors;
import java.awt.Point;
import java.lang.*;

public class practice {

	public static void main(String[] args) {

		List<Integer> arr = new ArrayList<Integer>();

		arr.add(1);
		arr.add(4);
		arr.add(3);
		arr.add(2);
		arr.add(5);
		arr.add(6);
		
		//Test case 3
//		arr.add(1);
//		arr.add(5);
//		arr.add(4);
//		arr.add(3);
//		arr.add(2);
//		arr.add(6);
		
		
		//Test case 2 
		
//		arr.add(3);
//		arr.add(1);
//		arr.add(2);

		ArrayList<Integer> list = new ArrayList<Integer>(arr);

		ArrayList<Boolean> temp = new ArrayList<Boolean>();
		int targetInt = list.get(0);

		temp.add(true);

		int first = 0;
		int last = 0;
		
		boolean flag = false;
		

		String option = "";

		boolean availaible = false;

		for (int i = 1; i < list.size(); i++) {

			if (list.get(i) > list.get(i-1)) {
				temp.add(true);
				
				
				
				if(flag == true) {
					last = i;
					flag = false;
				}

			} else {
				availaible = false;
				
				if(flag == false) {
					first = i-1;
					flag = true;
				}
				
				temp.add(false);
				
				
				
			}

		}

		for (boolean t : temp) {
			System.out.println(t);
		}
		
		System.out.println(first);
		
		System.out.println(last);
		
		int tCount = 0;
		int fCount = 0;
		
		for(int i= first; i<last; i++) {
			if(temp.get(i) == false) {
				fCount++;
			}else {
				tCount++;
			}
		}
		
		System.out.println(fCount);
		System.out.println(tCount);
		
	}
	
	public static void swapable(List<Integer> arr, int first, int last) {
		
	}

}