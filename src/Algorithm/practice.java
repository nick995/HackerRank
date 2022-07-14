package Algorithm;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class practice {

	public static int originalPossible = 0;

	public static void main(String[] args) {

		// abcdefg
		String w = "dkhc";

		char tempChar = ' ';		
		StringBuilder tempAnswer = new StringBuilder(w);
		String sortString = " ";
		
		int temp = 0;

		int temp2 = 0;
		
		boolean find = false;
		for (int i = 0; i < w.length() - 1; i++) {
			if (Character.compare(w.charAt(i), w.charAt(i + 1)) < 0) {
				temp = i;
				find = true;
			}
		}
		
		if(find == false) {
			return "no answer";
		}
		
		for(int j = w.length()-1; j>=temp; j--) {
			if(Character.compare(w.charAt(j), w.charAt(temp))>0 ) {
				temp2 = j;
				tempChar = w.charAt(j);
				break;
				
			}
		}
		System.out.println(tempAnswer);
		//swap
		tempAnswer.setCharAt(temp2, tempAnswer.charAt(temp));
		tempAnswer.setCharAt(temp, tempChar);
		
		sortString = tempAnswer.substring(temp+1, w.length());
		
		char[] arr = sortString.toCharArray();
		
		Arrays.sort(arr);
		
		
		tempAnswer.replace(temp+1, tempAnswer.length(), String.valueOf(arr) );
				
	}
}
