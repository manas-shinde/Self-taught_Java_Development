package action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import address.Address;
import list.List;
import menu.MenuItem;

public class SaveAddressBookSpecificName implements Action {
	List<Address> listOfAddress;
	static List<MenuItem> subMenuList = new List<>();
	Action a;
	File newDirectory,newFile;

	public SaveAddressBookSpecificName(List<Address> listOfAddress2) {
		this.listOfAddress = listOfAddress;
	}
	 protected void finalize() {
		 
	 }
	@Override
	public void onAction() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter File Name To AddressBook : ");
		String fileName = sc.next();
		

		String PATH = System.getProperty("user.home");

		newDirectory = new File(PATH, "." + "abook");

		boolean dirFound = newDirectory.mkdir();

		try {
			if (!dirFound) {
				File newFile = new File(newDirectory +"/"+ fileName+".dat");
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
