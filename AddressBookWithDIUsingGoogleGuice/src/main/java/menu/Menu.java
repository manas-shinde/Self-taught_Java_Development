package menu;

import java.util.ArrayList;
import java.util.Scanner;

import com.google.inject.Inject;

public class Menu extends MenuItem {
	Scanner sc = new Scanner(System.in);
	ArrayList<MenuItem> listOfMenuItem = new ArrayList<MenuItem>();

//	String title;
	public Menu(int ch, String str) {
		super(ch, str, null);
	}

	/**
	 * Displaying menu-item individually by themself
	 */
	public void displayTitle() {
		
		
		System.out.println("  -----------------------------------");
		System.out.println("  |            " + this.title + "           |");
		System.out.println("  -----------------------------------");
//		System.out.println("-----------------" + this.title + "-----------------");
	}

	public void display() {
		displayTitle();
		for (MenuItem mi : listOfMenuItem) {
			mi.display();
		}
	}

	/**
	 * 
	 * Adding @param mi to list of Menu Items
	 */
	public void addMenuItems(MenuItem mi) {
		listOfMenuItem.add(mi);
	}

	/**
	 * Take a input from a user then @return that choice
	 * 
	 */
	public int awaitUserChoice() {

		System.out.println("Enter choice : ");
		int choice = Integer.parseInt(sc.nextLine());

		return choice;
	}

	/**
	 * 
	 * accept @param choice then match the choice with the menu-item choice
	 */

	public void selectAct(int choice) {
		for (MenuItem menuItem : listOfMenuItem) {
			if (choice == menuItem.choice) {// If choice is equal to menu-item choice
				menuItem.selectAct();// then call the selectAct for that menu-item
			}
		}
	}

	@Override
	protected void finalize() throws Throwable {
//		To close the resources
		sc.close();
	}

}
