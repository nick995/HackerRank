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
		grid.add("BBBGBGBBB");
		grid.add("BBBGBGBBB");
		grid.add("BBBGBGBBB");
		grid.add("GGGGGGGGG");
		grid.add("BBBGBGBBB");
		grid.add("BBBGBGBBB");
		grid.add("GGGGGGGGG");
		grid.add("BBBGBGBBB");
		grid.add("BBBGBGBBB");
		grid.add("BBBGBGBBB");

//		grid.add("BBBGBBB");
//		grid.add("BBBGBBB");
//		grid.add("BGGGGGB");
//		grid.add("BBBGBBB");
//		grid.add("BBBGBBB");
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
							
							if(!sqData.containsKey(main)) {
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
														
							sqData.get(main).add(data);
							

//							System.out.println(main.x + " " + main.y + " available = " + available + " CYCLE = " +  cycle);

						} else {
							cycle--;
						}

					} while (available = true);

				}
			}
		}
		
		int max =0;
			
		Optional<Point> firstKey = sqData.keySet().stream().findFirst();
		
		Point fKey = firstKey.get();
		
		Iterator<Point> itr = sqData.keySet().iterator();
		
		itr.next();
		
		for(SquareData sd : sqData.get(fKey)) {
			
			while(itr.hasNext()) {
								
				Point key =	itr.next();
				
				ArrayList<SquareData> value = sqData.get(key);
				
				ArrayList<Point> check = new ArrayList<Point>();
				
				for(int i=0; i< value.size(); i++) {
					
					System.out.println("checked = " + value.get(i).main);
					
					System.out.println("Point cord = " + value.get(i).pointCord);
					
					System.out.println("Main = " + sd.main);
					
					System.out.println("Point cord = " + sd.pointCord);
					
					System.out.println(value.get(i).pointCord.retainAll(sd.getPointCord()) );
					
					check = value.get(i).pointCord.retainAll(sd.getPointCord());
					
					if(value.get(i).pointCord.retainAll(sd.getPointCord()) == false) {
						

						if(sd.squareSize*value.get(i).squareSize> max) {
							max = sd.squareSize*value.get(i).squareSize;
						}
					}else {
						break;
					}
					
					
				}
				
				
			}
		}
		
		System.out.println(max);
	}
}

class SquareData {

	int squareSize;

	ArrayList<Point> pointCord;

	boolean duplicated;

	Point main;

	public SquareData() {

		main = new Point();

		squareSize = 0;

		pointCord = new ArrayList<Point>();

		duplicated = false;
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

	public boolean getDuplicated() {
		return duplicated;
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

	public void setDuplicated(boolean dup) {
		this.duplicated = dup;
	}

}
