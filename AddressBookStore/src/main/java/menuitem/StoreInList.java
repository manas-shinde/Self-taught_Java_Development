package menuitem;

import com.google.inject.Inject;
import addressstore.*;
import menu.MenuItem;

public class StoreInList extends MenuItem {
	static String title = "LIST";
	static int choice = 1;
	AddressStore action;

	@Inject
	public StoreInList(MemoryListAddressStore a) {
		super(choice, title, a);
		this.action = a;
	}
}
