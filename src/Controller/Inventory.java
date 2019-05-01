/**
 * 
 */
package Controller;

import model.Key;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author Charles Broderick Email: Charwillbro@gmail.com
 *
 */
public class Inventory {

	public LinkedList<Key> keyInventory = new LinkedList<Key>();
	public LinkedList<Key> checkedOutKeys = new LinkedList<Key>();
	public LinkedList<SalesPerson> salesPeople = new LinkedList<SalesPerson>();
	public Stack<String> keyLog = new Stack<String>();
	SalesPerson currentUser = new SalesPerson("N/A", 0000);
	//Key[] b = keyInventory.toArray(new Key[keyInventory.size()]); // array for bubble sort

	/**
	 * @return the keyInventory
	 */
	public LinkedList<Key> getKeyInventory() {
		return keyInventory;
	}

	/**
	 * This Function adds a new Sales Person to the the salesPeople linked list
	 * 
	 * @param inSalesPerson A salesperson object to be added to the salesPeople linked list
	 */
	public void addSalesPerson(SalesPerson inSalesPerson) {
		salesPeople.add(inSalesPerson);
	}

	/**
	 * This function is used to check keys out. The function checks if the key is available then allows the key to be
	 * checked out and assigns the salesperson name to the key. If the key is unavailable, an error message is displayed
	 * 
	 * @param inSalesPerson The salesperson intending to check out the key
	 * @param inKey the key to be checked out
	 */
	public void checkOutKey(SalesPerson inSalesPerson, Key inKey) {
		if (inKey.getCurrentUser().compareTo("None") == 0) { //if the current user is None, Checkout the Key

			inKey.setCurrentUser(inSalesPerson.getName()); //attaches the salespersons name to the key

			logKey(inKey); //inserts transaction into the log

			checkedOutKeys.add(inKey);// adds key to the list of checked out keys

			System.out
					.println("Key ID:" + inKey.getKeyID() + " Successfully checked out by: " + inKey.getCurrentUser());

		} else { //if the current user is anything but None, do not check out the key.
			System.out.println("This key is currently checked out by: " + inKey.getCurrentUser());
		}

	}

	/**
	 * If the salesperson name matches the name of the person who checked the key out then the key is removed for the
	 * checked out list and the salesperson name is removed
	 * 
	 * @param inSalesPerson salesperson intending to check in the key
	 * @param inKey key to be checked in
	 */
	public void checkInKey(SalesPerson inSalesPerson, Key inKey) {

		if (inKey.getCurrentUser() == inSalesPerson.getName()) {
			checkedOutKeys.remove(inKey); //removes key from the list of checked out keys
			inKey.setCurrentUser("None"); //removes the salesperson name
			System.out.println();
			System.out.println("Key Returned");
		} else {
			System.out.println();
			System.out.println("Your name does not match the Keys Current User.");
			System.out.println("You are not allowedto return this key.");
		}

	}

	/**
	 * Allows the user to search for a key by ID and returns a key object
	 * 
	 * @param inSalesPerson The salesperson performing the search
	 * @param inKeyId the key ID to be searched
	 * @return the key object that was found or a dummy object with dummy values if it was not found
	 */
	public Key searchKey(SalesPerson inSalesPerson, int inKeyId) {

		Key foundKey = new Key(000000, "Vehicle Not Found", "N/A", "N/A", "N/A", "N/A", "N/A", 0000);

		for (Key tempKey : keyInventory) {

			if (tempKey.getKeyID() == inKeyId) {
				foundKey = tempKey;
			}
		}
		System.out.println(foundKey.displayKeyInfo());
		return foundKey;
	}

	/**
	 * Allows the user to search for a key by ID and returns the index of the key object
	 * 
	 * @param inSalesPerson The salesperson performing the search
	 * @param inKeyId the key ID to be searched
	 * @return an Int with the index at which the ID was found or -1 if not found
	 */
	public int searchKeyIndex(SalesPerson inSalesPerson, int inKeyId) {
		int foundKeyIndex = -1;

		for (Key tempKey : keyInventory) {

			if (tempKey.getKeyID() == inKeyId) {
				foundKeyIndex = keyInventory.indexOf(tempKey);
			}
		}
		//System.out.println(foundKeyIndex);
		return foundKeyIndex;
	}

