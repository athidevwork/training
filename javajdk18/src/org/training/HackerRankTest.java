package org.training;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class HackerRankTest {
	public static void main(String[] args) {
		int[] array = {2,3,4};
		System.out.println(findNumber(array, 1));
		System.out.println(findNumber(array, 4));
		System.out.println(oddNumbers(1, 9));
		System.out.println(oddNumbers(3, 5));
		
		String[] braces = {"{}[]()", "{[}]"};
		String[] answer = isBracesMatched(braces);
		for (int i=0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
		
		int[] numbers = {1,3,1,4,5,6,3,2};
		System.out.println(countDuplicates(numbers));
	}
	
	static int countDuplicates(int[] numbers) {
		int duplicateCount = 0;
		HashSet<Integer> numberSet = new HashSet<Integer>();
		for (int i=0; i < numbers.length; i++) {
			int number = numbers[i];
			
			if (numberSet.contains(number)) {
				System.out.println("number =" + number);
				duplicateCount++;
			}
			if (!numberSet.contains(number))
				numberSet.add(i);
		}
		return duplicateCount;
    }
	
    private static String[] isBracesMatched(String[] braces) {
    	String[] result = new String[braces.length];
    	
		Map<Character, Character> openClosePair = new HashMap<Character, Character>();
	    openClosePair.put('(', ')');
	    openClosePair.put('{', '}');
	    openClosePair.put('[', ']'); 
	    
    	for (int i=0; i < braces.length; i++) {
    		String str = braces[i];
    		System.out.println(str);

    	    boolean returnResult = false;
    	    Stack<Character> stack = new Stack<Character>();
    	    for (int j = 0; j < str.length(); j++) {
    	        if (openClosePair.containsKey(str.charAt(j))) {
    	            stack.push(str.charAt(j));
    	        } else if (openClosePair.containsValue(str.charAt(j))) {
    	        	System.out.print(str.charAt(j) + ", ");
    	            if (stack.isEmpty())
    	            	returnResult = false;
    	            if (openClosePair.get(stack.pop()) != str.charAt(j))
    	            	returnResult = false;
    	            /*System.out.print("popped =" + openClosePair.get(stack.pop()) + " = ");
    	            System.out.print(str.charAt(j));*/
    	        }
    	        // ignore all other characters
        	    //returnResult = true;
        	    
        	    //System.out.println("i = " + i);
        	    if (returnResult == false)
        	    	result[i] = "NO";
        	    else
        	    	result[i] = "YES";
        	    System.out.println();
    	    }
    	}
    	return result;
	}


	static String findNumber(int[] arr, int k) {
        for (int i=0; i < arr.length; i++) {
            if (k == arr[i])
                return "YES";
        }
        return "NO";
    }
    
    static int[] oddNumbers(int l, int r) {
    	List<Integer> oddList = new ArrayList<Integer>();
    	
        int j=0;
        for (int i = l; i <= r; i++) {
            if (i % 2 != 0)
            	oddList.add(i);
        }
        int[] arr = oddList.stream().mapToInt(i -> i).toArray();
        return arr;
    }
}
