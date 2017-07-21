package org.training.wellsfargo;

public class VendingItem {
	String item;
	int count;
	PaymentType paidWith;
	public VendingItem(String item2, int purchaseCount, PaymentType payType) {
		this.item = item2;
		this.count = purchaseCount;
		this.paidWith = payType;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public PaymentType getPaidWith() {
		return paidWith;
	}
	public void setPaidWith(PaymentType paidWith) {
		this.paidWith = paidWith;
	}
	@Override
	public String toString() {
		return "VendingItem [item=" + item + ", count=" + count + ", paidWith=" + paidWith + "]";
	}
}
