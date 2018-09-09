package com.exam.util;

import java.util.ArrayList;
import java.util.List;

import com.exam.OrderItem;

public class OrderItemBuilder {

	
	public static List<OrderItem> buildOrderItems() {
		List<OrderItem> items = new ArrayList<OrderItem>();
		
		OrderItem item1 = new OrderItem(123, "Fry", 2.49f, true, OrderItem.Type.MATERIAL, 1);
		items.add(item1);
		OrderItem item2 = new OrderItem(124, "shake", 4.49f, true, OrderItem.Type.MATERIAL, 1);
		items.add(item2);
		OrderItem item3 = new OrderItem(126, "apple Turnover", 3.99f, true, OrderItem.Type.MATERIAL, 1);
		items.add(item3);
		OrderItem item4 = new OrderItem(235, "Dr. Pepper", 1.99f, true, OrderItem.Type.MATERIAL, 2);
		items.add(item4);
		OrderItem item5 = new OrderItem(225, "Delivery", 2.99f, true, OrderItem.Type.SERVICE, 1);
		items.add(item5);
		
		return items;
	}
}
