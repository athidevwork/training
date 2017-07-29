package org.training;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

interface Phone {
	default void print(String str) {
		if (!isNull(str))
			System.out.println("Phone Print::" + str);
	}
	static boolean isNull(String str) {
		System.out.println("Interface Null Check");

		return str == null ? true : "".equals(str) ? true : false;
	}
	default void call() {
		System.out.println("Using Calling Feature");
	}
	void message();
}

class iPhone implements Phone {

	@Override
	public void message() {
		System.out.println("IMessage");	
	}
	
}

class Android implements Phone {

	@Override
	public void message() {
		System.out.println("Message");	
	}
	
}
public class JDK8Training {

	public static void main(String[] args) {
		jdk18(); 
	}


	private static void jdk18() {
		System.out.println("Default / Static on interface");
		Phone iPhone = new iPhone();
		iPhone.call();
		iPhone.message();
		iPhone.print("");
		Phone android = new Android();
		android.call();
		android.message();
		android.print("abc");
		
		IntStream.rangeClosed(1, 30).forEach($ -> System.out.print("*"));
		System.out.println();
		
		System.out.println("Lamda foreach for list");
		List<Integer> listInt = Arrays.asList(1,2,3,4,5,6,7,8,9);
		listInt.forEach(i -> System.out.print(i)); //lambda expression for consumer interface
		System.out.println();
		listInt.forEach(System.out::println); //method reference
		
		IntStream.rangeClosed(1, 30).forEach($ -> System.out.print("*"));
		System.out.println();
		
		System.out.println("Lamda foreach for map");
		Map<String, Integer> items = new HashMap<>();
		items.put("A", 10);
		items.put("B", 20);
		items.put("C", 30);
		items.put("D", 40);
		items.put("E", 50);
		items.put("F", 60);
		
		items.forEach((k,v)->System.out.println("Item : " + k + ", Count : " + v));
		items.forEach((k,v)->
			{
				System.out.println("Item : " + k + ", Count : " + v);
				if("E".equals(k)){
					System.out.println("Hello E");
				}
			});
		
		IntStream.rangeClosed(1, 30).forEach($ -> System.out.print("*"));
		System.out.println();
		
		System.out.println("Lamda with stream");
		listInt.stream().forEach(System.out::print); //method reference
		System.out.println();
		IntStream.rangeClosed(1, 30).forEach($ -> System.out.print("*"));
		System.out.println();
		
		System.out.println("Date time package");
		ZoneId.getAvailableZoneIds().stream().sorted().forEach(System.out::println);
		ZoneId.getAvailableZoneIds().stream().sorted().forEach(s -> 
				{
					LocalTime t1 = LocalTime.now(ZoneId.of(s));
					System.out.println(s + " = " + t1);
				});
		
		IntStream.rangeClosed(1, 30).forEach($ -> System.out.print("*"));
		System.out.println();
		System.out.println("Method Reference");
		
		/**
		* Given two lists of integers, &#39;add&#39; them together, producing a new list containing the sum.
		* For example list1 represents the number 123, list2 is 456, and the sum is 579.
		* list1: 1 -> 2 -> 3
		* list2: 4 -> 5 -> 6
		*/
		List<Integer> a = Arrays.asList(1,2,3);
		List<Integer> b = Arrays.asList(4,5,6);	
		
		List<Integer> result = IntStream.range(0, a.size())
		         						.mapToObj(i -> a.get(i) + b.get(i))
		         						.collect(Collectors.toList());
		result.stream().forEach(item -> System.out.print(item + "->"));
		System.out.println("\n");
		
		/*a = Arrays.asList(1,2,3,4);
		b = Arrays.asList(5,6,7,8);	
		
		result = IntStream.range(0, a.size())
		         			.mapToObj(i -> a.get(i) + b.get(i))
		         			.collect(Collectors.toList());
		result.stream().forEach(item -> System.out.print(item + "->"));
		System.out.println("\n");*/
		
		/*Path sourcePath = Paths.get("C:/Users/source.txt");
		Path changedPath = Paths.get("C:/Users/removedDouplicate_file.txt");
		      try (final Stream<String> lines = Files.lines(sourcePath)
		               // .map(line -> line.toLowerCase()) //optional to use existing string methods
		                .distinct()
		               // .sorted())  //aggregrate function to sort  disctincted line
		       {
		            final String uniqueWords = lines.collect(joining("\n"));
		            System.out.println("Final Output:" + uniqueWords);
		            Files.write(changedPath , uniqueWords.getBytes(),WRITE, TRUNCATE_EXISTING);
		        }
		}*/
	}
}
