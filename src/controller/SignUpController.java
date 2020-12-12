package controller;

import resource.R;

public class SignUpController implements R {

	public void process() {
		while (true) {
			signUpView.show();

			if ((boolean) request.get("signup_input") == false) {
				signUpFailView.show();
				scan.nextLine();
				if((int)request.get("SignUpFail_selectNo") == 2) {
					break;
				}
			} else {
				if(!insertUser.idDuplicationCheck())
				{
					//out.println("중복 없음");
					if(insertUser.insert_user()) {
						out.println("\n회원 가입 성공!\n");
						break;
					}
					else {
						signUpFailView.show();
						scan.nextLine();
						if((int)request.get("SignUpFail_selectNo") == 2) {
							break;
						}
					}
				}else {
					out.println("\n(실패)아이디 중복");
					signUpFailView.show();
					scan.nextLine();
					if((int)request.get("SignUpFail_selectNo") == 2) {
						break;
					}
				}
				break;
			}
		}
	}
}
