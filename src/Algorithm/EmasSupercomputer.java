import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.awt.Point;

class Result {

	/*
	 * Complete the 'twoPluses' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts
	 * STRING_ARRAY grid as parameter.
	 * 
	 */

	public static int twoPluses(List<String> grid) {
		// Write your code here

		ArrayList<StringBuilder> temp = new ArrayList<StringBuilder>();

		StringBuilder sbTemp = new StringBuilder("");

		LinkedHashMap<Point, ArrayList<SquareData>> sqData = new LinkedHashMap<Point, ArrayList<SquareData>>();

		for (int i = 0; i < grid.size(); i++) {
			sbTemp = new StringBuilder("");
			for (int j = 0; j < grid.get(0).length(); j++) {
				if (grid.get(i).charAt(j) == 'B') {
					sbTemp.append("9");
				} else {
					sbTemp.append("0");
				}
			}
			temp.add(sbTemp);
		}

		Point top = new Point();
		Point left = new Point();
		Point right = new Point();
		Point bottom = new Point();
		Point main = new Point();

		int cycle = 0;

		int numberth = 0;

		boolean available = true;
		// row
		for (int y = 0; y < grid.size(); y++) {
			// col
			for (int x = 0; x < grid.get(0).length(); x++) {
				// initalizing.
				cycle = 0;
				if (grid.get(y).charAt(x) == 'G') {

					// initalize
					main = new Point(x, y);

					do {
						// checking square
						available = true;

						cycle++;

						// top side
						if (y - cycle >= 0 && grid.get(y - cycle).charAt(x) == 'G') {
							top = new Point(x, y - cycle);
						} else {
							available = false;
							break;
						}

						// bottom side
						if (y + cycle < grid.size() && grid.get(y + cycle).charAt(x) == 'G') {
							bottom = new Point(x, y + cycle);
						} else {
							available = false;
							break;
						}
						// left side
						if (x - cycle >= 0 && grid.get(y).charAt(x - cycle) == 'G') {
							left = new Point(x - cycle, y);
						} else {
							available = false;
							break;
						}
						// right side
						if (x + cycle < grid.get(0).length() && grid.get(y).charAt(x + cycle) == 'G') {
							right = new Point(x + cycle, y);
						} else {
							available = false;
							break;
						}

						if (available == true) {

							if (!sqData.containsKey(main)) {
								ArrayList<SquareData> templist = new ArrayList<SquareData>();
								sqData.put(main, templist);
							}

							SquareData data = new SquareData();

							data.pointCord.add(top);
							data.pointCord.add(bottom);
							data.pointCord.add(left);
							data.pointCord.add(right);
							data.pointCord.add(main);

							if (cycle > 1) {
								data.pointCord.addAll(sqData.get(main).get(cycle - 2).pointCord);
							}

							data.squareSize = cycle * 4 + 1;

							data.main = main;

							data.setCycle(cycle);

							sqData.get(main).add(data);

						} else {
							cycle--;
						}

					} while (available = true);

				}
			}
		}

		int max = 0;

		if (sqData.size() == 0) {
			return 1;
		}

		for (Point allKey : sqData.keySet()) {

			for (SquareData sd : sqData.get(allKey)) {

				Iterator<Point> itr = sqData.keySet().iterator();

				itr.next();

				while (itr.hasNext()) {

					Point key = itr.next();

					ArrayList<SquareData> value = sqData.get(key);

					ArrayList<Point> check = new ArrayList<Point>();

					for (SquareData t : value) {

						check = new ArrayList<Point>(t.pointCord);

						check.retainAll(sd.pointCord);

						if (check.isEmpty()) {
							if (sd.squareSize * t.squareSize > max) {

								System.out.println(sd.squareSize + " " + t.squareSize);

								System.out.println(sd.main + " " + t.main);

								max = sd.squareSize * t.squareSize;
							}
						} else {
							break;
						}
					}
				}
			}

		}

		if (max == 0) {
			return 5;
		}

		return max;

	}

}

class SquareData {

	int squareSize;

	int cycle;

	ArrayList<Point> pointCord;

	Point main;

	public SquareData() {

		main = new Point();

		squareSize = 0;

		pointCord = new ArrayList<Point>();

		cycle = 0;
	}

	public Point getMainPoint() {
		return main;
	}

	public int getSquareSize() {
		return squareSize;
	}

	public ArrayList<Point> getPointCord() {
		return pointCord;
	}

	public int getCycle() {
		return this.cycle;
	}

	public void setCycle(int c) {
		this.cycle = c;
	}

	public void setNumberth(Point m) {
		this.main = m;
	}

	public void setSquareSize(int n) {
		this.squareSize = n;
	}

	public void setPointCord(ArrayList<Point> p) {
		this.pointCord = p;
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int n = Integer.parseInt(firstMultipleInput[0]);

		int m = Integer.parseInt(firstMultipleInput[1]);

		List<String> grid = IntStream.range(0, n).mapToObj(i -> {
			try {
				return bufferedReader.readLine();
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).collect(toList());

		int result = Result.twoPluses(grid);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
