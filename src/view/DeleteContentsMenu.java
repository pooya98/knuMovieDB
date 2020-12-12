package view;

public class DeleteContentsMenu implements View {
	
	public int choice() {
		out.println("\n----- 영상물 삭제 -----");
		out.print("(1) Movie 삭제 \n(2) Episode 삭제 \n(3) Version 삭제 \n(4) 돌아가기 \n\nChoice > ");
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
		request.put("delete_contents_select_no", num);
	}
}
