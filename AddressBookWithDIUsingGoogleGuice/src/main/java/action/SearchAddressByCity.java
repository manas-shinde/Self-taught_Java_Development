package action;

import com.google.inject.Inject;
import list.List;

public class SearchAddressByCity implements Action {
	List listOfAddres;

	@Inject
	public SearchAddressByCity(List listOfAddres) {
		this.listOfAddres = listOfAddres;
	}

	public void onAction() {
		listOfAddres.searchByCity();
	}

}