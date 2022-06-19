package DataStructure;

import java.util.LinkedList;
import java.util.Scanner;

public class PrintTheElementsOfALinkedList {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		LinkedList<Integer> temp = new LinkedList<Integer>();
		int b = 0;
		for(int i=0; i<a; i++) {
			b = sc.nextInt();
			temp.add(b);
		}
		
		for(int i : temp) {
			System.out.println(i);
		}
	}
}  
