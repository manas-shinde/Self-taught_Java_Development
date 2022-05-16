package action;

import com.google.inject.Inject;
import list.List;

public class DeleteAddressAction implements Action {
	List listOfAddress;

	@Inject
	public DeleteAddressAction(List listOfAddress) {
		this.listOfAddress = listOfAddress;
	}

	public void onAction() {
		listOfAddress.deleteAddress();
		System.out.println("--------------------Last Address is deleted!!!!!!!! --------------------");
	}

}
