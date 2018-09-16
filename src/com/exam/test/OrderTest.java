package com.exam.test;


import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.exam.Order;
import com.exam.OrderItem;
import com.exam.util.OrderItemBuilder;

public class OrderTest {

	@Test
	public void testSort() {
		List<OrderItem> itemList = OrderItemBuilder.buildOrderItems();
		OrderItem[] items = itemList.toArray(new OrderItem[itemList.size()]);
		
		Hashtable<Integer, OrderItem> ht = new Hashtable<Integer, OrderItem>();
		
		for (OrderItem item : itemList) {
			ht.put(item.getKey(), item);
		}
		
		Order order = new Order(items, ht);
		
		Iterator iter = order.getItems().iterator();
		while (iter.hasNext()) {
			OrderItem item = (OrderItem) iter.next();
			System.out.println(item.getName());
		}
		
		Assert.assertTrue(items.length > 0);
	}
	
	@Test
	public void testOrderTotal() {
		List<OrderItem> itemList = OrderItemBuilder.buildOrderItems();
		OrderItem[] items = itemList.toArray(new OrderItem[itemList.size()]);
		
		Hashtable<Integer, OrderItem> ht = new Hashtable<Integer, OrderItem>();
		
		for (OrderItem item : itemList) {
			ht.put(item.getKey(), item);
		}
		
		Order order = new Order(items, ht);
		
		float total = order.getOrderTotal(0.075f);
		
		System.out.println("Total: $" + total);
		
		Assert.assertTrue(total > 0f);
	}

}
