package menu;

import com.google.inject.Inject;

import menuitemclass.*;

public class ABookMenu extends Menu {

	@Inject
	public ABookMenu(AddMenuItem addMenuItem, DisplayMenuItem displayMenuItem, DeleteMenuItem deleteMenuItem,
			StopMenuItem stop, SearchMenuItem searchMenuItem) {
		super(-1, " Main Menu");

		addMenuItems(addMenuItem);
		addMenuItems(displayMenuItem);
		addMenuItems(deleteMenuItem);
		addMenuItems(searchMenuItem);
		addMenuItems(stop);
	}

}
