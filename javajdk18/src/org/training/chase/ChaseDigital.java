package org.training.chase;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

import javax.net.ssl.HttpsURLConnection;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ChaseDigital {
	public static void main(String[] args) {
		//LocalDateTime lt = LocalDateTime.now();
		//String asIsoDateTime = lt.format(DateTimeFormatter.ISO_DATE_TIME);
		System.out.println("Login complete at "+LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)+".");
		
		//String titles = "";
		
		String[] titleArr = getMovieTitles("of");
		System.out.println(Arrays.asList(titleArr));
       	
		String str ="aeiaaioooaauuaeiou";
       	char[] chars = { 'a', 'e', 'i', 'o', 'u' };
       	System.out.println("Longest Count = " + longestSubSequence(str, chars));	
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
