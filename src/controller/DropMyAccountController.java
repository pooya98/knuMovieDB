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
				out.println("ȸ�� Ż�� �Ϸ�!");
				out.println(" Ȯ�� (Enter) > ");
				scan.nextLine();
			}
			else {
				out.println("ȸ�� Ż�� ����!");
				out.println(" Ȯ�� (Enter) > ");
				scan.nextLine();
			}*/
		}	
	}
}