	/**
	 * @return the size of the linked list storing key objects
	 */
	public int getKeyInventorySIZE() {

		return keyInventory.size();
	}

	/**
	 * This function first checks if the user name exists and will prompt the user to re enter user names until the
	 * program finds a match. Once there is a match the program asks for a user PIN and will restart the login process
	 * if the pin is incorrect. once the credentials are verified then the current user variable is set to the entered
	 * and verified credentials
	 * 
	 * 
	 * @param inName the user name a user would like to log on with
	 * @return a boolean indicating whether or not the login was successful
	 */
	public Boolean salesLogIn(String inName) {
		int personFound = searchSalesPeople(inName);
		int pinAttempt;
		Boolean personFlag = false;
		Boolean passwordFlag = false;
		Boolean canLogIn = false;
		Scanner userInput = new Scanner(System.in);  // Create a Scanner object
		//System.out.println("inName: " + inName);
		if (personFound != -1) {

			personFlag = true; //a person was found, so mark flag true

			//Get user input, in this case PIN
			System.out.println("Enter PIN for " + inName);
			pinAttempt = userInput.nextInt();  // Read user input

			for (SalesPerson tempSales : salesPeople) {

				if (tempSales.getPinNumber() == pinAttempt && tempSales.getName().compareTo(inName) == 0) {
					passwordFlag = true; //the name and password combo match, so mark the flag true

					//Cheating to clear out console
					for (int i = 0; i < 50; ++i) {
						System.out.println();
					}
					System.out.println("Login Success, Welcome " + inName);
				}
			}

		} else {
			System.out.println("Salesperson not found.");
		}

		//check the flags to make sure the credentials have passed inspection
		if (personFlag && passwordFlag) { //if both flags are true, canLogIn is true
			canLogIn = true;
		}

		return canLogIn;
	};

	/**
	 * Allows a user to search for a salesperson by name and returns the index of the salesperson as an int
	 * 
	 * @param searchName The name to be searched for in the salesPeople List
	 * @return an integer representing the index of the found salesperson object. or -1 if not found
	 */
	public int searchSalesPeople(String searchName) {
		int foundIndex = -1;
		//System.out.println("searchName: "+searchName);
		for (SalesPerson tempSales : salesPeople) {

			if (tempSales.getName().equals(searchName)) {
				foundIndex = salesPeople.indexOf(tempSales);
			}
		}
		//System.out.println(foundKeyIndex);
		return foundIndex;
	};

	/**
	 * Allows a user to search for a salesperson by name and returns a salesperson object
	 * 
	 * @param searchName The name to be searched for in the salesPeople List
	 * @return the found salesperson object or a dummy object with dummy values
	 */
	public SalesPerson searchSalesPerson(String searchName) {
		SalesPerson tempSalesPerson = new SalesPerson("N/A", 0000);

		for (SalesPerson tempSales : salesPeople) {

			if (tempSales.getName().equals(searchName)) {
				tempSalesPerson = tempSales;
			}
		}
		//System.out.println(foundKeyIndex);
		return tempSalesPerson;
	};

	/**
	 * Initiates the Login Sequence
	 */
	public void userLogin() {
		Scanner input = new Scanner(System.in);
		String username = "";

		System.out.println();
		System.out.println("Please Login:");
		System.out.println("What is your name?");

		username = input.nextLine();  // Read user input

		if (salesLogIn(username)) {
			currentUser = searchSalesPerson(username);
			//System.out.println(currentUser);
		}
	}

	/**
	 * Terminates the program.
	 */
	public void exitProgram() {
		System.out.println("Thank you for using KEY LOGGER!");
		System.exit(0);
	}

