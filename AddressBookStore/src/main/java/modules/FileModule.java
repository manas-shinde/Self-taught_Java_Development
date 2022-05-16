package modules;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import addressstore.*;
import list.List;

public class FileModule extends AbstractModule {
	@Override
	protected void configure() {
// 		To bind AddressStore class Object to FileBasedAddressStore class object
		bind(AddressStore.class).to(FileBasedAddressStore.class);
		bind(List.class).in(Singleton.class);
	}
}
