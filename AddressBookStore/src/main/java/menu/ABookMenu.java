package menu;

import com.google.inject.Inject;

import menuitem.StoreInFile;
import menuitem.Stop;
import menuitem.StoreInDB;
import menuitem.StoreInList;

public class ABookMenu extends Menu {

	@Inject
	public ABookMenu(StoreInList list, StoreInDB database, StoreInFile file, Stop stop) {
		super(-1, " Main Menu");

		addMenuItems(list);
		addMenuItems(file);
		addMenuItems(database);
		addMenuItems(stop);
	}

}
