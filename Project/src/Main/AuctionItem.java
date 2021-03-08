package Main;

//This is just for an auction item object, very simple and not much other than getters and setters
public class AuctionItem {
	
	private String itemName;
	private int itemValue;
	//I use this to determine if the item was bought yet
	private boolean inStock;

	public AuctionItem() {
		inStock = true;
	}
	
	public AuctionItem(String name, int minValue) {
		itemName = name;
		itemValue = minValue;
		inStock = true;
	}
	
	//Setters
	public void setName(String name) {
		itemName = name;
	}
	
	public void setValue(int price) {
		itemValue = price;
	}
	
	public void setAvailabilty(boolean value) {
		inStock = value;
	}
	
	//Getters
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
