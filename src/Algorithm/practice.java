package Algorithm;

import java.util.*;

public class practice {
	public static void main(String[] args) {

		int n = 6;

		int[][] s = new int[3][3];

		int[] idealArray = new int[9];

		idealArray[0] = 8;
		idealArray[1] = 3;
		idealArray[2] = 4;
		idealArray[3] = 9;
		idealArray[4] = 2;
		idealArray[5] = 7;
		idealArray[6] = 6;
		idealArray[7] = 1;

//		s[0][0] = 4;
//		s[0][1] = 8;
//		s[0][2] = 2;
//		s[1][0] = 4;
//		s[1][1] = 5;
//		s[1][2] = 7;
//		s[2][0] = 6;
//		s[2][1] = 1;
//		s[2][2] = 6;

//		s[0][0] = 1;
//		s[0][1] = 3;
//		s[0][2] = 8;
//		s[1][0] = 6;
//		s[1][1] = 4;
//		s[1][2] = 1;
//		s[2][0] = 2;
//		s[2][1] = 6;
//		s[2][2] = 5;

//		s[0][0] = 2;
//		s[0][1] = 5;
//		s[0][2] = 4;
//		s[1][0] = 4;
//		s[1][1] = 6;
//		s[1][2] = 9;
//		s[2][0] = 4;
//		s[2][1] = 5;
//		s[2][2] = 2;
		s[0][0] = 4;
		s[0][1] = 8;
		s[0][2] = 2;
		s[1][0] = 4;
		s[1][1] = 5;
		s[1][2] = 7;
		s[2][0] = 6;
		s[2][1] = 1;
		s[2][2] = 6;

		int answer = Integer.MAX_VALUE;
		int tempSum = 0;
		int size = s[0].length * s.length;
		int t = 0;
		int temp = 0;
		
		int middleGap = 0;
		

		int[] tempArray = new int[size];

		Deque<Integer> q = new LinkedList<Integer>();
		for (int[] list : s) {
			for (int j : list) {
				if(t== 4) {
					middleGap += Math.abs(5-j);
				}else {
					q.add(j);
				}
				t++;
			}
		}
		
		for (int i = 0; i < size; i++) {
			Iterator<Integer> iq = q.iterator();
			tempSum = 0;
			
			for (int x = 0; x < size-1; x++) {
				tempSum += Math.abs(idealArray[x] - iq.next());
			}
			tempSum += middleGap;
			
			
			if(tempSum<answer) {
				answer  = tempSum;
				System.out.println(answer);
			}
			
			temp = q.poll();
			q.addLast(temp);
		}
		
		

	}

}
