package main;

import com.google.inject.*;
import menu.ABookMenu;
import menu.ABookSubMenu;
import menu.SubMenu;
import modules.*;

public class App {
	Injector injector;
	ABookMenu mainObject;
	SubMenu sm;
	int choice, subChoice;

	@Inject
	public App(ABookMenu menu, ABookSubMenu sm) {
		this.mainObject = menu;
		this.sm = sm;
	}

	public void doOpertaion() {
		do {
			sm.display();
			subChoice = sm.awaitUserChoice();
			if (subChoice == 0)
				continue;
			else
				sm.selectAct(subChoice);

		} while (subChoice != 0);
	}

	public void run() {

		do {
			mainObject.display();
			choice = mainObject.awaitUserChoice();

			switch (choice) {
			case 1:
				injector = Guice.createInjector(new ListModule());
				sm = injector.getInstance(ABookSubMenu.class);
				sm.setTitle("List Sub-Menu");
				doOpertaion();
				break;
			case 2:
				injector = Guice.createInjector(new FileModule());
				sm = injector.getInstance(ABookSubMenu.class);
				sm.setTitle("File Sub-Menu");
				doOpertaion();
				break;
			case 3:
				injector = Guice.createInjector(new DBModule());
				sm = injector.getInstance(ABookSubMenu.class);
				sm.setTitle("Database Sub-Menu");
				doOpertaion();
				break;
			case 0:
				System.out.println("******************END*****************");
				break;
			default:
				System.out.println("Invalid choice !!!");
			}
		} while (choice != 0);

	}
}
