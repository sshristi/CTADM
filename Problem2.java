package problems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collectors;

class Order{
	private static int count = 1;
	private List<String> items;
	private int orderNo = count;
	public Order(List<String> items) {
		super();
		count++;
		this.items = items;
	}

	public List<String> getItems() {
		return items;
	}

	public void setItems(List<String> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Order-" + orderNo;
	}
	
}

public class Problem2{
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		List<Order> l = new ArrayList<>();
		Order order;
		List<String> list;
		String ch;
		do{
			System.out.println("no. of items: ");
			int n = sc.nextInt();
			list = new ArrayList<>();
			while(n-->0) {
				list.add(sc.next());
			}
			order = new Order(list);
			l.add(order);
			System.out.println("want to give order: y/n?");
			ch = sc.next();
		}
		while(ch.equals("y"));
		
		List<String> items = new ArrayList<>();
		l.forEach(e -> e.getItems().forEach(i -> items.add(i)));
		
		Map<String,Long> map = items.stream()
						.collect(Collectors.groupingBy(e -> e, Collectors.counting()));
		
		String max1 = map.entrySet().stream()
				  .max(Comparator.comparing(Entry::getValue)).get().getKey();
		List<String> max1Orders = new ArrayList<>();
		l.forEach(e ->{if(e.getItems().contains(max1)) max1Orders.add(e.toString());});
		System.out.println(max1 +" -> usageCount: " +map.get(max1)+";corresponding orders: " + max1Orders);
		
		map.entrySet().removeIf(entry -> entry.getKey() == max1);
		
		String max2 = map.entrySet().stream() 
				.max(Comparator.comparing(Entry::getValue)).get().getKey();
		List<String> max2Orders = new ArrayList<>();
		l.forEach(e ->{if(e.getItems().contains(max2)) max2Orders.add(e.toString());});
		System.out.println(max2+" -> usageCount: " +map.get(max2)+ ";corresponding orders: " + max2Orders);
	
	}
	
}
