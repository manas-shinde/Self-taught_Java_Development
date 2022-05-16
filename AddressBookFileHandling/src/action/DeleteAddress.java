
package action;

import java.util.Scanner;

import address.Address;
import list.List;
import menu.MenuItem;

public class DeleteAddress implements Action {

	List<Address> listOfAddress;
	static List<MenuItem> subMenuList = new List<>();
	Action a;
	Scanner sc = new Scanner(System.in);

	public DeleteAddress(List<Address> listOfAddress) {
		this.listOfAddress = listOfAddress;
//		Creating a Sub-Menu for Deleteting Address by choice
		subMenuList.addItem(new MenuItem("By street ", 1, a = new DeleteAddressByStreet(listOfAddress)));
		subMenuList.addItem(new MenuItem("By state ", 2, a = new DeleteAddressByState(listOfAddress)));
		subMenuList.addItem(new MenuItem("By city ", 3, a = new DeleteAddressByCity(listOfAddress)));
		subMenuList.addItem(new MenuItem("By zipcode ", 4, a = new DeleteAddressByZipcode(listOfAddress)));
		subMenuList.addItem(new MenuItem("Last Address ", 5, a = new DeleteLastAddress(listOfAddress)));
	}

	public void onAction() {
		System.out.println("Delete Address ");
		subMenuList.displayItems();

		System.out.println("Enter Choice : ");
		int ch = sc.nextInt();

		for (int i = 1; i <= 5; i++) {
			MenuItem mi = new MenuItem();

			mi = subMenuList.getData(i);

			if (ch == mi.getOption()) {
				mi.action.onAction();
				break;
			}
		}

	}

	class DeleteAddressByStreet implements Action {

		List<Address> listOfAddress;

		public DeleteAddressByStreet(List<Address> listOfAddress) {
			this.listOfAddress = listOfAddress;
		}

		public void onAction() {
			SearchAddressByStreet ss = new SearchAddressByStreet(listOfAddress);
			ss.onAction();

			boolean streetFound = ss.isStreetFound();
			if (streetFound) {
				System.out.println("Do you want to delete above Address :   Y/N");
				char choice = sc.next().charAt(0);

				if (choice == 'Y' || choice == 'y') {
					listOfAddress.deleteSpecificItem(ss.getAddress());
					System.out.println("Address is deleted from AddressBook!");
				} else if (choice == 'N' || choice == 'n') {
					System.out.println("No operation performed.");
				}
			}

		}

	}

	class DeleteAddressByState implements Action {

		List<Address> listOfAddress;

		public DeleteAddressByState(List<Address> listOfAddress) {
			this.listOfAddress = listOfAddress;
		}

		@Override
		public void onAction() {
			SearchAddressByState ss = new SearchAddressByState(listOfAddress);
			ss.onAction();

			boolean stateFound = ss.isStateFound();
			if (stateFound) {
				System.out.println("Do you want to delete above Address :   Y/N");
				char choice = sc.next().charAt(0);

				if (choice == 'Y' || choice == 'y') {
					listOfAddress.deleteSpecificItem(ss.getAddress());
					System.out.println("Address is deleted from AddressBook!");
				} else if (choice == 'N' || choice == 'n') {
					System.out.println("No operation performed.");
				}
			}

		}
	}

	class DeleteAddressByCity implements Action {

		List<Address> listOfAddress;

		public DeleteAddressByCity(List<Address> listOfAddress) {
			this.listOfAddress = listOfAddress;
		}

		@Override
		public void onAction() {
			SearchAddressByCity ss = new SearchAddressByCity(listOfAddress);
			ss.onAction();

			boolean cityFound = ss.isCityFound();
			if (cityFound) {
				System.out.println("Do you want to delete above Address :   Y/N");
				char choice = sc.next().charAt(0);

				if (choice == 'Y' || choice == 'y') {
					listOfAddress.deleteSpecificItem(ss.getAddress());
					System.out.println("Address is deleted from AddressBook!");
				} else if (choice == 'N' || choice == 'n') {
					System.out.println("No operation performed.");
				}
			}

		}
	}

	class DeleteAddressByZipcode implements Action {

		List<Address> listOfAddress;

		public DeleteAddressByZipcode(List<Address> listOfAddress) {
			this.listOfAddress = listOfAddress;
		}

		@Override
		public void onAction() {
			SearchAddressByZipcode ss = new SearchAddressByZipcode(listOfAddress);
			ss.onAction();

			boolean zipFound = ss.isZipFound();
			if (zipFound) {
				System.out.println("Do you want to delete above Address :   Y/N");
				char choice = sc.next().charAt(0);

				if (choice == 'Y' || choice == 'y') {
					listOfAddress.deleteSpecificItem(ss.getAddress());
					System.out.println("Address is deleted from AddressBook!");
				} else if (choice == 'N' || choice == 'n') {
					System.out.println("No operation performed.");
				}
			}

		}
	}

	class DeleteLastAddress implements Action {
		List<Address> listOfAddress;

		public DeleteLastAddress(List<Address> listOfAddress) {
			this.listOfAddress = listOfAddress;
		}

		@Override
		public void onAction() {
			listOfAddress.deleteItem(listOfAddress);
			System.out.println("Last Address deleted !!");

		}
	}

}
