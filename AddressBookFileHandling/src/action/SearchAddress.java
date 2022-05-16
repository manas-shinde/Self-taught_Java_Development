package action;

import java.util.Scanner;
import address.Address;
import list.List;
import menu.MenuItem;

public class SearchAddress implements Action {

	List<Address> listOfAddress;
	static List<MenuItem> subMenuList = new List<>();
	Action a;

	/**
	 * 
	 * @param listOfAddress
	 */
	public SearchAddress(List<Address> listOfAddress) {
		this.listOfAddress = listOfAddress;

//		Creating a Sub-Menu for Searching Address by choice

		subMenuList.addItem(new MenuItem("By street ", 1, a = new SearchAddressByStreet(listOfAddress)));
		subMenuList.addItem(new MenuItem("By state ", 2, a = new SearchAddressByState(listOfAddress)));
		subMenuList.addItem(new MenuItem("By city ", 3, a = new SearchAddressByCity(listOfAddress)));
		subMenuList.addItem(new MenuItem("By zipcode ", 4, a = new SearchAddressByZipcode(listOfAddress)));
	}

	public void onAction() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Search Address ");

		subMenuList.displayItems();

		System.out.println("Enter Choice :");
		int choice = sc.nextInt();

		MenuItem menuItem = null;

		for (int i = 0; i <= listOfAddress.totalItem(); i++) {

			menuItem = subMenuList.getData(i);

			if (choice == i) {
				menuItem.action.onAction();
				break;
			}
		}
	}
}

class SearchAddressByStreet implements Action {

	List<Address> listOfAddress;
	static boolean streetFound;
	static Address address;

	/**
	 * 
	 * @param listOfAddress
	 */
	public SearchAddressByStreet(List<Address> listOfAddress) {// this class used to search a address by street
		this.listOfAddress = listOfAddress;
	}

	public void onAction() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Street Name to Search : ");
		String streetName = sc.next();

		streetFound = false;

		Address ad = null;

		for (int j = 1; j <= listOfAddress.totalItem(); j++) {
			ad = listOfAddress.getData(j);// copy the address instance of position 'j' to Address instance ad

			if (streetName.equals(ad.getStreet())) {// Compare the street name enter to Address instance street
				address = ad;
				System.out.println("---------------------------- Address Found ----------------------------");
				System.out.println(ad);
				System.out.println("-----------------------------------------------------------------------");
				streetFound = true;
			}
		}
		if (streetFound == false) {
			System.out.println("Address is Not found!!!!");
		}
	}

	public boolean isStreetFound() {
		return streetFound;
	}

	public Address getAddress() {
		return address;
	}

}

class SearchAddressByState implements Action {// this class used to search a address by state

	List<Address> listOfAddress;
	static boolean stateFound;
	static Address address;

	/**
	 * 
	 * @param listOfAddress
	 */
	public SearchAddressByState(List<Address> listOfAddress) {
		this.listOfAddress = listOfAddress;
	}

	public void onAction() {
		Scanner sc = new Scanner(System.in);
		stateFound = false;

		System.out.println("Enter State Name to Search : ");
		String stateName = sc.next();

		Address ad = null;

		for (int j = 1; j <= listOfAddress.totalItem(); j++) {
			ad = listOfAddress.getData(j);// copy the address instance of position 'j' to Address instance ad

			if (stateName.equals(ad.getState())) {// Compare the state name enter to Address instance state
				address = ad;
				System.out.println("---------------------------- Address Found ----------------------------");
				System.out.println(ad);
				System.out.println("-----------------------------------------------------------------------");
				stateFound = true;
			}
		}
		if (stateFound == false) {
			System.out.println("Address not found !!!");
		}

	}

	public boolean isStateFound() {
		return stateFound;
	}

	public Address getAddress() {
		return address;
	}

}

class SearchAddressByCity implements Action {

	List<Address> listOfAddress;
	static boolean cityFound;
	static Address address;

	/**
	 * 
	 * @param listOfAddress
	 */
	public SearchAddressByCity(List<Address> listOfAddress) {
		this.listOfAddress = listOfAddress;
	}

	public void onAction() {
		Scanner sc = new Scanner(System.in);
		cityFound = false;

		System.out.println("Enter City Name to Search : ");
		String cityName = sc.next();

		Address ad = null;
		for (int j = 1; j <= listOfAddress.totalItem(); j++) {
			ad = listOfAddress.getData(j);// copy the address instance of position 'j' to Address instance ad

			if (cityName.equals(ad.getCity())) {// Compare the city name enter to Address instance city
				System.out.println("---------------------------- Address Found ----------------------------");
				System.out.println(ad);
				address = ad;
				System.out.println("-----------------------------------------------------------------------");
				cityFound = true;
			}
		}
		if (cityFound == false) {
			System.out.println("Address is not in AddressBook!!!!");
		}

	}

	public boolean isCityFound() {
		return cityFound;
	}

	public Address getAddress() {
		return address;
	}

}

class SearchAddressByZipcode implements Action {

	List<Address> listOfAddress;
	static boolean zipFound;
	static Address address;

	public SearchAddressByZipcode(List<Address> listOfAddress) {
		this.listOfAddress = listOfAddress;
	}

	public void onAction() {
		Scanner sc = new Scanner(System.in);
		zipFound = false;

		System.out.println("Enter zip code to Search : ");
		int zipcode = sc.nextInt();

		Address ad = null;

		for (int j = 1; j <= listOfAddress.totalItem(); j++) {
			ad = listOfAddress.getData(j);// copy the address instance of position 'j' to Address instance ad

			if (zipcode == ad.getZipcode()) {// Compare the zip-code enter to Address instance zip-code
				System.out.println("---------------------------- Address Found ----------------------------");
				System.out.println(ad);
				address = ad;
				System.out.println("-----------------------------------------------------------------------");
				zipFound = true;
			}
		}
		if (zipFound == false) {
			System.out.println("Address is not in AddressBook!!!!");
		}

	}

	public boolean isZipFound() {
		return zipFound;
	}

	public Address getAddress() {
		return address;
	}

}