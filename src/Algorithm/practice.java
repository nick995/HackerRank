package Algorithm;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Collectors;
import java.awt.Point;
import java.lang.*;

public class practice {

	public static int originalPossible = 0;

	public static void main(String[] args) {

		List<String> grid = new ArrayList<String>();

		// TEST 1
//		grid.add("BBBGBGBBB");
//		grid.add("BBBGBGBBB");
//		grid.add("BBBGBGBBB");
//		grid.add("GGGGGGGGG");
//		grid.add("BBBGBGBBB");
//		grid.add("BBBGBGBBB");
//		grid.add("GGGGGGGGG");
//		grid.add("BBBGBGBBB");
//		grid.add("BBBGBGBBB");
//		grid.add("BBBGBGBBB");

		// TEST 0
//		grid.add("GGGGGG");
//		grid.add("GBBBGB");
//		grid.add("GGGGGG");
//		grid.add("GGBBGB");
//		grid.add("GGGGGG");

		// TEST 6 PASSED
//		grid.add("GGGGGGGGG");
//		grid.add("GBBBGGBGG");
//		grid.add("GBBBGGBGG");
//		grid.add("GBBBGGBGG");
//		grid.add("GBBBGGBGG");
//		grid.add("GBBBGGBGG");
//		grid.add("GBBBGGBGG");
//		grid.add("GGGGGGGGG");
		
		//TEST 21 
//		grid.add("BBGBGGGGGBBGGBB");
//		grid.add("BBGBGGGGGBBGGBB");
//		grid.add("GGGGGGGGGGGGGGG");
//		grid.add("GGGGGGGGGGGGGGG");
//		grid.add("BBGBGGGGGBBGGBB");
//		grid.add("BBGBGGGGGBBGGBB");
//		grid.add("BBGBGGGGGBBGGBB");
//		grid.add("GGGGGGGGGGGGGGG");
//		grid.add("BBGBGGGGGBBGGBB");
//		grid.add("BBGBGGGGGBBGGBB");
//		grid.add("BBGBGGGGGBBGGBB");
//		grid.add("BBGBGGGGGBBGGBB");
//		grid.add("BBGBGGGGGBBGGBB");
//		grid.add("BBGBGGGGGBBGGBB");
//		grid.add("GGGGGGGGGGGGGGG");
		
		

		ArrayList<StringBuilder> temp = new ArrayList<StringBuilder>();

		StringBuilder sbTemp = new StringBuilder("");

		HashMap<Point, ArrayList<SquareData>> sqData = new HashMap<Point, ArrayList<SquareData>>();

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
			System.out.println(1);
		}

		Optional<Point> firstKey = sqData.keySet().stream().findFirst();

		Point fKey = firstKey.get();

		for (SquareData sd : sqData.get(fKey)) {

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
							max = sd.squareSize * t.squareSize;
						}
					} else {
						break;
					}
				}
			}
		}

		if (max == 0) {
			if (sqData.size() == 1) {
				max = 5;
			} else {
				max = 1;
			}
		}

		System.out.println(max);

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
