package view;

public class DropMyAccountView implements View {

	public int choice() {
		out.println("\n--- È¸¿øÅ»Åð ---");
		out.print("(1) È¸¿øÅ»ÅðÇÏ±â \n(2) È¸¿øÅ»Åð Ãë¼Ò \n\nChoice >  ");
		try {
			return scan.nextInt();
		} catch (Exception e) {
			scan.nextLine();
			return 0;
		}
	}

	public int choice2() {
		out.println("\n--- È¸¿øÅ»Åð ---");
		out.print("(1) ¿¹ \n(2) ¾Æ´Ï¿À \n\nChoice >  ");
		try {
			return scan.nextInt();
		} catch (Exception e) {
			scan.nextLine();
			return 0;
		}
	}

	@Override
	public void show() {
		while (true) {
			int no = choice();
			while (no < 1 || no > 2) {
				System.out.println("\nÀß¸øµÈ ÀÔ·Â!");
				no = choice();
			}
			if (no == 1) {
				scan.nextLine();
				int num = choice2();

				while (num < 1 || num > 2) {
					System.out.println("\nÀß¸øµÈ ÀÔ·Â!");
					num = choice2();
				}

				if (num == 1) {
					request.put("go_init", true);
					request.put("drop", true);
					scan.nextLine();
					return;
				}
			} else {
				request.put("go_init", false);
				request.put("drop", false);
				scan.nextLine();
				return;
			}
		}
	}
}
