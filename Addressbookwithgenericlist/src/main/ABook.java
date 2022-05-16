package main;

//import java.util.Scanner;

import menu.ABookMenu;

public class ABook {
	public static void main(String[] args) {
		
		int choice;
		ABookMenu mainObject = new ABookMenu();
		

		do {
			mainObject.display();
			choice = mainObject.awaitUserChoice();
			mainObject.onSelect(choice);
		} while (choice != 0);

		
		System.out.println("**********************End**********************");
	}
}
