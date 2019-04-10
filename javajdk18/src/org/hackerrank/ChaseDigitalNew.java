/**
 * 
 */
package org.hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/* 
 * create an anonymous class that implements a comparator for
 * the Contact data structure aand set it to contactComparator, 
 * which has already been declared as a field in this class.
 * 
 *  eg: 
 *      contactComparator = new ...
 */
class contactComparator implements Comparator<Contact>{
    public int compare(Contact s1, Contact s2) {
        long l1 = s1.getNationalId();
        long l2 = s2.getNationalId();
        return Long.valueOf(l1).compareTo(Long.valueOf(l2));
    }
}

/*
 * create an anonymous class that implements ContactsStore 
 * and set it to inMemoryStore, which has already been declared
 * as a field in this class.
 * 
 *  eg: 
 *      inMemoryStore = new ...
 */
class inMemoryStore implements ContactsStore {
    List<Contact> contacts = new ArrayList<Contact>();

    void command(String command, Contact data) {
        switch (command) {
            case "ADD":
                contacts.add(data);
                break;
            case "UPDATE":
                contacts.stream().filter(i -> data.getNationalId() == i).collect(Collectors.toList());
                break;
            case "DELETE":
                contacts.stream().filter(i -> data.getNationalId() == i).forEach(contacts::remove);
                break;
            default:
                System.out.print(command + " - Not supported");
        }
    }

    List<Contact> find(String partialName) {
        List<Contact> filteredContacts = contacts.stream().filter(i -> partialName.equals(i)).collect(Collectors.toList());
        return filteredContacts;
    }

    List<Contact> all() {
        return contacts;
    }
}

/**
 * @author athi
 *
 */
abstract class Animal {
	protected boolean isMammal;
	protected boolean isCarnivorous;
	
	public Animal(boolean isMammal, boolean isCarnivorous) {
		this.isMammal = isMammal;
		this.isCarnivorous = isCarnivorous;
	}
	
	public boolean getIsMammal() {
		return this.isMammal;
	}
	
	public boolean getIsCarnivorous() {
		return this.isCarnivorous;
	}
	
	abstract public String getGreeting();
	
	public void printAnimal(String name) {
		System.out.println("A " + name + " says '" + this.getGreeting() + "', is " + (this.getIsCarnivorous() ? "" : "not ")
				+ "carnivorous, and is " + (this.getIsMammal() ? "" : "not ") + "a mammal.");
	}
}

class Dog extends Animal{
	public Dog() {
		super(true, true);
	}
	
	public String getGreeting() {
		return "ruff";
	}
}

class Cow extends Animal{
	public Cow() {
		super(true, false);
	}
	
	public String getGreeting() {
		return "moo";
	}
}

class Duck extends Animal{
	public Duck() {
		super(false, false);
	}
	
	public String getGreeting() {
		return "quack";
	}
}

class WriteLog implements Runnable { 

	public WriteLog() { 
	} 
	
	@Override public void run() { 
		try { 
			//call logging code 
			testLog();
		} catch (InterruptedException ex) { 
			//Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex); 
		} 
	}

	private void testLog() {
		// TODO Auto-generated method stub
		
	} 
} 

public class ChaseDigitalNew {
	public static void main(String[] args) {
		inheritanceHeirarchy();
		
		String[] stringArr = getMovieTitles("spiderman");
		System.out.println(stringArr);
		
		WriteAuditLog("Test", "athi");
		
		int arr[] = {80, 2, 6, 3, 100};
		int n = arr.length;  
		System.out.print("Maximum difference is " +  maxDiff(arr, n));  
		
		contactStore();
	}

	private static void contactStore() {

	}

	private static int maxDiff(int[] arr, int n) {
	    // Initialize diff, currentSum and maxSum  
	    int diff = arr[1] - arr[0];  
	    int currentSum = diff;  
	    int maxSum = currentSum;  
	  
	    for(int i = 1; i < n - 2; i++)  
	    {  
	        // Calculate current diff  
	        diff = arr[i + 1] - arr[i];  
	  
	        // Calculate current sum  
	        if (currentSum > 0)  
	        	currentSum += diff;  
	        else
	        	currentSum = diff;  
	  
	        // Update max sum, if needed  
	        if (currentSum > maxSum)  
	        maxSum = currentSum;  
	    }  
	  
	    return maxSum; 
	}

	private static void WriteAuditLog(String string, String string2) {
		final ExecutorService threadpool = Executors.newFixedThreadPool(3);
		Future<?> future = null;
		WriteLog task = new WriteLog(); 
		System.out.println("Submitting Task ..."); 
		future = threadpool.submit(task); 
		System.out.println("Task is submitted"); 
		while (!future.isDone()) { 
			System.out.println("Task is not completed yet...."); 
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} //sleep for 1 mill	isecond before checking again 
		} 
		System.out.println("Task is completed, let's check result"); 
		try {
			future.get(250, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		} 
		System.out.println("Completed");
		threadpool.shutdown();
	}

	static String[] getMovieTitles(String substr) {
		String getResponse;
		int startPage = 1;
		int totalPages = Integer.MAX_VALUE;
		List<String> titlesList = new ArrayList<>();
		while (startPage <= totalPages) {
			try {
				URL url = new URL("https://jsonmock.hackerrank.com/api/movies/search/?Title=" + substr + "&page=" + startPage);
				HttpURLConnection con = (HttpURLConnection) url.openConnection();
				con.setRequestMethod("GET");
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				while ((getResponse = in.readLine()) != null) {
					JsonObject convertedObject = new Gson().fromJson(getResponse, JsonObject.class);
					totalPages = convertedObject.get("total_pages").getAsInt();
					JsonArray data = convertedObject.getAsJsonArray("data");
					for (int i = 0; i < data.size(); i++) {
						String title = data.get(i).getAsJsonObject().get("Title").getAsString();
						titlesList.add(title);
					}
				}
				in.close();
				startPage++;
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		Collections.sort(titlesList);
		return titlesList.toArray(new String[0]);
	}
	
	private static void inheritanceHeirarchy() {
		Animal dog = new Dog();
		dog.printAnimal("dog");
		
		Animal cow = new Cow();
		cow.printAnimal("cow");
		
		Animal duck = new Duck();
		duck.printAnimal("duck");
	}
}
