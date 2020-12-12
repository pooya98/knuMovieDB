package controller;

import resource.R;

public class SignInController implements R{
	
	String id;
	String pw;
	String type;
	boolean exist_flag;
	
	public void process() {


		while (true) {
			signInView.show();
			
			id = request.get("id").toString();
			pw = request.get("pw").toString();
			
			exist_flag = checkUser.Exist(id, pw);
			
			if(exist_flag) {
				System.out.println("로그인 성공!\n");
				type = request.get("user_type").toString();
				
				if(type.equals("U"))
					userMainController.process();
				else {
					managerMainController.process();
				}
				break;
			}
			else {
				System.out.println("로그인 실패!\n");
				signInFailView.show();
				
				scan.nextLine();
				
				if((int)request.get("SignInFail_selectNo") == 2) {
					break;
				}
			}
			
		}
		System.out.println("\n");
	}
}
