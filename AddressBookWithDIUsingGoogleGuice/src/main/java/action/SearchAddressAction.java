package action;

import java.util.*;
import com.google.inject.Inject;
import list.List;
import menu.*;

public class SearchAddressAction implements Action {
	List listOfAddress;
	ArrayList<MenuItem> subMenu;
	Scanner sc = new Scanner(System.in);
	SearchSubMenu ss;

	@Override
	protected void finalize() throws Throwable {
		sc.close();
	}

	@Inject
	public SearchAddressAction(List listOfAddress, SearchSubMenu ss) {
		this.listOfAddress = listOfAddress;
		this.ss = ss;
		subMenu = ss.getSubMenu();
	}

	public void onAction() {
		ss.displayTitle();
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