package org.training.chase;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class ChaseDigital {
	static final AtomicInteger w = new AtomicInteger();
	
	public static void main(String[] args) {
		//LocalDateTime lt = LocalDateTime.now();
		//String asIsoDateTime = lt.format(DateTimeFormatter.ISO_DATE_TIME);
		System.out.println("Login complete at "+LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)+".");
		
		//String titles = "";
		
		//String[] titleArr = getMovieTitles(titles);
		//System.out.println(Arrays.asList(titleArr));
		
		/*String input = "aeiaaioooaauuaeiou";
        HashSet<String> vowels = new HashSet<String>(Arrays.asList("a", "e", "i", "o", "u"));
        
        int count = 0;
    	String prev = null, curr = null;
    	
    	String[] inputArr = input.split(""); 
    	System.out.println("arr length=" + inputArr.length);
    	for (int i = 0; i < inputArr.length; i++) {
	        for (String vowel : vowels) {
	        	 curr=inputArr[i];
	        	 System.out.print("Curr="+curr);
	             if (curr.equalsIgnoreCase(prev) && vowel.equalsIgnoreCase(curr)) {  
	            	 count++;
	             }
	             prev = inputArr[i];
	             System.out.print(", Prev="+curr);
	             System.out.println();
	        }
	        System.out.println("Count =" + count);
    	}
    	System.out.println("Count =" + count);
    	
    	
        //Pattern p = Pattern.compile("([aAeEiIoOuU])\\1{0,}");
        Pattern p = Pattern.compile("[aAeEiIoOuU]+");

        Matcher m =p.matcher(str) ;
        while (m.find()) {
            System.out.println(m.group());
        }
       	System.out.println(m.groupCount());*/
       	
		String str ="aeiaaioooaauuaeiou";
       	char[] chars = { 'a', 'e', 'i', 'o', 'u' };
       	System.out.println("Longest Count = " + longestMegicalSubsequence(str, chars));	
	}

	static int longestMegicalSubsequence(String s, char[] c) {

	    // exit conditions
	    if (s.length() == 0 || c.length == 0) {
	        return 0;
	    }

	    if (s.length() < c.length) {
	        return 0;
	    }

	    if (s.length() == c.length) {
	        for (int i = 0; i < s.length(); i++) {
	            if (s.charAt(i) != c[i]) {
	                return 0;
	            }
	        }
	        return s.length();
	    }

	    if (s.charAt(0) < c[0]) {
	        // ignore, go ahead with next item
	        return longestMegicalSubsequence(s.substring(1), c);
	    } else if (s.charAt(0) == c[0]) {

	        return Math.max(Math.max(
	                (1 + longestMegicalSubsequence(s.substring(1),
	                        Arrays.copyOfRange(c, 1, c.length))),
	                (1 + longestMegicalSubsequence(s.substring(1), c))),
	                (longestMegicalSubsequence(s.substring(1), c)));
	    } else {
	        return longestMegicalSubsequence(s.substring(1), c);
	    }
	}

/*    static String[] getMovieTitles(String substr) {
        Gson gson = new Gson();
        JsonElement element = gson.fromJson (request.getContent(), JsonElement.class);
        JsonObject jsonObj = element.getAsJsonObject();
        URL url = new URL("https://jsonmock.hackerrank.com/api/movies/search/?Title="+substr);

    	return null;	
    }*/
}
