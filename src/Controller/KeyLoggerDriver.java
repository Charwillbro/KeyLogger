/**
 * 
 */
package Controller;

import model.Key;

import java.util.Scanner;

import Controller.Inventory;

/**
 * @author Charles Broderick Email: Charwillbro@gmail.com
 *
 */
public class KeyLoggerDriver {

	/**
	 * @param args default args
	 */
	public static void main(String[] args) {

		// Creating dealer inventory
		Inventory dealershipInventory = new Inventory();
		//scanner for user input
		Scanner driverInput = new Scanner(System.in);

		//creating salespeople (String Name, Integer Pin Number)
		SalesPerson sales1 = new SalesPerson("Charles", 1234);
		SalesPerson sales2 = new SalesPerson("Bob", 1234);
		SalesPerson sales3 = new SalesPerson("Carla", 1234);

		//creating keys (int keyID, String currentUser, String parkingLot, String make, String model, String color, String vinNumber,
		//int year)
		Key car1 = new Key(839777, "None", "North Lot", "Nissan", "Versa", "Black", "3N1CN7AP2FL839777", 2007);
		Key car2 = new Key(292972, "None", "North Lot", "Nissan", "Altima", "Red", "3N1CN7AP2FC292972", 2019);
		Key car3 = new Key(216676, "None", "North Lot", "Nissan", "Sentra", "Black", "3N1CN7AP2FY216676", 2015);
		Key car4 = new Key(909089, "None", "North Lot", "Nissan", "Maxima", "Silver", "3N1CN7AP2EC909089", 2014);
		Key car5 = new Key(705131, "None", "South Lot", "Nissan", "Sentra", "Blue", "3N1CN7AP2AC705131", 2010);
		Key car6 = new Key(750019, "None", "South Lot", "Nissan", "Frontier", "Black", "3N1CN7AP2FN750019", 2015);
		Key car7 = new Key(862600, "None", "South Lot", "Nissan", "Rogue", "White", "3N1CN7AP2FC862600", 2017);
		Key car8 = new Key(230849, "None", "South Lot", "Nissan", "Altima", "Brown", "3N1CN7AP2FC230849", 2015);
		Key car9 = new Key(294180, "None", "East Lot", "Nissan", "Altima", "Silver", "3N1CN7AP2FC294180", 2017);
		Key car10 = new Key(730243, "None", "East Lot", "Nissan", "Frontier", "Silver", "3N1CN7AP2FN730243", 2012);
		Key car11 = new Key(775281, "None", "East Lot", "Nissan", "Rogue", "Blue", "3N1CN7AP2FC775281", 2015);
		Key car12 = new Key(213725, "None", "East Lot", "Nissan", "Murano", "Black", "3N1CN7AP2FN213725", 2015);
		Key car13 = new Key(868424, "None", "East Lot", "Nissan", "Versa", "Blue", "3N1CN7AP3FL868424", 2018);
		Key car14 = new Key(844487, "None", "Alley Lot", "Nissan", "Rogue", "Red", "3N1CN7AP3FC844487", 2015);
		Key car15 = new Key(915647, "None", "Alley Lot", "Nissan", "Maxima", "White", "3N1CN7AP3FC915647", 2014);
		Key car16 = new Key(843358, "None", "Alley Lot", "Nissan", "Rogue", "Black", "3N1CN7AP3FC843358", 2015);
		Key car17 = new Key(198560, "None", "West Lot", "Nissan", "Altima", "Red", "3N1CN7AP3FC198560", 2015);
		Key car18 = new Key(531229, "None", "West Lot", "Nissan", "Rogue", "White", "3N1CN7AP3FP531229", 2017);
		Key car19 = new Key(516907, "None", "West Lot", "Nissan", "Rogue", "White", "3N1CN7AP3FP516907", 2018);
		Key car20 = new Key(868424, "None", "West Lot", "Nissan", "Versa", "Blue", "3N1CN7AP3FL868424", 2015);

		//adding sales people to system for demonstration
		dealershipInventory.salesPeople.add(sales1);
		dealershipInventory.salesPeople.add(sales2);
		dealershipInventory.salesPeople.add(sales3);

		//Adding keys to the system for demonstration. Would be in a database in production.
		dealershipInventory.keyInventory.add(car1);
		dealershipInventory.keyInventory.add(car2);
		dealershipInventory.keyInventory.add(car3);
		dealershipInventory.keyInventory.add(car4);
		dealershipInventory.keyInventory.add(car5);
		dealershipInventory.keyInventory.add(car6);
		dealershipInventory.keyInventory.add(car7);
		dealershipInventory.keyInventory.add(car8);
		dealershipInventory.keyInventory.add(car9);
		dealershipInventory.keyInventory.add(car10);
		dealershipInventory.keyInventory.add(car11);
		dealershipInventory.keyInventory.add(car12);
		dealershipInventory.keyInventory.add(car13);
		dealershipInventory.keyInventory.add(car14);
		dealershipInventory.keyInventory.add(car15);
		dealershipInventory.keyInventory.add(car16);
		dealershipInventory.keyInventory.add(car17);
		dealershipInventory.keyInventory.add(car18);
		dealershipInventory.keyInventory.add(car19);
		dealershipInventory.keyInventory.add(car20);
		
		//*****************************************************************************
		//*****************************************************************************
		//**                             Begin Testing                               **             
		//*****************************************************************************
		//*****************************************************************************

//		System.out.println();
//		System.out.println("Data in Key Inventory: ");
//		System.out.println(dealershipInventory.keyInventory);
//
//		System.out.println();
//		System.out.println("All Stored Sales People: ");
//		System.out.println(dealershipInventory.salesPeople);
//
//		//Test Checking out a key twice. The first tie, the key should be checked out no problem, the second time the key will display the error
//		System.out.println();
//		System.out.println("Check out a key: ");
//		dealershipInventory.checkOutKey(sales1, car1);
//		dealershipInventory.checkOutKey(sales1, car1);
//
//		//Search for a specific key by its ID
//		System.out.println();
//		System.out.println("Search for a key by id: ");
//		dealershipInventory.searchKey(sales1, 868424);
//
//		//Display a specific key
//		System.out.println();
//		System.out.println("Display Key: ");
//		System.out.println(car1.displayKeyInfo());
//
//		//Checking the size of the key Inventory
//		System.out.println();
//		System.out.println("Keys in Storage: " + dealershipInventory.getKeyInventorySIZE());
//
//		//Testing the system Login
//		System.out.println();
//		System.out.println("Testing Login:");
//		System.out.println("Login Status: " + dealershipInventory.salesLogIn("Charles"));
//
//		//Search for a salesperson by text name. if found will display the index of the object, else "-1"
//		System.out.println();
//		System.out.println("Salesperson Name Found: " + dealershipInventory.searchSalesPeople("Charles"));
//		
		//*****************************************************************************
		//*****************************************************************************
		//**                             End of Testing                              **             
		//*****************************************************************************
		//*****************************************************************************
		
//		String username = "";
//		SalesPerson currentUser = new SalesPerson();
//		
//		
//		System.out.println("Please Login:");
//		System.out.println("What is your name?");
//		username = input.nextLine();  // Read user input
//		
//		if(dealershipInventory.salesLogIn(username)) {
//			currentUser = dealershipInventory.searchSalesPerson(username);
//			System.out.println(currentUser);
//		}else {
//			System.out.println("Please Login:");
//			System.out.println("What is your name?");
//			username = input.nextLine();  // Read user input
//		}
//		
//		
//
//		input.close();
		
		//while there is not a valid current user, attempt to log in
		while(dealershipInventory.currentUser.getName() == "N/A") {
			dealershipInventory.userLogin();
		}
		
		//Once logged in, you are presented with a menu
		dealershipInventory.menuOptions();
		
		
	
	}

}
