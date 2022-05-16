package main;

import menu.ABookMenu;

public class ABook {
	public static void main(String[] args) {

		int choice;
		ABookMenu mainObject = new ABookMenu();

		do {
			mainObject.display();
			choice = mainObject.awaitUserChoice();
			if (choice == 0) {
				continue;
			} else {
				mainObject.onSelect(choice);
			}

		} while (choice != 0);

		System.out.println("**********************End**********************");
	}
}
