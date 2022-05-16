package action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

import address.Address;
import list.List;
import menu.MenuItem;

public class LoadAddressBook implements Action {
	List<Address> listOfAddress;
	static List<MenuItem> subMenuList = new List<>();
	Action a;
	ObjectInputStream oit;
	FileInputStream fin;

	public LoadAddressBook(List<Address> listOfAddress) {
		this.listOfAddress = listOfAddress;
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
//	super.finalize();
		oit.close();
		fin.close();
	}

	@Override
	public void onAction() {
		Scanner sc = new Scanner(System.in);
		String[] pathnames;
		String PATH = System.getProperty("user.home");

		File newDirectory = new File(PATH, "." + "abook");
		boolean dirFound = newDirectory.mkdir();
		pathnames = newDirectory.list();

		// For each pathname in the pathnames array
		for (String pathname : pathnames) {
			// Print the names of files and directories
			System.out.println(pathname);
		}
		System.out.println("Enter File Name load the  AddressBook data: ");
		String fileName = sc.next();

		try {
			if (!dirFound) {
				File newFile = new File(newDirectory + "/" + fileName + ".dat");
				if (newFile.exists()) {
					if (newFile.canRead() && newFile.length() > 0) {
						System.out.println("file Found !!");
						fin = new FileInputStream(newFile);

						oit = new ObjectInputStream(fin);
						try {
							listOfAddress = (List<Address>) oit.readObject();

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

	}

}
