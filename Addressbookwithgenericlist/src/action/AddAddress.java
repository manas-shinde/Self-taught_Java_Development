package action;

import address.Address;
import list.List;
import menu.MenuItem;

import java.util.*;

public class AddAddress implements Action {

	static List<Address> listOfAddress;
	static List<MenuItem> subMenuList = new List<>();
	Action a;

	public AddAddress(List<Address> listOfAddress) {
		this.listOfAddress = listOfAddress;
		subMenuList.addItem(new MenuItem("Append Address ", 1, a));
		subMenuList.addItem(new MenuItem("Insert Address ", 2, a));

	}

	public void onAction() {
		Scanner sc = new Scanner(System.in);

		subMenuList.displayItems();

		System.out.println("Enter choice :");
		int ch = sc.nextInt();

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
		if (ch == 1) {
			listOfAddress.addItem(address);
			System.out.println("Address is added to list !!! ");

		} else if (ch == 2) {
			System.out.println("Enter position to add Address At  :");
			int pos = sc.nextInt();
			try {
				listOfAddress.insertItem(address, pos);
			} catch (NullPointerException e) {
				System.out.println("Position Not Found So Address is Not Added to Address Book.");
			}

			System.out.println("Address is added to list !!! ");

		}

//		sc.close();
	}

}
