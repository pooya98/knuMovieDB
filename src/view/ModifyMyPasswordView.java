package view;

public class ModifyMyPasswordView implements View {

	public int choice() {
		System.out.println("\n새로운 비밀번호와 새로운 비밀번호 확인이 다릅니다.");
		System.out.print("(1) 재입력 \n(2) 비밀번호 수정 취소 \n\nChoice > ");
		try {
			return scan.nextInt();
		} catch (Exception e) {
			scan.nextLine();
			return 0;
		}
	}

	public int choice2() {
		System.out.println("\n현재 비밀번호가 올바르지 않습니다.");
		System.out.print("(1) 재입력 \n(2) 비밀번호 수정 취소 \n\nChoice > ");
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
		out.println("\n--- 비밀번호 수정 ---");
		while (true) {
			out.println("현재 비밀번호 : ");

			temp_pw = scan.nextLine();

			if (temp_pw.equals(request.get("client_password").toString())) {
				while (true) {
					out.println("새로운 비밀번호     : ");
					new_pw = scan.nextLine();
					out.println("새로운 비밀번호 확인 : ");
					new_pw_check = scan.nextLine();

					if (new_pw.equals(new_pw_check)) {
						request.put("new_pw", new_pw);
						return true;
					} else {
						no = choice();
						
						while(no<1 || no>2) {
							System.out.println("\n잘못된 입력!");
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
					System.out.println("\n잘못된 입력!");
					no = choice2();
				}
				if (no == 2)
					return false;
				
				scan.nextLine();
			}

		}
	}
}
