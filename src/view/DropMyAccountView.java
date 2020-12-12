package view;

public class DropMyAccountView implements View {

	public int choice() {
		out.println("\n--- ȸ��Ż�� ---");
		out.print("(1) ȸ��Ż���ϱ� \n(2) ȸ��Ż�� ��� \n\nChoice >  ");
		try {
			return scan.nextInt();
		} catch (Exception e) {
			scan.nextLine();
			return 0;
		}
	}

	public int choice2() {
		out.println("\n--- ȸ��Ż�� ---");
		out.print("(1) �� \n(2) �ƴϿ� \n\nChoice >  ");
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
				System.out.println("\n�߸��� �Է�!");
				no = choice();
			}
			if (no == 1) {
				scan.nextLine();
				int num = choice2();

				while (num < 1 || num > 2) {
					System.out.println("\n�߸��� �Է�!");
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
