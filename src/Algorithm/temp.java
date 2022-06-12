package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class temp {
	public static void main(String[] args) {

		String s = "12:05:45AM";

		StringBuilder temp = new StringBuilder();
		int a = 0;
		int b = 0;
		int c = 0;
		if (s.charAt(s.length() - 2) == 'P') {
			a = Character.getNumericValue(s.charAt(0));
			b = Character.getNumericValue(s.charAt(1));

			temp.append(a);
			temp.append(b);
			System.out.println(temp);
			c = Integer.parseInt(temp.toString());

			if (c != 12) {
				c += 12;
			}
			System.out.println(c);
			temp.setLength(0);
			temp.append(String.valueOf(c));
			for (int i = 2; i < s.length() - 2; i++) {
				temp.append(s.charAt(i));
			}
			// AM
		} else {
			a = Character.getNumericValue(s.charAt(0));
			b = Character.getNumericValue(s.charAt(1));

			temp.append(a);
			temp.append(b);
			c = Integer.parseInt(temp.toString());
			temp.setLength(0);
			// special case
			if (c == 12) {
				c -= 12;
				temp.append('0');
				temp.append(String.valueOf(c));
				for (int i = 2; i < s.length() - 2; i++) {
					temp.append(s.charAt(i));

				}
			}else if(c <12) {
				temp.append('0');
				temp.append(String.valueOf(c));
				for (int i = 2; i < s.length() - 2; i++) {
					temp.append(s.charAt(i));

				}
			}

			

		}
		System.out.println(temp.toString());
	}

}
