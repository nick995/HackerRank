package Algorithm;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class practice {

	public static int originalPossible = 0;

	public static void main(String[] args) {

		int n = 8;
		int k = 3;

		int r_q = 4;
		int c_q = 4;

		int[][] obstacles = new int[n][n];

		obstacles[4][2] =

				getOriginal(n, r_q, c_q);

	}

	public static int getOriginal(int square, int x, int y) {

		int n = square;
		int r_q = x;
		int c_q = y;

		int rowSum = 0;
		int colSum = 0;
		int quadrant1 = 0;
		int quadrant2 = 0;
		int quadrant3 = 0;
		int quadrant4 = 0;

		rowSum = n - 1;
		colSum = n - 1;

		System.out.println("quadrant 1 ");
		// quadrant1
		for (int x1 = r_q + 1, y1 = c_q + 1; x1 < n || y1 < n; x1++, y1++) {

			System.out.println(x1 + " " + y1);

			quadrant1++;
		}

		System.out.println("quadrant 1 possible = " + quadrant1);
		System.out.println();

		System.out.println("quadrant 2 ");
		// quadrant2
		for (int x2 = r_q + 1, y2 = c_q - 1; x2 < n || y2 > 1; x2++, y2--) {

			System.out.println(x2 + " " + y2);

			quadrant2++;

		}
		System.out.println("quadrant 2 possible = " + quadrant2);

		System.out.println("quadra 3 ");

		// quadrant3
		for (int x3 = r_q - 1, y3 = c_q - 1; x3 > 1 || y3 > 1; x3--, y3--) {

			System.out.println(x3 + " " + y3);

			quadrant3++;

		}

		System.out.println("quadrant 3 possible = " + quadrant3);

		System.out.println("quadra 4 ");

		// quadrant3
		for (int x4 = r_q - 1, y4 = c_q + 1; x4 > 1 || y4 < n; x4--, y4++) {

			System.out.println(x4 + " " + y4);

			quadrant4++;
		}

		System.out.println("quadrant 4 possible = " + quadrant4);

		originalPossible = rowSum + colSum + quadrant1 + quadrant2 + quadrant3 + quadrant4;

		System.out.println(originalPossible);

		return originalPossible;

	}

	public static int obstacleCount(int n, int r_q, int c_q, int obstacleNum, List<List<Integer>> obstacles) {

		int row = 0;
		int col = 0;

		int blockCount = 0;

		int temp =0;
		
		for (int i = 0; i < obstacles.get(0).size(); i++) {
			row = obstacles.get(i).get(0);
			col = obstacles.get(i).get(1);

			// case 1.
			if (row == r_q) {
				blockCount += Math.min(col - 0, col - n);
			}

			if (col == c_q) {
				blockCount += Math.min(row - 0, row - n);
			}
			
			if(Math.abs(row-r_q) + Math.abs(col-c_q) % 2 == 0 ) {
				
			}

		}

		return obstacleNum;

	}
}
