package main;

import com.google.inject.*;
import modules.ListModule;

public class ABookMain {
	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new ListModule());

		App object = injector.getInstance(App.class);

		object.run();
	}
}
