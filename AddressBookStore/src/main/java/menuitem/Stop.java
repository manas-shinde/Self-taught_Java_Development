package menuitem;

import addressstore.AddressStore;
import menu.MenuItem;

public class Stop extends MenuItem {
	static String title = "STOP";
	static int choice = 0;
	static AddressStore action = null;

	public Stop() {
		super(choice, title, action);
	}
}
