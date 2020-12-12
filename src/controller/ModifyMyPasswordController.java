package controller;

import model.AccountDAO;
import resource.R;

public class ModifyMyPasswordController implements R {

	public void process() {
		if(modifyMyPasswordView.show2()) {
			AccountDAO dao = new AccountDAO();
			
			if(dao.modify_password()) {
				request.put("client_password", request.get("new_pw"));
				out.println("비밀번호 변경 성공!");
				
				out.println("\n 확인(Enter) >");
				
				scan.nextLine();
			}
			else {
				out.println("비밀번호 변경 실패!");
				
				out.println("\n 확인(Enter) >");
				
				scan.nextLine();
			}
		}
	}
}
