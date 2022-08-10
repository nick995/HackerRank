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
		arr.add(5);
		arr.add(4);
		arr.add(3);
		arr.add(2);
		arr.add(6);

		ArrayList<Integer> list = new ArrayList<Integer>(arr);

		int targetInt = list.get(0);

		int index = 0;

		boolean availaible = false;

		for (int i = 1; i < list.size(); i++) {

			if (list.get(i) > targetInt) {
				availaible = true;
				targetInt = list.get(i);
			} else {
				availaible = false;
			}

			System.out.println("index = " + i + " avail =" + availaible);

			if (availaible = false) {

				while (availaible = false) {

					if (list.get(i) > targetInt) {
						availaible = true;
						targetInt = list.get(i);
					} else {
						availaible = false;
					}
					System.out.println("index = " + i + " avail =" + availaible);

				}
			}

		}

	}

}