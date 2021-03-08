package Main;

public class Auction {

	//Lots of variables that I use throughout, I try to make them as easy to understand with the variable names but my naming conventions are weird sometimes
	private String auctionLeader;
	private AuctionItem aucItem;
	private int incrementPrice;
	private int maxBids;
	private int bidNumber;
	private int currentBid;
	private int highestBid;
	private boolean availability;

	//This will never logically be called but I felt like I should still have it for any reason
	public Auction() {
		
	}
	//Takes in auction specific info and then initializes everything
	public Auction(AuctionItem item, int increment, int bids) {
		aucItem = item;
		incrementPrice = increment;
		maxBids = bids;
		bidNumber = 0;
		currentBid = item.getValue();
		highestBid = item.getValue();
		availability = true;
	}
	//Setters
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
	//Getters
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
	//This is where the meat of an auction takes place, its very dense and can almost certainly be done in a more intuitive way but for now I just wanted to get it all down in practice and then figure out the perfect structuring later
	//Takes in the name and bid, probably better to take in the exact user object but I can decide later, Lots is still unimplemented like checking if the same user bids twice or other such features
	public boolean addBid(String name, int bid) {
		//Determines if the actual item is available, different from if the auction is no longer available
		if (!aucItem.getAvailability()) {
			System.out.println("This item is no longer available!");
			return false;
		}
		//Checks if the actual auction is over
		if (!availability) {
			System.out.println("No more bids can be placed on this auction!");
			return false;
		}
		//Determines if this is the first bid, and if so, makes a special case where current bid stays the same and highest bid is the placed bid
		if (bidNumber == 0 && bid > currentBid) {
			highestBid = bid;
			auctionLeader = name;
			bidNumber++;
		}
		//Just a whole system to check specific bid conditions, can likely be simplified and a lot is rough around the edges
		else if (bid > currentBid) {
			//Checks if bid is higher then highest bid and works on the proper increment, for example 1799 bid for an item with highest bid 1700 with increment 100 won't work
			if (bid >= (highestBid + incrementPrice) - ((highestBid + incrementPrice) % incrementPrice)) {
				int oldBid = highestBid;
				highestBid = bid;
				while (currentBid <= oldBid) {
					currentBid+=incrementPrice;
				}
				bidNumber++;
				auctionLeader = name;
				//Just checks if auction is over
				if (maxBids == bidNumber) {
					availability = false;
				}
				System.out.println("Bid Placed!");
				return true;
			}
			//Checks if bid was lower than highest and raises bid while keeping the same leader
			if (highestBid > (currentBid + incrementPrice) - ((currentBid + incrementPrice) % incrementPrice) && bid < highestBid) {
				while (currentBid < bid) {
					currentBid+=incrementPrice;
				}
				System.out.println("Your bid was placed but it was not the highest!");
			}
			//This comes in when a bid is lower then the highest and the bid can't be incremented
			if (bid < highestBid) {
				System.out.println("This bid is not high enough to replace the highest bid! A bid of at least " + ((highestBid + incrementPrice) - ((highestBid + incrementPrice) % incrementPrice)) + " is needed!");
				return false;
			}
			//If the same bid is placed, the first bidder wins
			if (bid == highestBid) {
				System.out.println("This bid is equal to the highest and cannot be placed!");
				return false;
			}
			//Checks if bid was highest but won't fit in increment
			if (bid > highestBid && bid < (highestBid + incrementPrice) - ((highestBid + incrementPrice) % incrementPrice)) {
				System.out.println("This bid is not high enough to be placed! A bid of at least " + ((highestBid + incrementPrice) - ((highestBid + incrementPrice) % incrementPrice)) + " is needed!");
				return false;
			}
		}
		//catchall for anything I missed
		System.out.println("This bid was either too low or could not be interpreted");
		return false;
	}
	//Unimplemented in the customer class, just for when I need to implement it
	//Checks that the customer is the winner and changes availability of item
	public boolean payBid(String name) {
		if (name == auctionLeader) {
			aucItem.setAvailabilty(false);
			return true;
		}
		return false;
	}
	
}
