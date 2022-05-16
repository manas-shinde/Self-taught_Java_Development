package addressmodule;

import list.List;
import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

public class AddressModule extends AbstractModule {
	@Override
	protected void configure() {
		// Make a List Single instance for lifetime of the application.
		bind(List.class).in(Scopes.SINGLETON);
	}
}
