
package action;

import address.Address;
import list.List;

public class DeleteAddress implements Action{

	List<Address> listOfAddress;
	
	public DeleteAddress(List<Address> listOfAddress) {
		this.listOfAddress = listOfAddress;
//		onAction();
	}

	
	public void onAction() {
		listOfAddress.deleteItem(listOfAddress);
		System.out.println("Last Address deleted !!");
		
	}

}
