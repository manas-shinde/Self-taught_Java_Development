package addressstore;

import com.google.inject.Inject;
import address.Address;
import addressio.ConsoleAddressIO;
import list.List;

public class MemoryListAddressStore implements AddressStore {
	List listOfAddress;
	ConsoleAddressIO caio;
	Address address;

	@Inject
	public MemoryListAddressStore(List listOfAddress) {
		this.listOfAddress = listOfAddress;
		caio = new ConsoleAddressIO();
	}

	public void addAddress() {
		address = caio.getAddressFromConsole();
		listOfAddress.addAddress(address);

		System.out.println("Data is saved to List !!!\n------------------");
	}

	public void deleteAddress() {
		listOfAddress.deleteLastAddress();
	}

	public void displayAddress() {
		caio.displayAddressList(listOfAddress);
	}

	public void findAddress() {
		address = listOfAddress.searchByStreet();
		caio.displayAddress(address);
	}

	public void saveAddress() {
		System.out.println(
				"This list is tempory store if you want to store address so that you can you those address afterwards use File OR database choice!!");
	}
}
