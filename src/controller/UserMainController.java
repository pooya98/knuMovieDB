package controller;

import model.AccountDAO;
import model.MovieDAO;
import resource.R;

public class UserMainController implements R{

	public void process() {
		request.put("rate_success",false);

		while (true) {
			
			AccountDAO dao = new AccountDAO();
			
			dao.getUserInfo();
			
			userMainMenu.show();

			scan.nextLine();

			switch ((int) request.get("UserMainMenu_selectNo")) {

			case 1:
				showAllMovieController.process();
				break;
			case 2:
				searchByTitleController.process();
				
				if((boolean)request.get("rate_success")  == true) {
					request.put("rate_success",false);
				}
				break;
				
			case 3:
				//conditionSearchController.process();
				out.println("기능 구현 중입니다.");
				
				out.println(" 확인 (Enter) >");
				scan.nextLine();
				break;
				
			case 4:
				showMyReviewController.process();
				break;
				
			case 5:
				myPageController.process();
				
				if((boolean)request.get("go_init") == true) {
					return;
				}
				break;

			case 6:
				System.out.println("로그아웃!\n");
				return;
			}
		}
	}
}
