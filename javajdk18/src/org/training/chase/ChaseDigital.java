package org.training.chase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.Provider;
import java.security.Security;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

import javax.net.ssl.HttpsURLConnection;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

class StringTask implements Callable<String>{
	public StringTask() {
	}

	public String call(){
			Thread.currentThread().setName("Thread " + Thread.currentThread().getId());
			return Thread.currentThread().getName() + " : Login complete at "+LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)+".";
		};
}

class LogTask implements Runnable{
	public LogTask() {
	}

	public void run(){
			Thread.currentThread().setName("Thread " + Thread.currentThread().getId());
			System.out.println(Thread.currentThread().getName() + " : Login complete at "+LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)+".");
		};
}

public class ChaseDigital {
	public static void main(String[] args) {
		// ############TEST 1 ###################
		//System.out.println("Login complete at "+LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)+".");
		
		createAuditLog();
		
		System.out.println(String.join("", Collections.nCopies(20, "---***---")));
		
		// ############TEST 2 ###################
		/*String[] titleArr = getMovieTitles("of");
		System.out.println(Arrays.asList(titleArr));*/
		
		//https://jsonmock.hackerrank.com/api/movies/search/?Title=of
		String jsonResp = "{\"page\":1,\"per_page\":10,\"total\":375,\"total_pages\":38,\"data\":[{\"Poster\":\"N/A\",\"Title\":\"The Making of 'Waterworld'\",\"Type\":\"movie\",\"Year\":1995,\"imdbID\":\"tt2670548\"},{\"Poster\":\"N/A\",\"Title\":\"Waterworld 4: History of the Islands\",\"Type\":\"movie\",\"Year\":1997,\"imdbID\":\"tt0161077\"},{\"Poster\":\"N/A\",\"Title\":\"Behind the Scenes of the Most Fascinating Waterworld on Earth: The Great Backwaters, Kerala.\",\"Type\":\"movie\",\"Year\":2014,\"imdbID\":\"tt5847056\"},{\"Poster\":\"N/A\",\"Title\":\"Fighting, Flying and Driving: The Stunts of Spiderman 3\",\"Type\":\"movie\",\"Year\":2007,\"imdbID\":\"tt1132238\"},{\"Poster\":\"N/A\",\"Title\":\"The Death of Spiderman\",\"Type\":\"movie\",\"Year\":2015,\"imdbID\":\"tt5921428\"},{\"Poster\":\"https://images-na.ssl-images-amazon.com/images/M/MV5BN2Q0NjRiYTAtNDJiZC00ODgyLWI4NDMtYzRmYjY3MjZjMmQ0XkEyXkFqcGdeQXVyNTQzMjAxMzA@._V1_SX300.jpg\",\"Title\":\"The Superman/Aquaman Hour of Adventure\",\"Type\":\"series\",\"Year\":1967,\"imdbID\":\"tt0231046\"},{\"Poster\":\"N/A\",\"Title\":\"Aquaman: War of the Water Worlds\",\"Type\":\"game\",\"Year\":1996,\"imdbID\":\"tt1064720\"},{\"Poster\":\"N/A\",\"Title\":\"Aquaman: Sovereign of the Seas\",\"Type\":\"movie\",\"Year\":2007,\"imdbID\":\"tt1186634\"},{\"Poster\":\"N/A\",\"Title\":\"Judge Rummy's Off Day\",\"Type\":\"movie\",\"Year\":1918,\"imdbID\":\"tt0370820\"},{\"Poster\":\"N/A\",\"Title\":\"The Rummy Act of Omar K.M.\",\"Type\":\"movie\",\"Year\":1916,\"imdbID\":\"tt0496146\"}]}";       	
		String[] titles = returnMovieTitles(jsonResp);		
		System.out.println ("Sorted Movie Array : " + Arrays.toString(titles));
		System.out.println ("Array size = " + titles.length);
		
		//https://jsonmock.hackerrank.com/api/movies/search/?Title=of&page=2
		jsonResp = "{\"page\":\"2\",\"per_page\":10,\"total\":375,\"total_pages\":38,\"data\":[{\"Poster\":\"N/A\",\"Title\":\"Ivan Ironman Stewart's Super Off Road\",\"Type\":\"game\",\"Year\":1989,\"imdbID\":\"tt0162408\"},{\"Poster\":\"N/A\",\"Title\":\"Pushing the Limits: Diaries of an Ironman\",\"Type\":\"movie\",\"Year\":2009,\"imdbID\":\"tt1691336\"},{\"Poster\":\"http://ia.media-imdb.com/images/M/MV5BMmE3MzFhMzEtNDcxNS00ZTZjLWI1NjktMmEzNGYwNDhjMDJmXkEyXkFqcGdeQXVyNjYzNTAyOTc@._V1_SX300.jpg\",\"Title\":\"Ironman Suit Office Story\",\"Type\":\"movie\",\"Year\":2016,\"imdbID\":\"tt5724294\"},{\"Poster\":\"https://images-na.ssl-images-amazon.com/images/M/MV5BMTIwNDg4MjIyMV5BMl5BanBnXkFtZTcwNDEwMzkxMQ@@._V1_SX300.jpg\",\"Title\":\"Hercules in the Maze of the Minotaur\",\"Type\":\"movie\",\"Year\":1994,\"imdbID\":\"tt0110018\"},{\"Poster\":\"N/A\",\"Title\":\"Masters of the Maze\",\"Type\":\"series\",\"Year\":1994,\"imdbID\":\"tt0166448\"},{\"Poster\":\"https://images-na.ssl-images-amazon.com/images/M/MV5BYjk0MjVkOTMtOWMwZS00NzU3LWEyYmMtOGZjMzhlNzE5NjFhL2ltYWdlL2ltYWdlXkEyXkFqcGdeQXVyNzAzMTc2Mjc@._V1_SX300.jpg\",\"Title\":\"The Beginning of Mind Maze\",\"Type\":\"movie\",\"Year\":2016,\"imdbID\":\"tt6327294\"},{\"Poster\":\"N/A\",\"Title\":\"Street of Dreams - Musical Mirror Maze\",\"Type\":\"movie\",\"Year\":1997,\"imdbID\":\"tt0202601\"},{\"Poster\":\"N/A\",\"Title\":\"Bionicle: Maze of Shadows\",\"Type\":\"game\",\"Year\":2005,\"imdbID\":\"tt3595020\"},{\"Poster\":\"N/A\",\"Title\":\"A Sense of a Maze\",\"Type\":\"movie\",\"Year\":2011,\"imdbID\":\"tt3786032\"},{\"Poster\":\"N/A\",\"Title\":\"War of the Bugs or Monsterous Manouvers in a Mushroom Maze\",\"Type\":\"game\",\"Year\":1981,\"imdbID\":\"tt2127390\"}]}";
		titles = returnMovieTitles(jsonResp);		
		System.out.println ("Page 2 Sorted Movie Array : " + Arrays.toString(titles));
		System.out.println ("Page 2 Array size = " + titles.length);
		
		//https://jsonmock.hackerrank.com/api/movies/search/?Title=of&page=38
		jsonResp = "{\"page\":\"38\",\"per_page\":10,\"total\":375,\"total_pages\":38,\"data\":[{\"Poster\":\"N/A\",\"Title\":\"Walk of No Shame\",\"Type\":\"movie\",\"Year\":2015,\"imdbID\":\"tt5128008\"},{\"Poster\":\"N/A\",\"Title\":\"The Walk: Pillars of Support\",\"Type\":\"movie\",\"Year\":2016,\"imdbID\":\"tt5500846\"},{\"Poster\":\"N/A\",\"Title\":\"Walk of Shame\",\"Type\":\"movie\",\"Year\":2013,\"imdbID\":\"tt5553288\"},{\"Poster\":\"N/A\",\"Title\":\"Jo Brand's Hell of a Walk\",\"Type\":\"movie\",\"Year\":2016,\"imdbID\":\"tt5563702\"},{\"Poster\":\"N/A\",\"Title\":\"David Ortiz: The Last Walk Off\",\"Type\":\"series\",\"Year\":2016,\"imdbID\":\"tt5567294\"}]}";
		titles = returnMovieTitles(jsonResp);		
		System.out.println ("Page 38 Sorted Movie Array : " + Arrays.toString(titles));
		System.out.println ("Page 38 Array size = " + titles.length);
		
		System.out.println(String.join("", Collections.nCopies(20, "---***---")));
		
		// ############TEST 3 ###################
		String str ="aeiaaioooaauuaeiou";
       	char[] chars = { 'a', 'e', 'i', 'o', 'u' };
       	System.out.println("Longest Count = " + longestSubSequence(str, chars));	
       	System.out.println(String.join("", Collections.nCopies(20, "---***---")));
     // ############TEST 4 ###################
        int[] a = {4, 1, 2, 3}; 
        System.out.println("Max Diff : " +  maxDiff(a, a.length));
        System.out.println(String.join("", Collections.nCopies(20, "---***---")));
	}

