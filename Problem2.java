package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Problem2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		System.out.println("Enter size:");
		int n = Integer.parseInt(br.readLine());		
		Map<String,List<String>> orderList = new HashMap<String,List<String>>();
		String k;
		List<String> v;
		List<String> items = new ArrayList<>();
		for(int i=0;i<n;i++) {
			v= new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine()," ");		
			k = st.nextToken();		
			while(st.hasMoreTokens()) {
				String x = st.nextToken();
				v.add(x);		
				items.add(x);
			}	
			orderList.put(k, v);
		}
		
		Map<String,List<String>> itemsList = new HashMap<String,List<String>>();
		for(String i:items.stream().collect(Collectors.toSet())) {
			v= new ArrayList<>();
			for(Entry<String,List<String>> e : orderList.entrySet()) {
				if(e.getValue().contains(i))
					v.add(e.getKey());
			}
			itemsList.put(i,v);	
		}
		
		Set<Entry<String, Long>> count= items.stream()
									.collect(Collectors.groupingBy(e->e,Collectors.counting()))
									.entrySet();
		String max1 = count.stream()
				.max(Comparator.comparing(Entry::getValue))
				.get()
				.getKey();
		count.removeIf(entry -> entry.getKey() == max1);	
		String max2 = count.stream()
				.max(Comparator.comparing(Entry::getValue))
				.get()
				.getKey();

		System.out.println(max1 +" -> usageCount: " +itemsList.get(max1).size()+ ";corresponding orders: " + itemsList.get(max1));
		System.out.println(max2 +" -> usageCount: " +itemsList.get(max2).size()+ ";corresponding orders: " + itemsList.get(max2));
	}

}
