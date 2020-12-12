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
					//out.println("�ߺ� ����");
					if(insertUser.insert_user()) {
						out.println("\nȸ�� ���� ����!\n");
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
					out.println("\n(����)���̵� �ߺ�");
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
