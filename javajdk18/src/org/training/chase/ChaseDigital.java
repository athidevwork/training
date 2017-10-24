package org.training.chase;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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


public class ChaseDigital {
	public static void main(String[] args) {
		// ############TEST 1 ###################
		//System.out.println("Login complete at "+LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)+".");
		
		createAuditLog();
		
		/*try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		// ############TEST 2 ###################
		/*String[] titleArr = getMovieTitles("of");
		System.out.println(Arrays.asList(titleArr));*/
		
		String jsonResp = "{\"page\":1,\"per_page\":10,\"total\":375,\"total_pages\":38,\"data\":[{\"Poster\":\"N/A\",\"Title\":\"The Making of 'Waterworld'\",\"Type\":\"movie\",\"Year\":1995,\"imdbID\":\"tt2670548\"},{\"Poster\":\"N/A\",\"Title\":\"Waterworld 4: History of the Islands\",\"Type\":\"movie\",\"Year\":1997,\"imdbID\":\"tt0161077\"},{\"Poster\":\"N/A\",\"Title\":\"Behind the Scenes of the Most Fascinating Waterworld on Earth: The Great Backwaters, Kerala.\",\"Type\":\"movie\",\"Year\":2014,\"imdbID\":\"tt5847056\"},{\"Poster\":\"N/A\",\"Title\":\"Fighting, Flying and Driving: The Stunts of Spiderman 3\",\"Type\":\"movie\",\"Year\":2007,\"imdbID\":\"tt1132238\"},{\"Poster\":\"N/A\",\"Title\":\"The Death of Spiderman\",\"Type\":\"movie\",\"Year\":2015,\"imdbID\":\"tt5921428\"},{\"Poster\":\"https://images-na.ssl-images-amazon.com/images/M/MV5BN2Q0NjRiYTAtNDJiZC00ODgyLWI4NDMtYzRmYjY3MjZjMmQ0XkEyXkFqcGdeQXVyNTQzMjAxMzA@._V1_SX300.jpg\",\"Title\":\"The Superman/Aquaman Hour of Adventure\",\"Type\":\"series\",\"Year\":1967,\"imdbID\":\"tt0231046\"},{\"Poster\":\"N/A\",\"Title\":\"Aquaman: War of the Water Worlds\",\"Type\":\"game\",\"Year\":1996,\"imdbID\":\"tt1064720\"},{\"Poster\":\"N/A\",\"Title\":\"Aquaman: Sovereign of the Seas\",\"Type\":\"movie\",\"Year\":2007,\"imdbID\":\"tt1186634\"},{\"Poster\":\"N/A\",\"Title\":\"Judge Rummy's Off Day\",\"Type\":\"movie\",\"Year\":1918,\"imdbID\":\"tt0370820\"},{\"Poster\":\"N/A\",\"Title\":\"The Rummy Act of Omar K.M.\",\"Type\":\"movie\",\"Year\":1916,\"imdbID\":\"tt0496146\"}]}";       	
		String[] titles = returnMovieTitles(jsonResp);		
		System.out.println ("Sorted Movie Array : " + Arrays.toString(titles));
		System.out.println ("Array size = " + titles.length);
		
		// ############TEST 3 ###################
		String str ="aeiaaioooaauuaeiou";
       	char[] chars = { 'a', 'e', 'i', 'o', 'u' };
       	System.out.println("Longest Count = " + longestSubSequence(str, chars));	
       	
     // ############TEST 4 ###################
        int[] a = {4, 1, 2, 3}; 
        System.out.println("Max Diff : " +  maxDiff(a, a.length));
	}

	private static void createAuditLog() {
		ExecutorService pool = Executors.newFixedThreadPool(4); 
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
		pool.shutdown();
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
    
    static String[] getMovieTitles(String substr) {
        Gson gson = new Gson();

        //JsonObject jsonObj = element.getAsJsonObject();
     
        try {
        	//String sURL = "http://freegeoip.net/json/"; //just a string
        	//String sURL = "http://api.coindesk.com/v1/bpi/currentprice.json";
        	String sURL = "https://jsonmock.hackerrank.com/api/movies/search/?Title="+substr;

        	//String json = ClientBuilder.newClient().target(sURL).request().accept(MediaType.APPLICATION_JSON).get(String.class);
        	//System.out.println("json str = " + json);
        			
            // Connect to the URL using java's native library
            URL url = new URL(sURL);
            HttpsURLConnection request = (HttpsURLConnection) url.openConnection();
            request.connect();

            // Convert to a JSON object to print data
           JsonParser jp = new JsonParser(); //from gson
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); //Convert the input stream to a json element
            JsonObject rootobj = root.getAsJsonObject(); //May be an array, may be an object. 
            //zipcode = rootobj.get("zip_code").getAsString(); //just grab the zipcode
            System.out.println("json str = " + rootobj);
            
        	/*String json = readUrl("http://jsonmock.hackerrank.com/api/movies/search/?Title="+substr);
        	System.out.println("json str = " + json);

            URL url = new URL("http://jsonmock.hackerrank.com/api/movies/search/?Title="+substr);        	
        	InputStreamReader reader = new InputStreamReader(url.openStream());
            JsonElement element = gson.fromJson (reader, JsonElement.class);
            System.out.println(element);*/
            
            //JsonObject json = new JsonObject(readUrl("https://jsonmock.hackerrank.com/api/movies/search/?Title="+substr));

            //String title = (String) json.get("title");
            
            /*JsonParser parser = new JsonParser();
            JsonObject o = parser.parse(jsonStr).getAsJsonObject();
            JsonElement latLng = o.get("results")
                    .getAsJsonArray().get(0)
                    .getAsJsonObject().get("locations")
                    .getAsJsonArray().get(0)
                    .getAsJsonObject().get("latLng");*/

        } catch (Exception e) {
        	System.out.println("Exception during json processing");
            e.printStackTrace();
        }
        
        /*JsonParser parser = new JsonParser();

        JsonObject jsonObject = parser.parse(jsonString).getAsJsonObject();

        if (jsonObject != null && jsonObject.get("begin") != null) {

            Gson gson = new Gson();

            for (JsonElement mainObject : jsonObject.get("begin").getAsJsonArray()) {
                Main spot = gson.fromJson(mainObject.getAsJsonObject().get("begin"), Main.class);
                Main.setSpot(context,spot);
            }

        } else {
          // Server error exception...
        }*/
        
    	return null;	
    }
}