	private static void createAuditLog() {
		System.out.println("Creating a Runnable...");
        Runnable runnable = () -> {
        	System.out.println(String.join("", Collections.nCopies(20, "====")));
            //System.out.println("Executing first task inside : " + Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getName() + " : Login complete at "+LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)+".");
        };

        System.out.println("Submit first task specified by the runnable to the executor service.");
        
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		executorService.submit(runnable);
		
		System.out.println("Creating another Runnable...");
        Runnable runnable2 = () -> {
        	System.out.println(String.join("", Collections.nCopies(30, "++++")));
            System.out.println("Executing second task inside : " + Thread.currentThread().getName());
        };

        System.out.println("Submitting second task runnable.");
        executorService.submit(runnable2);
        
		executorService.shutdown();
		
		/*ExecutorService pool = Executors.newFixedThreadPool(4); 
		List<Future<String>> futures =new ArrayList<Future<String>>(1);
		for(int i = 0; i < 1; i++) {
			System.out.println("Submitting task " + i);
			futures.add(pool.submit(new StringTask()));
		};

		//Compute the result} 
		for(Future<String> future : futures){
			try {
				String result = future.get();
				System.out.println(result);
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		pool.shutdown();*/
	}

	static int maxDiff (int arr[], int n)
	{
	    // Initialize diff, current sum and max sum
	    int diff = arr[1]-arr[0];
	    int curr_sum = diff;
	    int max_sum = curr_sum;
	 
	    for(int i=1; i<n-1; i++)
	    {
	        // Calculate current diff
	        diff = arr[i+1]-arr[i];
	 
	        // Calculate current sum
	        if (curr_sum > 0)
	           curr_sum += diff;
	        else
	           curr_sum = diff;
	 
	        // Update max sum, if needed
	        if (curr_sum > max_sum)
	           max_sum = curr_sum;
	    }
	 
	    return max_sum;
	}
	
