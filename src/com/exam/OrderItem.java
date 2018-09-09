package com.exam;

import java.io.Serializable;

public final class OrderItem implements Serializable {
	private static final long serialVersionUID = -1613999865552013143L;
	private final Integer key;
	private final String name;
	private final float price;
	private final boolean taxable;
	private final Type type;
	private final Integer quantity;

	public OrderItem(Integer key, String name, float price, boolean taxable, Type type, Integer quantity) {
		this.key = key;
		this.name = name;
		this.price = price;
		this.taxable = taxable;
		this.type = type;
		this.quantity = quantity;
	}

	public Integer getKey() {
		return key;
	}

	public String getName() {
		return name;
	}

	public float getPrice() {
		return price;
	}

	public boolean isTaxable() {
		return this.type == Type.MATERIAL ? true : false;
	}
	
	public enum Type {
		SERVICE, MATERIAL
	}

	public Integer getQuantity() {
		return quantity;
	}
}
