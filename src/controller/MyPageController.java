package controller;

import resource.R;

public class MyPageController implements R {

	public void process() {

		while (true) {
			myPageMenu.show();
			
			scan.nextLine();

			switch ((int) request.get("MyPageMenu_selectNo")) {

			case 1:
				showMyInfoView.show();
				break;

			case 2:
				modifyMyInfoController.process();
				break;
				
			case 3:
				modifyMyPasswordController.process();
				break;
				
			case 4:
				dropMyAccountController.process();		
				
				if((boolean)request.get("go_init") == true) {
					return;
				}
				break;

			case 5:
				return;
			}
		}
	}
}
