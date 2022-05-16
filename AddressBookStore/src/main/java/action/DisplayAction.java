package action;

import com.google.inject.Inject;
import addressstore.AddressStore;

public class DisplayAction implements Action {
	AddressStore action;

	@Inject
	public DisplayAction(AddressStore a) {
		this.action = a;
	}

	public void onAction() {
		action.displayAddress();
	}
}
