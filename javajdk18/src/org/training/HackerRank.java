/**
 * 
 */
package org.training;

import java.awt.List;
import java.util.Scanner;

/**
 * @author Athi
 *
 */
public class HackerRank {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//general();
		//getArea();
		//getNonNeg();
		//getStdinStdout();
		test1();
		//compareStrings();
	}

	/*public static void compareStrings(StringSupplier supplier1, StringSupplier supplier2, List<Boolean> results) {
        try {
            while (true) {
                String string1 = supplier1.getNext();
                String string2 = supplier2.getNext();
                
                if (string1 != null && string2 != null) {
	                if (string1 == string2) {
	                    results.add(true);
	                } else {
	                    results.add(false);
	                }
                } else {
                	if (string1 == null && string2 == null)
                		results.add(true);
                	else
                		results.add(false);
                }
            }
        } catch (Exception e) {
        	if (results.size() == 0)
        		results.add(false);
        }		
	}*/

	private static void test1() {
		//3
		//5
		//23
		//answer - 13 23
        Scanner scan = new Scanner(System.in);
        int digit = scan.nextInt();
		int start = scan.nextInt();
		int end = scan.nextInt();
		
		StringBuilder numberList = new StringBuilder();
		for (int i = start; i <= end; i++) {
			if (i % 10 == digit) {
				numberList.append(i);
                if (i != end)
                    numberList.append(" ");
            }   
		}
		if (numberList.length() == 0) {
			numberList.append("");
		}
		System.out.println(numberList.toString());
        //return numberList.toString();
	}

	private static void getStdinStdout() {
		//Test
		//42
		//3.1415
		//Welcome to HackerRank's Java tutorials!
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        double d = scan.nextDouble();  
        scan.nextLine();
        String s = scan.nextLine();

        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);
        scan.close();		
	}

	private static void getNonNeg() {
		Scanner scan = new Scanner(System.in);
        int first = scan.nextInt();
        int second = scan.nextInt();
        
        String firsts = String.valueOf(first);
        String seconds = String.valueOf(second);
        
        System.out.println(firsts + ", " + seconds);
	}
	
	private static void getArea() {
		Scanner scan = new Scanner(System.in);
        int first = scan.nextInt();
        int second = scan.nextInt();
        
        if (first <= 0 || second <= 0) {
        	System.out.println("java.lang.Exception: Breadth and height must be positive");
        	return;
        }
		
        System.out.println(first * second);
	}

	private static void general() {
		Scanner scan = new Scanner(System.in);
        System.out.print("Enter 1st number : "); 
        int first = scan.nextInt();
        System.out.print("Enter 2nd number : "); 
        int second = scan.nextInt();
        System.out.print("Enter 3rd number : "); 
        int third = scan.nextInt();        

        System.out.println(first);
        System.out.println(second);
        System.out.println(third);
        scan.close();
        
        //if else
        Scanner sc = new Scanner(System.in);       
        System.out.print("Enter Number : ");
        int number = sc.nextInt(); 

        while (number!=0){
            System.out.print("Enter number : ");
            number = sc.nextInt();
            if (number % 2 != 0) {
            	System.out.println("Weird");
            }
            else if ((number % 2 == 0) && (number <=2 || number >= 5)) {
            	System.out.println("Not Weird");
            }
            else if ((number % 2 == 0) && (number >=6 || number <= 20)) {
            	System.out.println("Weird");
            }
            else if ((number % 2 == 0) && number > 20) {
            	System.out.println("Not Weird");
            }
            else {
            	System.out.println("Weird");
            }         
        }
        sc.close();   
        /*for (int i=0; i < 4; i++) {
    		scan = new Scanner(System.in);
            System.out.print("Enter number : "); 
            int number = scan.nextInt();

            if (number % 2 != 0) {
            	System.out.println("Weird");
            }
            else if ((number % 2 == 0) && (number <=2 || number >= 5)) {
            	System.out.println("Not Weird");
            }
            else if ((number % 2 == 0) && (number >=6 || number <= 20)) {
            	System.out.println("Weird");
            }
            else if ((number % 2 == 0) && number > 20) {
            	System.out.println("Not Weird");
            }
            else {
            	System.out.println("Weird");
            }
            scan.close();
        }*/
	}
	
}
