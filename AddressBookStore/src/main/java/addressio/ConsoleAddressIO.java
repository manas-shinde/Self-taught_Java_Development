package addressio;

import java.util.Scanner;
import address.Address;
import list.List;

public class ConsoleAddressIO {
	Scanner sc = new Scanner(System.in);

	@Override
	protected void finalize() throws Throwable {
		sc.close();
	}

	public Address getAddressFromConsole() {
		System.out.println("Enter Address Details  ");
		System.out.println("Enter Street Name :");
		String tempStreet = sc.next();

		System.out.println("Enter City Name :");
		String tempCity = sc.next();

		System.out.println("Enter State Name :");
		String tempState = sc.next();

		System.out.println("Enter Zip Code :");
		int tempZipcode = sc.nextInt();

		Address address = new Address(tempStreet, tempState, tempCity, tempZipcode);
		return address;
	}

	public void displayAddress(Address address) {
		System.out.println(address);
	}

	public void displayAddressList(List listOfAddress) {
		System.out.println("******************Address List******************");
		listOfAddress.displayItems();
		System.out.println("*************************************************");
	}

	public void displayMessage(String msg) {
		System.out.println(msg);
	}

	public String getStreetName() {
		System.out.println("Enter Street Name : ");
		String street = sc.next();
		return street;
	}
}
