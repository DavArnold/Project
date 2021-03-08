package Main;

import java.util.ArrayList;
import java.util.Scanner;

public class Customer {
	
	private String username;
	private String password;
	
	public Customer() {
		
	}
	
	public Customer(String name, String pass) {
		username = name;
		password = pass;
	}
	
	public void setUsername(String name) {
		username = name;
	}
	
	public void setPassword(String pass) {
		password = pass;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}

	public void login(Scanner input, ArrayList<Auction> auctionList) {
		System.out.println("Welcome " + getUsername());
		int menuVal = 0;
		while (menuVal != 5) {
			System.out.println("1. Check my Active Bids\n2. Check my Winning Bids\n3. Bid on an Item\n4. Pay for an Item\n5. Return to Main Menu");
			menuVal = input.nextInt();
			if (menuVal == 1) {
				for (int i = 0;i < auctionList.size();i++) {
					if (auctionList.get(i).getLeader().equals(getUsername())) {
						System.out.println("You have an Active Bid for " + auctionList.get(i).getItem().getName() + " for " + auctionList.get(i).getCurrentBid() + " and a max of " + auctionList.get(i).getHighestBid());
					}
				}
			}
			else if (menuVal == 2) {
				for (int i = 0;i < auctionList.size();i++) {
					if (auctionList.get(i).getLeader().equals(getUsername()) && !auctionList.get(i).checkAvailability()) {
						System.out.println("You have won the bid for " + auctionList.get(i).getItem().getName());
					}
				}
			}
			else if (menuVal == 3) {
				System.out.println("What item would you like to bid on?");
				ArrayList<Integer> availableAuction = new ArrayList<Integer>();
				for (int i = 0;i < auctionList.size();i++) {
					if (auctionList.get(i).checkAvailability()) {
						System.out.println((availableAuction.size() + 1) + ". " + auctionList.get(i).getItem().getName());
						availableAuction.add(i);
					}
				}
				if (availableAuction.size() == 0) {
					System.out.println("There are no available auctions");
				}
				else {
					int auction = input.nextInt();
					if (auction > 0 && auction <= availableAuction.size()) {
						System.out.println("The current bid for this auction is " + auctionList.get(availableAuction.get(auction - 1)).getCurrentBid() + " and the highest bid is " + auctionList.get(availableAuction.get(auction - 1)).getHighestBid());
						System.out.println("Input your bid:");
						auctionList.get(availableAuction.get(auction - 1)).addBid(getUsername(), input.nextInt());
					}
					else {
						System.out.println("This auction could not be found");
					}
				}
			}
			else if (menuVal == 4) {
				System.out.println("This option has not been implemented.");
			}
			else if (menuVal != 5) {
				System.out.println("Input was not understood");
			}
		}
	}
}
