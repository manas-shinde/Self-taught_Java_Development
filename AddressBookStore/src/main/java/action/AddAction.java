package action;

import com.google.inject.Inject;
import addressstore.AddressStore;

public class AddAction implements Action {
	AddressStore action;

	@Inject
	public AddAction(AddressStore a) {
		this.action = a;
	}

	public void onAction() {
		action.addAddress();
	}

}
