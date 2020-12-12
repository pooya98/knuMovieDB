package view;

public class MyPageMenu implements View {

	public int choice() {
		out.print("\n--- 마이페이지 ---\n");
		out.print("(1) 나의 회원정보 조회 \n(2) 회원정보 수정 \n(3) 비밀번호 수정 \n(4) 회원탈퇴 \n(5) 메인화면으로 돌아가기\n\nChoice >  ");
		try {
			return scan.nextInt();
		}
		catch(Exception e) {
			scan.nextLine();
			return 0;
		}
	}

	@Override
	public void show() {
		
		int no = choice();
		while(no<1 || no>5) {
			System.out.println("\n잘못된 입력!");
			no = choice();
		}
		
		request.put("MyPageMenu_selectNo", no);
	}

}
