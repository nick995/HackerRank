package Algorithm;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class practice {
	public static void main(String[] args) {

		
		
		List<Integer> ranked = new ArrayList<Integer>();
		List<Integer> player = new ArrayList<Integer>();


		ranked.add(100);
		ranked.add(100);
		ranked.add(50);
		ranked.add(40);
		ranked.add(40);
		ranked.add(20);
		ranked.add(10);

		player.add(5);
		player.add(25);
		player.add(50);
		player.add(120);
		
		//==============================================
		ArrayList<Integer> answer = new ArrayList<Integer>();

		
		List<Integer> temp = ranked.stream().distinct().collect(Collectors.toList());
				
		Collections.sort(temp);
		
		int stopTemp = 0;
		
		int max = temp.get(temp.size()-1);
		for (int i = 0; i < player.size(); i++) {
			for (int j = stopTemp; j < temp.size(); j++) {
				if (player.get(i) < temp.get(j)) {
					answer.add(temp.size() - j + 1);
					stopTemp = j;
					break;
				}else if(j >= temp.size()-1) {
					answer.add(1);
				}
				
				

			}

		}
		
		System.out.println(answer);

	}
}
