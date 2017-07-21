/**
 * 
 */
package org.training.wellsfargo;

/**
 * @author User
 *
 */
public class VendingMachineTraining {
	static VendingMachine vm = new VendingMachine();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		vm.addInventory("Chips", 3);
		vm.addInventory("Coke", 5);
		vm.addInventory("Iced Tea", 1);
		
		vm.doPurchase("Chips", 1, PaymentType.CASH);
		vm.doPurchase("Chips", 1, PaymentType.CREDIT);
		vm.doPurchase("Chips", 1, PaymentType.EPAY);
		vm.doPurchase("Chips", 1, PaymentType.CASH);
		vm.doPurchase("Coke", 1, PaymentType.CASH);		
		vm.doPurchase("Cookie", 1, PaymentType.CASH);
		vm.doPurchase("Iced Tea", 3, PaymentType.EPAY);
		
		vm.getInventory();
		vm.getPurchase();
	}

}
