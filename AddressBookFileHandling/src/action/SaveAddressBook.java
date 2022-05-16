package action;

import java.io.*;
import address.Address;
import list.List;
import menu.MenuItem;

public class SaveAddressBook implements Action {
	List<Address> listOfAddress;
	static List<MenuItem> subMenuList = new List<>();
	Action a;

	/**
	 * 
	 * @param listOfAddress
	 */
	public SaveAddressBook(List<Address> listOfAddress) {
		this.listOfAddress = listOfAddress;
	}

	@Override
	public void onAction() {
		
		String PATH = System.getProperty("user.home");

		File newDirectory = new File(PATH, "." + "abook");

		boolean dirFound = newDirectory.mkdir();

		try {
			if (!dirFound) {
				File newFile = new File(newDirectory + "/address.dat");
				if (newFile.exists()) {
					System.out.println("File created: " + newFile.getName());
				} else {
					System.out.println("File already exists.");
				}
				FileOutputStream fout = new FileOutputStream(newFile);
				ObjectOutputStream oot = new ObjectOutputStream(fout);
				oot.writeObject(listOfAddress);
				oot.close();
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}

}
