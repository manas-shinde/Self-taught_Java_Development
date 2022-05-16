package action;

import com.google.inject.Inject;
import list.List;

public class SearchAddressByState implements Action {
	List listOfAddres;

	@Inject
	public SearchAddressByState(List listOfAddres) {
		this.listOfAddres = listOfAddres;
	}

	public void onAction() {
		listOfAddres.searchByZipcode();
	}

}