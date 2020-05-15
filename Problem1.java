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
		
		System.out.println("Enter size of the array: ");     //size of array
		n = sc.nextInt();
		
		System.out.println("Enter Array elements: ");        //enter data in array
		List<Integer> l = new ArrayList<Integer>();
		for(int q=0;q<n;q++)
			l.add(sc.nextInt());
	
		System.out.println("Enter a no. from the list: ");    //no. x whose occurances to be added at the last
		int x = sc.nextInt();
		int count =(int) l.stream()							  // getting count of x in list l
					.filter(e -> e==x)
					.count();
		
		l.removeIf(e->e==x);                                 // removing x from previous positions
		
		while(count-->0)									//adding at last; occurances of x
			l.add(x);
		
		System.out.println(l);
		
			
	}

}
