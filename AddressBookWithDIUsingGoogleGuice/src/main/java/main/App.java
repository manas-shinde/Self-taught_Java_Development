package main;

import com.google.inject.Inject;
import menu.ABookMenu;

public class App {
	ABookMenu ab;

	@Inject
	public App(ABookMenu ab) {
		this.ab = ab;
	}

	public void run() {
		int choice;
		do {
			ab.display();
			choice = ab.awaitUserChoice();
			if (choice == 0)
				continue;
			else
				ab.selectAct(choice);

		} while (choice != 0);

	}
}
