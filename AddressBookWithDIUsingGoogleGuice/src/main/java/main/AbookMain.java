package main;

import com.google.inject.Guice;
import com.google.inject.Injector;
import addressmodule.AddressModule;

public class AbookMain {
	public static void main(String[] args) {
		System.out.println(" ======================================");
		System.out.println(" |            ADDRESS BOOK            |");
		System.out.println(" ======================================");		
			Injector i = Guice.createInjector(new AddressModule());
	
			App mainObject = i.getInstance(App.class);
	
			mainObject.run();
		
		System.out.println("*****************END*****************");
	}
}
