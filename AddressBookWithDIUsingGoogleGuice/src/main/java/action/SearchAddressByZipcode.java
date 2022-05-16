package action;

import com.google.inject.Inject;
import list.List;

public class SearchAddressByZipcode implements Action {
	List listOfAddres;

	@Inject
	public SearchAddressByZipcode(List listOfAddres) {
		this.listOfAddres = listOfAddres;
	}

	public void onAction() {
		listOfAddres.searchByZipcode();
	}

}