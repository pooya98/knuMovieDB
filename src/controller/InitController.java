package controller;

import resource.R;

public class InitController implements R {

	public void process() {
		request.put("go_init", false);

		while (true) {
			if((boolean)request.get("go_init") == true) {
				request.put("go_init", false);
			}
			
			initmenu.show();

			scan.nextLine();

			switch ((int) request.get("initMenu_selectNo")) {

			case 1:
				signInController.process();
				break;

			case 2:
				signUpController.process();
				break;

			case 3:
				System.out.println("시스템 종료");
				return;
			}
		}
	}
}
