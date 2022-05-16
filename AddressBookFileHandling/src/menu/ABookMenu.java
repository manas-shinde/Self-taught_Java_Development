package menu;

import list.List;
import java.io.*;
import java.util.Scanner;
import action.*;
import address.Address;

public class ABookMenu extends Menu {

	static List<MenuItem> list = new List<>();
	static List<Address> listOfAddress = new List<>();

	Action a;
	static int choice;

	// Initializer block starts..
	{
		String PATH = System.getProperty("user.home");

		File newDirectory = new File(PATH, "." + "abook");

		boolean dirFound = newDirectory.mkdir();
		try {
			if (!dirFound) {
				File newFile = new File(newDirectory + "/address.dat");
				if (newFile.exists()) {
					if (newFile.canRead() && newFile.length() > 0) {
						System.out.println("Default AddressBook file loaded "+newFile.getName());
						FileInputStream fin = new FileInputStream(newFile);

						ObjectInputStream oit = new ObjectInputStream(fin);
						try {
							listOfAddress = (List<Address>) oit.readObject();
							oit.close();
							fin.close();

						} catch (ClassNotFoundException e) {
							System.out.println("exception occured!!!");
						}
						
					} else {
						System.out.println("AddressBook is empty!!");
					}

				} else {
					System.out.println("File created: " + newFile.getName());
					newFile.createNewFile();
				}

			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		// This code is executed before every constructor.
		list.addItem(new MenuItem("ADD ", 1, a = new AddAddress(listOfAddress)));
		list.addItem(new MenuItem("DISPLAY", 2, a = new DisplayAddress(listOfAddress)));
		list.addItem(new MenuItem("DELETE", 3, a = new DeleteAddress(listOfAddress)));
		list.addItem(new MenuItem("SEARCH ", 4, a = new SearchAddress(listOfAddress)));
		list.addItem(new MenuItem("SAVE ADDRESS TO FILE ", 5, a = new SaveAddressBook(listOfAddress)));
		list.addItem(new MenuItem("SAVE ADDRESS TO   SPECIFIC FILE ", 6,
				a = new SaveAddressBookSpecificName(listOfAddress)));
		list.addItem(new MenuItem("LOAD ADDRESSBOOK FROM FILE ", 7, a = new LoadAddressBook(listOfAddress)));
		list.addItem(new MenuItem("STOP", 0, a));
	}

	// Initializer block ends
	public ABookMenu() {

	}

	public void display() {
		list.displayItems();

	}

	public int awaitUserChoice() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter choice : ");
		choice = Integer.parseInt(sc.nextLine());

		return choice;
	}

	public void onSelect(int choice) {

		MenuItem mi = null;

		for (int i = 1; i <= list.totalItem(); i++) {
			mi = list.getData(i);

			if (choice == mi.option) {
				mi.selectAct();
				break;
			}
		}

	}
}
