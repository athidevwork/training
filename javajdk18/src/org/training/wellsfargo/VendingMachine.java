/**
 * 
 */
package org.training.wellsfargo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Athi
 *
 */
public class VendingMachine {
	Map<String, Integer> inventory = new HashMap<String, Integer>();
	List<VendingItem> purchase = new ArrayList<VendingItem>();;
	
	public void addInventory(String item, int itemCount) {
		if (inventory.containsKey(item)) {
			Integer currentCount = inventory.get(item);
			currentCount += itemCount;
		}
		else
			inventory.put(item, itemCount);
		System.out.println("VendingMachine [inventory=" + inventory + ", purchase=" + purchase + "]");
	}

	public void doPurchase(String item, int purchaseCount, PaymentType payType) {
		if (inventory.containsKey(item) && inventory.get(item) > 0) {
			if (purchaseCount > inventory.get(item))
				System.out.println(purchaseCount + " quantity not available for " + item);
			else {
				inventory.put(item, inventory.get(item)-purchaseCount);		
				purchase.add(new VendingItem(item, purchaseCount, payType));					
			}
		}
		else
			System.out.println(item + " is not available in Vending Machine inventory.");
		System.out.println("VendingMachine [inventory=" + inventory + ", purchase=" + purchase + "]");
	}
	
	public void getInventory() {
		System.out.println("*******************");
		for (String key : inventory.keySet()) {
			System.out.println(key + " = " + inventory.get(key));
		}
		System.out.println("*******************");
	}
	
	public void getPurchase() {
		System.out.println("*******************PURCHASE LIST");
		for (int i=0; i < purchase.size(); i++) {
			System.out.println(purchase.get(i));
		}
		System.out.println("*******************PURCHASE LIST");
	}	
}
