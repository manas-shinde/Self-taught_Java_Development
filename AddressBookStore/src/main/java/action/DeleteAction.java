package action;

import com.google.inject.Inject;
import addressstore.AddressStore;

public class DeleteAction implements Action {
	AddressStore action;

	@Inject
	public DeleteAction(AddressStore a) {
		this.action = a;
	}

	public void onAction() {
		action.deleteAddress();

	}

}
