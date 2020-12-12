package view;

public class SignUpFailView implements View {

	public int choice() {
		System.out.println("\n회원 가입에 실패했습니다.");
		System.out.print("(1) 재입력 \n(2) 초기화면으로 돌아가기 \n\nChoice > ");
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
		while(no<1 || no>2) {
			System.out.println("\n잘못된 입력!");
			no = choice();
		}
		
		request.put("SignUpFail_selectNo", no);
	}
}
