package model;

public class Videogame {
	private int quantity;
	private int code;
	private int price;
	private int id;
	
	public Videogame(int code, int quantity, int price) {
		this.code = code;
		this.quantity = quantity;
		this.setPrice(price);
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {	
		this.id = id;
	}
	
}
