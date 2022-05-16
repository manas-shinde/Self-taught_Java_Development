package action;

import com.google.inject.Inject;

import address.Address;
import list.List;

public class DisplayAddressAction implements Action {
	List listOfAddress;

	@Inject
	public DisplayAddressAction(List listOfAddress) {
		super();
		this.listOfAddress = listOfAddress;
	}

	public void onAction() {
		listOfAddress.displayItems();
		System.out.println("-------------");
	}

}
