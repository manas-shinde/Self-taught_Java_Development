package modules;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import list.List;
import addressstore.AddressStore;
import addressstore.MemoryListAddressStore;

public class ListModule extends AbstractModule {
	@Override
	protected void configure() {
		bind(AddressStore.class).to(MemoryListAddressStore.class);
		bind(List.class).in(Singleton.class);
	}
}
