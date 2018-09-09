package com.exam;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;

public final class Order implements Serializable {

	private static final long serialVersionUID = 5200545778878419447L;
	private final OrderItem[] orderItems;
	private final Hashtable<Integer, OrderItem> hashtable;
	
	public Order(OrderItem[] orderItems, Hashtable<Integer, OrderItem> ht) {
		this.orderItems = orderItems;
		
		Hashtable<Integer, OrderItem> htNew = new Hashtable<Integer, OrderItem>();
		Iterator<Integer> iter = ht.keySet().iterator();
		
		Integer key;
		while(iter.hasNext()) {
			key = iter.next();
			htNew.put(key, ht.get(key));
		}
		this.hashtable = htNew;
	}
	
	public Hashtable<Integer, OrderItem> getHashtable() {
		
		return (Hashtable<Integer, OrderItem>) hashtable.clone();
	}

	// Returns the total order cost after the tax has been applied
	public float getOrderTotal(float taxRate) {
		float totalNonTax = 0f;
		float totalTax = 0f;
		
		for (OrderItem item: orderItems) {
			if (item.isTaxable()) {
				totalTax += (item.getPrice() * item.getQuantity());
			} else {
				totalNonTax += (item.getPrice() * item.getQuantity());
			}			
		}
		
		float taxableTotal = (totalTax * (1f + taxRate));
		float total = totalNonTax + taxableTotal;
		
		System.out.println("total for non tax: " + totalNonTax);
		System.out.println("total for taxable: " + taxableTotal);
		System.out.println("amount of tax: " + (totalTax * taxRate));
		
		return round(total, 2).floatValue();
	}

	/**
	 * Returns a Collection of all items sorted by item name (case-insensitive).
	 *
	 * @return Collection
	 */
	public Collection getItems() {
		Arrays.sort(orderItems, (a, b) -> a.getName().toLowerCase().compareTo(b.getName().toLowerCase()));
		return Arrays.asList(orderItems); // implement this method
	}
	
	private static BigDecimal round(float d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);       
        return bd;
    }
}
