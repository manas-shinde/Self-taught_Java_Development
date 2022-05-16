package menuitem;

import com.google.inject.Inject;
import addressstore.*;
import menu.MenuItem;

public class StoreInDB extends MenuItem {
	static String title = "DATABASE";
	static int choice = 3;
	AddressStore action;

	@Inject
	public StoreInDB(MysqlDatabaseAddressStore a) {
		super(choice, title, a);
		this.action = a;
	}
}
