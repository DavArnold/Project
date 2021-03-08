package Main;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin {

	private String username;
	private String password;

	public Admin() {

	}

	public Admin(String name, String pass) {
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

	public void login(Scanner input, ArrayList<Auction> auctions) {
		int menuVal = 0;
		while (menuVal != 6) {
			System.out.println("Main Menu: \n1. List Ongoing Auctions\n2. Choose an Ongoing Auction and Check Bidding History\n3. List Information About Completed Auctions"
					+ "\n4. Summary Data of Winning Bids\n5. Add and Activate a New Auction\n6. Return to Main Menu");
			menuVal = input.nextInt();
			if (menuVal == 1) {
				for (int i = 0;i < auctions.size();i++) {
					if (auctions.get(i).checkAvailability()) {
						System.out.println("Auction " + (i + 1) + " for " + auctions.get(0).getItem().getName() + " is ongoing.");
					}
				}
			}
			else if (menuVal == 2) {
				System.out.println("This option has not been implemented.");
			}
			else if (menuVal == 3) {
				System.out.println("This option has not been implemented.");
			}
			else if (menuVal == 4) {
				System.out.println("This option has not been implemented.");
			}
			else if (menuVal == 5) {
				System.out.println("This option has not been implemented.");
			}
			else if (menuVal != 6) {
				System.out.println("Sorry! This Input Was Not Understood!");
			}
		}
	}
}
