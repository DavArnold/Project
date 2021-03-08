package Main;

public class Auction {

	private String auctionLeader;
	private AuctionItem aucItem;
	private int incrementPrice;
	private int maxBids;
	private int bidNumber;
	private int currentBid;
	private int highestBid;
	private boolean availability;

	public Auction() {
		
	}
	
	public Auction(AuctionItem item, int increment, int bids) {
		aucItem = item;
		incrementPrice = increment;
		maxBids = bids;
		bidNumber = 0;
		currentBid = item.getValue();
		highestBid = item.getValue();
		availability = true;
	}
	
	public void setItem(AuctionItem item) {
		aucItem = item;
	}
	
	public void setIncrement(int increment) {
		incrementPrice = increment;
	}
	
	public void setMaxBids(int bids) {
		maxBids = bids;
	}
	
	public void setBidNumber(int bids) {
		bidNumber = bids;
	}
	
	public boolean checkAvailability() {
		return availability;
	}
	
	public AuctionItem getItem() {
		return aucItem;
	}
	
	public int getIncrement() {
		return incrementPrice;
	}
	
	public int getMaxBids() {
		return maxBids;
	}
	
	public int getBidNumber() {
		return bidNumber;
	}
	
	public int getCurrentBid() {
		return currentBid;
	}
	
	public String getLeader() {
		return auctionLeader;
	}
	
	public int getHighestBid() {
		return highestBid;
	}
	
	public boolean addBid(String name, int bid) {
		if (!aucItem.getAvailability()) {
			System.out.println("This item is no longer available!");
			return false;
		}
		if (maxBids == bidNumber) {
			System.out.println("No more bids can be placed on this auction!");
			return false;
		}
		if (bidNumber == 0 && bid > currentBid) {
			highestBid = bid;
			auctionLeader = name;
			bidNumber++;
		}
		else if (bid > currentBid) {
			if (bid >= (highestBid + incrementPrice) - ((highestBid + incrementPrice) % incrementPrice)) {
				int oldBid = highestBid;
				highestBid = bid;
				while (currentBid <= oldBid) {
					currentBid+=incrementPrice;
				}
				bidNumber++;
				auctionLeader = name;
				if (maxBids == bidNumber) {
					availability = false;
				}
				System.out.println("Bid Placed!");
				return true;
			}
			if (highestBid > (currentBid + incrementPrice) - ((currentBid + incrementPrice) % incrementPrice) && bid < highestBid) {
				while (currentBid < bid) {
					currentBid+=incrementPrice;
				}
				System.out.println("Your bid was placed but it was not the highest!");
			}
			if (bid < highestBid) {
				System.out.println("This bid is not high enough to replace the highest bid! A bid of at least " + ((highestBid + incrementPrice) - ((highestBid + incrementPrice) % incrementPrice)) + " is needed!");
				return false;
			}
			if (bid == highestBid) {
				System.out.println("This bid is equal to the highest and cannot be placed!");
				return false;
			}
			if (bid > highestBid && bid < (highestBid + incrementPrice) - ((highestBid + incrementPrice) % incrementPrice)) {
				System.out.println("This bid is not high enough to be placed! A bid of at least " + ((highestBid + incrementPrice) - ((highestBid + incrementPrice) % incrementPrice)) + " is needed!");
				return false;
			}
		}
		System.out.println("This bid was either too low or could not be interpreted");
		return false;
	}
	
	public boolean payBid(String name) {
		if (name == auctionLeader) {
			aucItem.setAvailabilty(false);
			return true;
		}
		return false;
	}
	
}
