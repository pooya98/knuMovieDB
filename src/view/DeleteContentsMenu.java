package view;

public class DeleteContentsMenu implements View {
	
	public int choice() {
		out.println("\n----- ���� ���� -----");
		out.print("(1) Movie ���� \n(2) Episode ���� \n(3) Version ���� \n(4) ���ư��� \n\nChoice > ");
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
			System.out.println("�߸��� �Է�!");
			num = choice();
		}
		scan.nextLine();
		request.put("delete_contents_select_no", num);
	}
}
