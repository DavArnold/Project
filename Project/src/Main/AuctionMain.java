package Main;

import java.util.ArrayList;
import java.util.Scanner;

public class AuctionMain {
	//Used to initialize all lists
	static ArrayList<AuctionItem> items = new ArrayList<AuctionItem>();
	static ArrayList<Admin> adminList = new ArrayList<Admin>();
	static ArrayList<Customer> customerList = new ArrayList<Customer>();
	static ArrayList<Auction> auctionList = new ArrayList<Auction>();
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		//Just use this for testing and simplicity, will get rid of it later for something better
		populateLists(items, adminList, customerList, auctionList);
		//I use menuVal for tracking menu choices from the user
		int menuVal = 0;
		System.out.println("Welcome to the Auction House!");
		//While loop for user interaction
		while (menuVal != 5) {
			System.out.println("Main Menu: \n1. Load Sample Data\n2. Process the Backlogged Data\n3. Login as Admin\n4. Login as Customer\n5. Exit the Application");
			menuVal = input.nextInt();
			//Following options are in relation to the list. The only working ones as of now are the logins
			if (menuVal == 1) {
				System.out.println("This option has not been implemented.");
			}
			else if (menuVal == 2) {
				System.out.println("This option has not been implemented.");
			}
			else if (menuVal == 3) {
				adminLogin();
			}
			else if (menuVal == 4) {
				customerLogin();
			}
			else if (menuVal != 5) {
				System.out.println("Sorry! This Input Was Not Understood!");
			}
		}
		System.out.println("Thank You! Come Again!");
		input.close();
	}

	private static void adminLogin() {
		//This is just to make it work, I still have no idea why this is needed after a nextInt()
		input.nextLine();
		System.out.println("Please input your Username:");
		String name = input.nextLine();
		//This just cycles through the admin list to look for an admin object with the same username
		for (int i = 0;i < adminList.size();i++) {
			if (name.equalsIgnoreCase(adminList.get(i).getUsername())) {
				System.out.println("Please input your Password:");
				//Used to validate password and then calls the admin item for user use
				if (input.nextLine().equals(adminList.get(i).getPassword())) {
					adminList.get(i).login(input, auctionList);
					return;
				}
			}
		}
		System.out.println("This account could not be found");
	}
	
	private static void customerLogin() {
		//Used for menu options
		int menuVal = 0;
		while (menuVal != 3) {
			System.out.println("1. Returning Customer\n2. New Customer\n3. Return to Main Menu");
			menuVal = input.nextInt();
			//Still don't know why I need this, same as adminLogin
			input.nextLine();
			if (menuVal == 1) {
				System.out.println("Please input your Username:");
				String name = input.nextLine();
				//This just cycles through the customer list to look for an customer object with the same username
				for (int i = 0;i < customerList.size();i++) {
					if (name.equalsIgnoreCase(customerList.get(i).getUsername())) {
						System.out.println("Please input your Password:");
						//Validates password and then calls customer item for use
						if (input.nextLine().equals(customerList.get(i).getPassword())) {
							customerList.get(i).login(input, auctionList);
							return;
						}
						System.out.println("Incorrect Password");
						return;
					}
				}
				System.out.println("This account could not be found");
			}
			//Used to add a customer object to the list, I don't have any checks right now for repeat names but will implement later
			else if (menuVal == 2) {
				System.out.println("Please input your username:");
				String username = input.nextLine();
				System.out.println("Please input your password:");
				customerList.add(new Customer(username, input.nextLine()));
				System.out.println("Account Created");
			}
			else if (menuVal != 3) {
				System.out.println("Sorry! This Input Was Not Understood!");
			}
		}
	}
	
	//I only use this to fill the needed lists for testing, I will come up with a more elegant solution in the future, for now this works
	private static void populateLists(ArrayList<AuctionItem> list1, ArrayList<Admin> list2, ArrayList<Customer> list3, ArrayList<Auction> list4) {
		list1.add(new AuctionItem("1990 Nintendo World Championship Gold Cartridge", 1000));
		list2.add(new Admin("Admin", "Admin"));
		list3.add(new Customer("Max", "Max"));
		list4.add(new Auction(items.get(0), 100, 5));
	}

}
