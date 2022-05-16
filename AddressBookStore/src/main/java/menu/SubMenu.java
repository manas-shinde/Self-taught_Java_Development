package menu;

import java.util.ArrayList;
import java.util.Scanner;

public class SubMenu extends MenuItem {

	ArrayList<MenuItem> listOfSubMenu = new ArrayList<MenuItem>();

	public SubMenu(int ch, String str) {
		super(ch, str, null);
	}

	/*
	 * @Override protected void finalize() throws Throwable { sc.close();
	 * 
	 * }
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	public void displayTitle() {
		System.out.println("  -----------------------------------");
		System.out.println("  |            " + this.title + "           |");
		System.out.println("  -----------------------------------");
	}

	public void display() {
		displayTitle();
		for (MenuItem mi : listOfSubMenu) {
			mi.display();
		}
	}

	public int awaitUserChoice() {
		int choice;

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter choice : ");
		choice = sc.nextInt();

		return choice;

	}

	public void selectAct(int choice) {
		for (MenuItem menuItem : listOfSubMenu) {
			if (choice == menuItem.choice) {// If choice is equal to menu-item choice
				menuItem.selectAct();// then call the selectAct for that menu-item
			}
		}
	}

	public void addMenuItems(MenuItem mi) {
		listOfSubMenu.add(mi);
	}
}
