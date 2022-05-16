package modules;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import addressstore.AddressStore;
import addressstore.MysqlDatabaseAddressStore;

public class DBModule extends AbstractModule {
	@Override
	protected void configure() {
// 		To bind AddressStore class object to MysqlDatabaseAddressStore class object
		bind(AddressStore.class).to(MysqlDatabaseAddressStore.class);
	}
}