	/**
	 * Displays the top menu for the Key Logger Program
	 */
	public void menuOptions() {
		Scanner menuInput = new Scanner(System.in);
		int menuChoice;
		Key currentKey = new Key();

		System.out.println();
		System.out.println("KEY LOGGER");
		System.out.println("Please Select An Option Below");
		System.out.println("-----------------------------");
		System.out.println(" 1 - Display Inventory");
		System.out.println(" 2 - Search By ID");
		System.out.println(" 3 - Check Out a Key");
		System.out.println(" 4 - Check In a Key");
		System.out.println(" 5 - View Checked Out Vehicles");
		System.out.println(" 6 - View Activity Log");
		System.out.println(" 7 - Sort By ID");
		System.out.println(" 9 - Exit");

		menuChoice = menuInput.nextInt();

		switch (menuChoice) {
		case 1: //Display Inventory
			displayInventory();
			menuOptions();
			break;
		case 2: //Search for Key by ID
			System.out.println("What is the Vehicle/Key ID?");
			menuChoice = menuInput.nextInt();

			currentKey = searchKey(currentUser, menuChoice);

			menuOptions();
			break;
		case 3: //Check Out a Key

			System.out.println("What is the Vehicle/Key ID?");
			menuChoice = menuInput.nextInt();

			currentKey = searchKey(currentUser, menuChoice);

			System.out.println();
			System.out.println(" Is this the vehicle you want to check out?");
			System.out.println(" 1 - Yes");
			System.out.println(" 2 - No");
			menuChoice = menuInput.nextInt();
			switch (menuChoice) {
			case 1:
				checkOutKey(currentUser, currentKey);
				menuOptions();
				break;
			case 2:
				System.out.println("What is the Vehicle/Key ID?");
				menuChoice = menuInput.nextInt();

				searchKey(currentUser, menuChoice);
				menuOptions();
				break;
			default:
				menuOptions();
				break;
			}

			break;

		case 4: //Check In a Key
			keyReturn(currentUser);
			menuOptions();
			break;
		case 5: //View Checked Out vehicles
			displayCheckedOutKeys();
			menuOptions();
			break;
		case 6:
			viewLog();
			menuOptions();
			break;
		case 7: //exit
			sortByYear();
			sortByID();
			menuOptions();

			break;
		case 9: //exit
			exitProgram();

			break;
		default:
			menuOptions();
			break;
		}

	}

	/**
	 * Displays entire key inventory for the user. Gives the option to sort by id or by year.
	 */
	public void displayInventory() {
		Scanner menuInput = new Scanner(System.in);
		int menuChoice;
		

		System.out.println();
		System.out.println("Vehicle Inventory");
		System.out.println("Please Select An Option Below");
		System.out.println("-----------------------------");
		System.out.println(" 1 - Display Inventory");
		System.out.println(" 2 - Sort By ID");
		System.out.println(" 3 - Sort By Year");
		System.out.println(" 4 - Sort By VIN");
		System.out.println(" 9 - Go Back");

		menuChoice = menuInput.nextInt();

		switch (menuChoice) {
		case 1: //Display Inventory
			displayInventory(keyInventory);//displays the inventory
			displayInventory();
			break;
		case 2: //Sort by ID
			sortByID();
			displayInventory();
			break;
		case 3: //Sort by Year
			sortByYear();
			displayInventory();
			break;
		case 4: //Sort by VIN (Which is just the ID)
			sortByID();
			displayInventory();
			break;
		case 9: //Returns to the previous menu
			menuOptions();
			break;
		default://Returns to the previous menu
			menuOptions();
			break;
		}
	}

	/**
	 * Displays the list of all keys currently checked out.
	 */
	public void displayCheckedOutKeys() {

		System.out.println("Keys Checked Out");
		System.out.println("-----------------");

		displayInventory(checkedOutKeys);//displays the inventory
	}

	/**
	 * Takes a current timestamp and key information and pushes it into the key log stack
	 * 
	 * @param inKey key to be added to the transaction log
	 */
	public void logKey(Key inKey) {
		//timestamp info found at geeksforgeeks.com
		String transactionInfo = "";
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		transactionInfo += timestamp.toString() + " " + inKey.toString();
		keyLog.push(transactionInfo);

	}

	/**
	 * Prints the transaction log of all the people who have removed keys
	 */
	public void viewLog() {
		System.out.println(Arrays.toString(keyLog.toArray()));
	}

