package addressstore;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.google.inject.Inject;
import address.Address;
import addressio.ConsoleAddressIO;
import list.List;
import java.io.*;

public class FileBasedAddressStore implements AddressStore {
	List listOfAddress;
	ConsoleAddressIO caio;
	Address address;

	@Inject
	public FileBasedAddressStore(List listOfAddress) {
		this.listOfAddress = listOfAddress;
		caio = new ConsoleAddressIO();
		loadFile();
	}

	public void addAddress() {

		address = caio.getAddressFromConsole();
		listOfAddress.addAddress(address);
		System.out.println("Address is added to File !!! ");
	}

	public void deleteAddress() {

		String PATH = System.getProperty("user.home");

		File newDirectory = new File(PATH, "." + "abookbook");

		boolean dirFound = newDirectory.mkdir();
		try{
			if(!dirFound){
				File newFile = new File(newDirectory + "/addressbook.dat");
				if(newFile.canRead() && newFile.length() > 0){
					 FileWriter fwOb = new FileWriter("FileName", false); 
						PrintWriter pwOb = new PrintWriter(fwOb, false);
						pwOb.flush();
						pwOb.close();
						fwOb.close();
				}else{
					System.out.println("File is Empty!!!!!!");
				}
			}
		}catch(IOException io){
			System.out.println(io);
		}
		
	}

	public void displayAddress() {
		caio.displayAddressList(listOfAddress);
	}

	public void loadFile() {
		String PATH = System.getProperty("user.home");

		File newDirectory = new File(PATH, "." + "abookbook");

		boolean dirFound = newDirectory.mkdir();
		try {
			if (!dirFound) {
				File newFile = new File(newDirectory + "/addressbook.dat");
				if (newFile.exists()) {
					if ( newFile.length() > 0) {
						System.out.println("Default AddressBook file loaded " + newFile.getName());
						FileInputStream fin = new FileInputStream(newFile);
						ObjectInputStream oit = new ObjectInputStream(fin);
						try {
							listOfAddress = (List) oit.readObject();
							oit.close();
							fin.close();
							System.out.println("Previous Address loaded !!!");
						} catch (ClassNotFoundException e) {
							System.out.println("exception occured!!!");
						}
					} else {
						System.out.println("Prevoius AddressBook List is empty!!");
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

	public void findAddress() {
		address = listOfAddress.searchByState();
		caio.displayAddress(address);
	}

	public void saveAddress() {
		String PATH = System.getProperty("user.home");

		File newDirectory = new File(PATH, "." + "abookbook");

		boolean dirFound = newDirectory.mkdir();

		try {
			if (!dirFound) {
				File newFile = new File(newDirectory + "/addressbook.dat");
				if (newFile.exists()) {
					System.out.println("File created: " + newFile.getName());
				} else {
					System.out.println("File already exists.");
				}
				FileOutputStream fout = new FileOutputStream(newFile);
				ObjectOutputStream oot = new ObjectOutputStream(fout);
				oot.writeObject(listOfAddress);
				oot.close();
				System.out.println("Address Save to File " + newFile + " Successfully!!");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

}
