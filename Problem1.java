package problems;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Problem1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=0;
		System.out.println("Enter size of the array: ");
		n = sc.nextInt();
		System.out.println("Enter Array elements: ");
		List<Integer> l = new ArrayList<Integer>();
		for(int q=0;q<n;q++)
			l.add(sc.nextInt());
		Map<Integer, Integer> map = l.parallelStream()
					.collect(Collectors.toConcurrentMap(w -> w, w -> 1, Integer :: sum))
					.entrySet()
					.stream()
					.sorted(Map.Entry.comparingByValue())
					.collect(Collectors.toMap(Map.Entry::getKey,
				               Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		l.clear();
		map.forEach((k,v) ->{
			while(v-->0) {
				l.add(k);
			} 
		} );
		
		
		System.out.println(l);
		
			
	}

}
