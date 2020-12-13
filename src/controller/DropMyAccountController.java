package controller;

import model.AccountDAO;
import resource.R;

public class DropMyAccountController implements R {
	public void process() {
		dropMyAccountView.show();
		
		if((boolean)request.get("drop") == true) {
			AccountDAO dao = new AccountDAO();
			/*
			if(dao.dropAccount() == true) {
				out.println("È¸¿ø Å»Åð ¿Ï·á!");
				out.println(" È®ÀÎ (Enter) > ");
				scan.nextLine();
			}
			else {
				out.println("È¸¿ø Å»Åð ½ÇÆÐ!");
				out.println(" È®ÀÎ (Enter) > ");
				scan.nextLine();
			}*/
		}	
	}
}
