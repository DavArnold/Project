package Main;

public class AuctionItem {
	
	private String itemName;
	private int itemValue;
	private boolean inStock;

	public AuctionItem() {
		inStock = true;
	}
	
	public AuctionItem(String name, int minValue) {
		itemName = name;
		itemValue = minValue;
		inStock = true;
	}
	
	public void setName(String name) {
		itemName = name;
	}
	
	public void setValue(int price) {
		itemValue = price;
	}
	
	public void setAvailabilty(boolean value) {
		inStock = value;
	}
	
	public String getName() {
		return itemName;
	}
	
	public int getValue() {
		return itemValue;
	}
	
	public boolean getAvailability() {
		return inStock;
	}
}
