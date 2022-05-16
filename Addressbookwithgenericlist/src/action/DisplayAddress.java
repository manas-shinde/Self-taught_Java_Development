package action;

import address.Address;
import list.List;

public class DisplayAddress implements Action {

	List<Address> listOfAddress;

	public DisplayAddress(List<Address> listOfAddress) {
		this.listOfAddress = listOfAddress;
	}

	public void onAction() {
		System.out.println("******************Address List******************");
		listOfAddress.displayItems();
		System.out.println("*************************************************");

	}

}
