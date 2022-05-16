package menu;

import com.google.inject.Inject;
import menuitem.AddMI;
import menuitem.DeleteMI;
import menuitem.DisplayMI;
import menuitem.FindMI;
import menuitem.SaveMI;
import menuitem.Stop;

public class ABookSubMenu extends SubMenu {
	@Inject
	public ABookSubMenu(AddMI add, DeleteMI delete, DisplayMI display, FindMI find, Stop stop, SaveMI save) {
		super(-1, "Sub Menu");
		addMenuItems(add);
		addMenuItems(display);
		addMenuItems(delete);
		addMenuItems(find);
		addMenuItems(save);
		addMenuItems(stop);
	}

}
