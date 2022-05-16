package action;

import com.google.inject.Inject;
import addressstore.AddressStore;

public class FindAction implements Action {
	AddressStore action;

	@Inject
	public FindAction(AddressStore a) {
		this.action = a;
	}

	public void onAction() {
		action.findAddress();
	}
}
