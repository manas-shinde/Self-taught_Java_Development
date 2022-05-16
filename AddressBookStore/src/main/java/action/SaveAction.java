package action;

import com.google.inject.Inject;
import addressstore.AddressStore;

public class SaveAction implements Action {
	AddressStore action;

	@Inject
	public SaveAction(AddressStore a) {
		this.action = a;
	}

	public void onAction() {
		System.out.println("Hello there!!!");
		action.saveAddress();

	}

}