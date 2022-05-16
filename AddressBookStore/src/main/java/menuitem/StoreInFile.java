package menuitem;

import com.google.inject.Inject;
import addressstore.*;
import menu.MenuItem;

public class StoreInFile extends MenuItem {
	static String title = "FILE ";
	static int choice = 2;
	AddressStore action;

	@Inject
	public StoreInFile(FileBasedAddressStore a) {
		super(choice, title, a);
		this.action = a;
	}
}
