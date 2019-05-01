/**
 * 
 */
package Controller;

/**
 * @author Charles Broderick
 * Email: Charwillbro@gmail.com
 *
 */
public class SalesPerson {
	
private String Name;
private int pinNumber;

/**
 * @param name name of the sales person
 * @param pinNumber a safe and secure plain text pin number
 */
public SalesPerson(String name, int pinNumber) {
	super();
	Name = name;
	this.pinNumber = pinNumber;
}

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "SalesPerson [Name=" + Name + ", pinNumber=" + pinNumber + "]";
}

/**
 * Default No Args Constructor
 */
public SalesPerson() {
	super();
}
/**
 * @return the name
 */
public String getName() {
	return Name;
}
/**
 * @param name the name to set
 */
public void setName(String name) {
	Name = name;
}
/**
 * @return the pinNumber
 */
public int getPinNumber() {
	return pinNumber;
}
/**
 * @param pinNumber the pinNumber to set
 */
public void setPinNumber(int pinNumber) {
	this.pinNumber = pinNumber;
}


}
