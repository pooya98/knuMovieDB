package controller;

import model.AccountDAO;
import resource.R;

public class ManagerMainController implements R {
	public void process() {

		while (true) {
			
			AccountDAO dao = new AccountDAO();
			
			//dao.getUserInfo();
			managerMainMenu.show();

			scan.nextLine();

			switch ((int) request.get("ManagerMainMenu_selectNo")) {

			case 1:
				showAllMovieController.process();
				break;

			case 2:
				searchByTitleController.process();
				break;
				
			case 3:
				out.println("기능 구현 중입니다.");
				
				out.println(" 확인 (Enter) >");
				scan.nextLine();
				break;
				
			case 4:
				showAllReviewController.process();
				break;
				
			case 5:
				insertContentsController.process();
				break;
				
			case 6:
				deleteContentsController.process();
				break;

			case 7:
				updateDirectorController.process();
				break;
				
			case 8:
				updateActorController.process();
				break;
				
			case 9:
				myPageController.process();
				break;
				
			case 10:
				System.out.println("로그아웃!\n");
				return;
				
			}
		}
	}
}