	/**
	 * This function prints out only the keys that the current salesperson has checked out. The salesperson can then
	 * pick which key they would like to return. If the salesperson name matches the name on the key then the key is
	 * returned and the salesperson is removed from the key. The key is also removed from the Checked out list.
	 * 
	 * @param inSalesPerson the salesperson who wants to return the key
	 */
	public void keyReturn(SalesPerson inSalesPerson) {

		Scanner input = new Scanner(System.in);
		int keyID; 				//ID with which to search for keys
		String parkingLot; 		//string to hold new parking location

		displayInventory(checkedOutKeys);//displays the inventory

		System.out.println("Enter the ID of the key you would like to return.");

		keyID = input.nextInt();  // Read user input
		input.nextLine();
		Key currentKey = searchKey(currentUser, keyID); //Set the current key to be the one you searched for

		System.out.println("At Which parking lot did you park the car?");
		parkingLot = input.nextLine();// take user input about the parked car

		currentKey.setParkingLot(parkingLot);//change the current parking lot for the key

		checkInKey(currentUser, currentKey); //check in the key
	}

	//-------------------------------------------------------------------
	//-------------------------------------------------------------------
	//---                    Sorting Functions                        ---
	//-------------------------------------------------------------------
	//-------------------------------------------------------------------
	
	/**
	 * Swap is used by the sorting algorithm to swap the plaves of 2 objects in an array
	 * 
	 * @param one index 1 for the swap
	 * @param two index 2 for the swap
	 * @param b the name of the bubble sort array
	 */
	private void swap(int one, int two, Key[] b) {
		Key temp = b[one];
		b[one] = b[two];
		b[two] = temp;
	}
	
	/**
	 *  This Function Uses Bubble Sort to sort the objects in the linked list by Key ID
	 */
	public void sortByID() {
		Key[] b = keyInventory.toArray(new Key[keyInventory.size()]);
		String currentSalesPerson;

		int out, in;

		int nElems = keyInventory.size(); // number of data items for bubble sort

		for (out = nElems - 1; out > 1; out--) { // outer loop (backward)

			for (in = 0; in < out; in++) { // inner loop (forward)

				if (b[in].getKeyID() > b[in + 1].getKeyID()) { // out of order?

					swap(in, in + 1, b);
				} // swap them
			}
		}
		displaySort(b);
	}


	/**
	 *  This Function Uses Bubble Sort to sort the objects in the linked list by Year
	 */
	public void sortByYear() {
		Key[] b = keyInventory.toArray(new Key[keyInventory.size()]);
		String currentSalesPerson;

		int out, in;

		int nElems = keyInventory.size(); // number of data items for bubble sort

		for (out = nElems - 1; out > 1; out--) { // outer loop (backward)

			for (in = 0; in < out; in++) { // inner loop (forward)

				if (b[in].getYear() > b[in + 1].getYear()) { // out of order?

					swap(in, in + 1, b);
				} // swap them
			}
		}
		displaySort(b);

	}

	/**
	 * Takes a sorted array of Key objects and outputs them
	 * 
	 * @param arrToPrint sorted array of data to print
	 */
	private void displaySort(Key[] arrToPrint) {
		String currentSalesPerson;
		for (Key tempKey : arrToPrint) {

			if (tempKey.getCurrentUser().compareTo("None") == 0) {
				currentSalesPerson = "Available";
			} else {
				currentSalesPerson = "Checked out by: " + tempKey.getCurrentUser();
			}
			System.out.println(" ID:" + tempKey.getKeyID() + " " + tempKey.getYear() + " " + tempKey.getColor() + " "
					+ tempKey.getMake() + " " + tempKey.getModel() + " " + tempKey.getVinNumber() + " "
					+ tempKey.getParkingLot() + " " + currentSalesPerson + " ");
		}
	}

	/**
	 * Takes a sorted array of Key objects and outputs them
	 * 
	 * @param arrToPrint sorted array of data to print
	 */
	private void displayInventory(LinkedList<Key> listToPrint) {
		String currentSalesPerson;
		for (Key tempKey : listToPrint) {

			if (tempKey.getCurrentUser().compareTo("None") == 0) {
				currentSalesPerson = "Available";
			} else {
				currentSalesPerson = "Checked out by: " + tempKey.getCurrentUser();
			}
			System.out.println(" ID:" + tempKey.getKeyID() + " " + tempKey.getYear() + " " + tempKey.getColor() + " "
					+ tempKey.getMake() + " " + tempKey.getModel() + " " + tempKey.getVinNumber() + " "
					+ tempKey.getParkingLot() + " " + currentSalesPerson + " ");
		}
	}
}
