/**
 * 
 */
package model;

/**
 * @author Charles Broderick
 * Email: Charwillbro@gmail.com
 *
 */
public class Key {

	private int keyID;
	private String currentUser = "None"; //Stores the id of the employee who checked out the key
	private String parkingLot;
	private String make;
	private String model;
	private String color;
	private String vinNumber;
	private int year;
	
	
	/**
	 * Default no args constructor
	 */
	public Key() {
		super();
	}
	/**
	 * @param keyID 		Unique ID of the key
	 * @param currentUser	Holds the name of the salesperson currently using the key, otherwise null
	 * @param parkingLot	Holds the name of the parking lot the vehicle is stored at
	 * @param make			The make of the vehicle
	 * @param model			The Model of the vehicle
	 * @param color			The Color of the vehicle
	 * @param vinNumber		The Vehicle Identification Number of the vehicle
	 * @param year			The year of the vehicle
	 */
	public Key(int keyID, String currentUser, String parkingLot, String make, String model, String color, String vinNumber,
			int year) {
		super();
		this.keyID = keyID;
		this.currentUser = currentUser;
		this.parkingLot = parkingLot;
		this.make = make;
		this.model = model;
		this.color = color;
		this.vinNumber = vinNumber;
		this.year = year;
	}
	/**
	 * @return the keyID
	 */
	public int getKeyID() {
		return keyID;
	}
	/**
	 * @param keyID the keyID to set
	 */
	public void setKeyID(int keyID) {
		this.keyID = keyID;
	}
	/**
	 * @return the currentUser
	 */
	public String getCurrentUser() {
		return currentUser;
	}
	/**
	 * @param currentUser the currentUser to set
	 */
	public void setCurrentUser(String currentUser) {
		this.currentUser = currentUser;
	}
	/**
	 * @return the parkingLot
	 */
	public String getParkingLot() {
		return parkingLot;
	}
	/**
	 * @param parkingLot the parkingLot to set
	 */
	public void setParkingLot(String parkingLot) {
		this.parkingLot = parkingLot;
	}
	/**
	 * @return the make
	 */
	public String getMake() {
		return make;
	}
	/**
	 * @param make the make to set
	 */
	public void setMake(String make) {
		this.make = make;
	}
	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}
	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}
	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}
	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}
	/**
	 * @return the vinNumber
	 */
	public String getVinNumber() {
		return vinNumber;
	}
	/**
	 * @param vinNumber the vinNumber to set
	 */
	public void setVinNumber(String vinNumber) {
		this.vinNumber = vinNumber;
	}
	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}
	
	/* 
	 * To String Function
	 */
	@Override
	public String toString() {
		return  " User:" + currentUser +" || ID:" + keyID + " || parkingLot:" + parkingLot +" || " + year+ " " + color+ " "+make
				+ " " + model  + " VIN:" + vinNumber +"\n" ;
	}
	
	
	/**
	 * @return A formatted string of the key information in an easily readable format.
	 */
	public String displayKeyInfo() {
		return "\n ID: " + keyID + "\n Vehicle: "+year+" " +color+" "+ make+" "+model+ "\n VIN: "+vinNumber+"\n Current Sales Person: " + currentUser + "\n Location: " + parkingLot;
	}
	
	/**
	 * @param inKey the key object to be checked out
	 * 
	 * This function will assign the name of the salesperson checking out a key to the key object
	 */
	public void checkOut(Key inKey) {
		String inName = inKey.currentUser;
		
		if (inKey.currentUser.compareTo("None") == 0 ) { //if the current user is None, Checkout the Key
			currentUser = inName;
		}else { //if the current user is anything but None, do not check out the key.
			System.out.println("This key is currently checked out by: "+inName);
		}
	}
	
	
	/**
	 * @param inKeyID is the id of the key to be checked in
	 * 
	 * This function resets the current user of the key to none, indicating it can be checked out
	 */
	public void checkIn(int inKeyID) {
		currentUser = "None";
	}
}
