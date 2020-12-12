package view;

public class ManagerMainMenu implements View {
	
	public int choice() {
		out.print("\n#### 관리자 메인 ####\n");
		out.print("(1) 전체 영상물 조회 \n(2) 제목으로 검색 \n(3) 조건 검색 \n(4) 전체 평가내역 조회 \n(5) 영상물 정보 등록 \n(6) 영상물 정보 삭제 \n(7) 영상물 감독 정보 변경 \n(8) 영상물 배우 정보 변경 \n(9) 마이페이지 \n(10) 로그아웃 \n\nChoice >  ");
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
		while(no<1 || no>11) {
			System.out.println("\n잘못된 입력!");
			no = choice();
		}
		
		request.put("ManagerMainMenu_selectNo", no);
	}
}
