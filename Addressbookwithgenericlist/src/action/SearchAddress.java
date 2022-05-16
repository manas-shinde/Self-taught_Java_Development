package action;

import java.util.Scanner;

import address.Address;
import list.List;
import menu.MenuItem;

public class SearchAddress implements Action {

	static List<Address> listOfAddress;
	static List<MenuItem> subMenuList = new List<>();
	Action a;

	public SearchAddress(List<Address> listOfAddress) {
		this.listOfAddress = listOfAddress;
		subMenuList.addItem(new MenuItem("By street ", 1, a));
		subMenuList.addItem(new MenuItem("By state ", 2, a));
		subMenuList.addItem(new MenuItem("By city ", 3, a));
		subMenuList.addItem(new MenuItem("By zipcode ", 4, a));
	}

	public void onAction() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Search Address ");

		subMenuList.displayItems();

		System.out.println("Enter Choice :");
		int choice = sc.nextInt();
		
		
		
//		for(int i=1;i<5;i++) {
//			if(choice == i) {
//				listOfAddress.searchAddress(listOfAddress,choice);
//			}
//		}

	}
}
