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

		// TEST 21
		grid.add("BBGBGGGGGBBGGBB");
		grid.add("BBGBGGGGGBBGGBB");
		grid.add("GGGGGGGGGGGGGGG");
		grid.add("GGGGGGGGGGGGGGG");
		grid.add("BBGBGGGGGBBGGBB");
		grid.add("BBGBGGGGGBBGGBB");
		grid.add("BBGBGGGGGBBGGBB");
		grid.add("GGGGGGGGGGGGGGG");
		grid.add("BBGBGGGGGBBGGBB");
		grid.add("BBGBGGGGGBBGGBB");
		grid.add("BBGBGGGGGBBGGBB");
		grid.add("BBGBGGGGGBBGGBB");
		grid.add("BBGBGGGGGBBGGBB");
		grid.add("BBGBGGGGGBBGGBB");
		grid.add("GGGGGGGGGGGGGGG");

		// TEST 10
		// answer 81.
//		grid.add("GGGGGGGGGGGG");
//		grid.add("GBGGBBBBBBBG");
//		grid.add("GBGGBBBBBBBG");
//		grid.add("GGGGGGGGGGGG");
//		grid.add("GGGGGGGGGGGG");
//		grid.add("GGGGGGGGGGGG");
//		grid.add("GGGGGGGGGGGG");
//		grid.add("GBGGBBBBBBBG");
//		grid.add("GBGGBBBBBBBG");
//		grid.add("GBGGBBBBBBBG");
//		grid.add("GGGGGGGGGGGG");
//		grid.add("GBGGBBBBBBBG");

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
			System.out.println(1);
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
			if (sqData.size() == 1) {
				max = 5;
			} else {
				max = 1;
			}
		}

		System.out.println(max);

	}
}