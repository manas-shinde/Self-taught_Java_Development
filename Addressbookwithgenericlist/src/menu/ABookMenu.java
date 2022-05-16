package menu;

import list.List;

import java.util.Scanner;

import action.*;
import address.Address;

public class ABookMenu extends Menu {

	static List<MenuItem> list = new List<>();
	static List<Address> listOfAddress = new List<>();

	Action a;
	static int choice;

	public ABookMenu() {

		list.addItem(new MenuItem("ADD ", 1, a = new AddAddress(listOfAddress)));
		list.addItem(new MenuItem("DISPLAY", 2, a = new DisplayAddress(listOfAddress)));
		list.addItem(new MenuItem("DELETE", 3, a = new DeleteAddress(listOfAddress)));
		list.addItem(new MenuItem("SEARCH ", 4, a = new SearchAddress(listOfAddress)));
		list.addItem(new MenuItem("STOP", 0, a));
	}

	public void display() {
		list.displayItems();
//		if(list.getData(0) instanceof MenuItem) {
//			while(list.hasNext(list)) {
//				
//			}
//		}
	}

	public int awaitUserChoice() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter choice : ");
		choice = Integer.parseInt(sc.nextLine());
		
		return choice;
	}

	public void onSelect(int choice) {

		MenuItem mi = new MenuItem();

		for (int i = 0; i < 5; i++) {
			mi = list.getData(i);

			if (choice == mi.option) {
				mi.action.onAction();
				break;
			}
		}

	}
}
