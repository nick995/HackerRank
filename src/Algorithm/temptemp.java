package Algorithm;

public class temptemp {

	public static void main(String[] args) {
		int k = 84;

		int i = 98196;

		int value = 0;

		if (i <= k) {

			value = i + k;

			if ((int) Math.abs(value - i) == k) {
				System.out.println(value);
			}

		} else if (i > k) {

			value = i - k;

			if (Math.abs(i - value) == k) {
				System.out.println(i-k);
			}

		}

	}

}
