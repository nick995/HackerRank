package Algorithm;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class practice {
	public static void main(String[] args) {
		
		BigInteger temp = new BigInteger("1");

		for(int i=1; i<10; i++) {
			
			temp = temp.multiply(BigInteger.valueOf(i));
			
			System.out.println(temp);
			
		}

	}
}
