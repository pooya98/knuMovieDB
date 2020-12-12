package view;

public class InsertContentsMenu implements View {
	
	public int choice() {
		out.println("----- 영상물 등록 -----");
		out.print("(1) Movie 등록 \n(2) Episode 등록 \n(3) Version 등록 \n(4) 돌아가기 \n\nChoice > ");
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
		int num = choice();
		
		while(num<0 || num >4) {
			System.out.println("잘못된 입력!");
			num = choice();
		}
		scan.nextLine();
		request.put("insert_contents_select_no", num);
	}

}
