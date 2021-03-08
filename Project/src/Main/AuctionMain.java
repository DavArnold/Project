package Main;

import java.util.ArrayList;
import java.util.Scanner;

public class AuctionMain {
	
	static ArrayList<AuctionItem> items = new ArrayList<AuctionItem>();
	static ArrayList<Admin> adminList = new ArrayList<Admin>();
	static ArrayList<Customer> customerList = new ArrayList<Customer>();
	static ArrayList<Auction> auctionList = new ArrayList<Auction>();
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		populateLists(items, adminList, customerList, auctionList);
		int menuVal = 0;
		System.out.println("Welcome to the Auction House!");
		while (menuVal != 5) {
			System.out.println("Main Menu: \n1. Load Sample Data\n2. Process the Backlogged Data\n3. Login as Admin\n4. Login as Customer\n5. Exit the Application");
			menuVal = input.nextInt();
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
		input.nextLine();
		System.out.println("Please input your Username:");
		String name = input.nextLine();
		for (int i = 0;i < adminList.size();i++) {
			if (name.equalsIgnoreCase(adminList.get(i).getUsername())) {
				System.out.println("Please input your Password:");
				if (input.nextLine().equals(adminList.get(i).getPassword())) {
					adminList.get(i).login(input, auctionList);
					return;
				}
			}
		}
		System.out.println("This account could not be found");
	}
	
	private static void customerLogin() {
		int menuVal = 0;
		while (menuVal != 3) {
			System.out.println("1. Returning Customer\n2. New Customer\n3. Return to Main Menu");
			menuVal = input.nextInt();
			input.nextLine();
			if (menuVal == 1) {
				System.out.println("Please input your Username:");
				String name = input.nextLine();
				for (int i = 0;i < customerList.size();i++) {
					if (name.equalsIgnoreCase(customerList.get(i).getUsername())) {
						System.out.println("Please input your Password:");
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
	
	private static void populateLists(ArrayList<AuctionItem> list1, ArrayList<Admin> list2, ArrayList<Customer> list3, ArrayList<Auction> list4) {
		list1.add(new AuctionItem("1990 Nintendo World Championship Gold Cartridge", 1000));
		list2.add(new Admin("Admin", "Admin"));
		list3.add(new Customer("Max", "Max"));
		list4.add(new Auction(items.get(0), 100, 5));
	}

}
