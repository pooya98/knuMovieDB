package view;

public class UserMainMenu implements View {
	
	public int choice() {
		out.print("\n#### 사용자 메인 ####\n");
		out.print("(1) 전체 영상물 조회 \n(2) 제목으로 검색 \n(3) 조건 검색 \n(4) 나의 평가내역 조회 \n(5) 마이페이지 \n(6) 로그아웃\n\nChoice >  ");
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
		while(no<1 || no>6) {
			System.out.println("\n잘못된 입력!");
			no = choice();
		}
		
		request.put("UserMainMenu_selectNo", no);
	}

}
