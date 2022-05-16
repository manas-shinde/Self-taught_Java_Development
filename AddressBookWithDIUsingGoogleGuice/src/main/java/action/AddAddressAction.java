package action;

import java.util.*;
import list.List;
import menu.AddSubMenu;
import menu.MenuItem;
import com.google.inject.*;

public class AddAddressAction implements Action {
	List listOfAddress;
	ArrayList<MenuItem> subMenu;
	Scanner sc = new Scanner(System.in);
	AddSubMenu as;

	@Override
	protected void finalize() throws Throwable {
		sc.close();
	}

	@Inject
	public AddAddressAction(List listOfAddress, AddSubMenu as) {
		this.listOfAddress = listOfAddress;
		this.as = as;
		subMenu = as.getSubMenu();
	}

	public void onAction() {
		as.displayTitle();
		for (MenuItem mi : subMenu) {
			mi.display();
		}
		System.out.println("Enter Choice : ");
		int choice = sc.nextInt();
		for (MenuItem mi : subMenu) {
			if (choice == mi.getChoice()) {
				mi.selectAct();
			}
		}
	}
}