	static int longestSubSequence(String s, char[] c) {

	    //exit condition
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
	        return longestSubSequence(s.substring(1), c);
	    } else if (s.charAt(0) == c[0]) {

	        return Math.max(Math.max(
	                (1 + longestSubSequence(s.substring(1),
	                        Arrays.copyOfRange(c, 1, c.length))),
	                (1 + longestSubSequence(s.substring(1), c))),
	                (longestSubSequence(s.substring(1), c)));
	    } else {
	        return longestSubSequence(s.substring(1), c);
	    }
	}

	private static String readUrl(String urlString) throws Exception {
	    BufferedReader reader = null;
	    try {
	        URL url = new URL(urlString);
	        reader = new BufferedReader(new InputStreamReader(url.openStream()));
	        StringBuffer buffer = new StringBuffer();
	        int read;
	        char[] chars = new char[1024];
	        while ((read = reader.read(chars)) != -1)
	            buffer.append(chars, 0, read); 

	        return buffer.toString();
	    } finally {
	        if (reader != null)
	            reader.close();
	    }
	}
	
    static String[] returnMovieTitles(String jsonStr) {
    	List<String> titlesList = new ArrayList<String>();
    	
    	JsonParser parser = new JsonParser();
        JsonObject o = parser.parse(jsonStr).getAsJsonObject();
        /*JsonElement title = o.get("data")
                .getAsJsonArray().get(0)
                .getAsJsonObject().get("Title");
        System.out.println("Title = " + title);*/
        
        JsonArray titleJsonArr =  o.get("data")
                .getAsJsonArray();
        titleJsonArr.forEach(i ->
		{
			//System.out.println("data : " + i);
			JsonElement title = i.getAsJsonObject().get("Title");
			//System.out.println("Title = " + title);
			
			titlesList.add(title.getAsString());
			
			/*if("E".equals(k)){
				System.out.println("Hello E");
			}*/
		});
        
        System.out.println("Read List = " + titlesList);
        java.util.Collections.sort(titlesList);
        
        String[] titlesArr = new String[titlesList.size()];
        titlesArr = titlesList.toArray(titlesArr);
        
        return titlesArr;
    }
    
    static String[] getMovieTitles(String searchStr) {
    	String[] titlesArr = null;
    			
    	System.setProperty("java.protocol.handler.pkgs",
    	        "com.sun.net.ssl.internal.www.protocol");
    	Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
    	
        try
        {
        //if we have the JSSE provider available, 
        //and it has not already been
        //set, add it as a new provide to the Security class.
        Class clsFactory = Class.forName("com.sun.net.ssl.internal.ssl.Provider");
        if( (null != clsFactory) && (null == Security.getProvider("SunJSSE")) )
            Security.addProvider((Provider)clsFactory.newInstance());
        }
        catch( ClassNotFoundException cfe )
        {
          try 	{
			throw new Exception("Unable to load the JSSE SSL stream handler." +  
			    "Check classpath."  + cfe.toString());
          } catch (Exception e) {
			e.printStackTrace();
          }
        } catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
    	   
        URL url = null;
        JsonParser jp = new JsonParser();
		
    	try {
			url = new URL("https://jsonmock.hackerrank.com/api/movies/search/?Title=of");			
			JsonObject rootObj = getResponse(url, jp);
			
            int totalPages = rootObj.get("total_pages").getAsInt();
        	Set<String> titlesSet = new HashSet<String>();
        	
            for (int i = 1; i <= totalPages; i++) {
            	url = new URL("https://jsonmock.hackerrank.com/api/movies/search/?Title="+searchStr+"&page="+i);
            	rootObj = getResponse(url, jp);
                
                JsonArray titleJsonArr =  rootObj.get("data").getAsJsonArray();
                titleJsonArr.forEach(j ->
        		{
        			//System.out.println("data : " + i);
        			JsonElement title = j.getAsJsonObject().get("Title");
        			//System.out.println("Title = " + title);        			
        			titlesSet.add(title.getAsString());
        		});
                
                System.out.println("List for Page " + i + " = " + titlesSet);              
            }
            List<String> titlesList = new ArrayList<String>(titlesSet);
            java.util.Collections.sort(titlesList);
            
            titlesArr = new String[titlesList.size()];
            titlesArr = titlesList.toArray(titlesArr);            
		} catch (Exception e) {
			System.out.println("Exception : " + e);
			e.printStackTrace();
		}
    	return titlesArr;	
    }

	private static JsonObject getResponse(URL url, JsonParser jp) throws IOException {
		URLConnection con;
		con = url.openConnection();
		JsonElement jsonElement = jp.parse(new InputStreamReader(con.getInputStream()));
		JsonObject rootObj = jsonElement.getAsJsonObject(); //May be an array, may be an object. 
		System.out.println("first str = " + rootObj);
		return rootObj;
	}
}
