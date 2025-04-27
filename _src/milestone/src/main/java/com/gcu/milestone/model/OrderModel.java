package com.gcu.milestone.model;

/**
 * Model class representing an order in the system
 */
public class OrderModel {

	/**
	 * Order model for products
	 */
	private Long id;
	private String orderNo;
	private String productName;
	private float price;
	private int quantity;

	/**
	 * constructor
	 * 
	 * @param id          id for order
	 * @param orderNo     id order number
	 * @param productName name for order
	 * @param price       price for order
	 * @param quantity    quantity for order
	 */
	public OrderModel(Long id, String orderNo, String productName, float price, int quantity) {
		super();
		this.id = id;
		this.orderNo = orderNo;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}

	// getters & setters

	/**
	 * getter for id
	 * 
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * setter for id
	 * 
	 * @param id id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * getter for order number
	 * 
	 * @return order number
	 */
	public String getOrderNo() {
		return orderNo;
	}

	/**
	 * setter for order number
	 * 
	 * @param orderNo order number to set
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	/**
	 * getter for product name
	 * 
	 * @return productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * setter for product name
	 * 
	 * @param productName product name to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * getter for price
	 * 
	 * @return price
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * setter for price
	 * 
	 * @param price price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}

	/**
	 * getter for quantity
	 * 
	 * @return quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * setter for quantity
	 * 
	 * @param quantity quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
