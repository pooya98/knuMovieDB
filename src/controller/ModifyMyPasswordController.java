package controller;

import model.AccountDAO;
import resource.R;

public class ModifyMyPasswordController implements R {

	public void process() {
		if(modifyMyPasswordView.show2()) {
			AccountDAO dao = new AccountDAO();
			
			if(dao.modify_password()) {
				request.put("client_password", request.get("new_pw"));
				out.println("��й�ȣ ���� ����!");
				
				out.println("\n Ȯ��(Enter) >");
				
				scan.nextLine();
			}
			else {
				out.println("��й�ȣ ���� ����!");
				
				out.println("\n Ȯ��(Enter) >");
				
				scan.nextLine();
			}
		}
	}
}
