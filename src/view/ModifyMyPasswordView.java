package view;

public class ModifyMyPasswordView implements View {

	public int choice() {
		System.out.println("\n���ο� ��й�ȣ�� ���ο� ��й�ȣ Ȯ���� �ٸ��ϴ�.");
		System.out.print("(1) ���Է� \n(2) ��й�ȣ ���� ��� \n\nChoice > ");
		try {
			return scan.nextInt();
		} catch (Exception e) {
			scan.nextLine();
			return 0;
		}
	}

	public int choice2() {
		System.out.println("\n���� ��й�ȣ�� �ùٸ��� �ʽ��ϴ�.");
		System.out.print("(1) ���Է� \n(2) ��й�ȣ ���� ��� \n\nChoice > ");
		try {
			return scan.nextInt();
		} catch (Exception e) {
			scan.nextLine();
			return 0;
		}
	}

	@Override
	public void show() {
		
	}
	public boolean show2() {
		int no = 0;

		String temp_pw;

		String new_pw;
		String new_pw_check;
		out.println("\n--- ��й�ȣ ���� ---");
		while (true) {
			out.println("���� ��й�ȣ : ");

			temp_pw = scan.nextLine();

			if (temp_pw.equals(request.get("client_password").toString())) {
				while (true) {
					out.println("���ο� ��й�ȣ     : ");
					new_pw = scan.nextLine();
					out.println("���ο� ��й�ȣ Ȯ�� : ");
					new_pw_check = scan.nextLine();

					if (new_pw.equals(new_pw_check)) {
						request.put("new_pw", new_pw);
						return true;
					} else {
						no = choice();
						
						while(no<1 || no>2) {
							System.out.println("\n�߸��� �Է�!");
							no = choice();
						}
							
						if (no == 2)
							return false;
						
						scan.nextLine();
					}
				}
			} else {
				no = choice2();
				while(no<1 || no>2) {
					System.out.println("\n�߸��� �Է�!");
					no = choice2();
				}
				if (no == 2)
					return false;
				
				scan.nextLine();
			}

		}
	}
}
