package view;

public class MyPageMenu implements View {

	public int choice() {
		out.print("\n--- ���������� ---\n");
		out.print("(1) ���� ȸ������ ��ȸ \n(2) ȸ������ ���� \n(3) ��й�ȣ ���� \n(4) ȸ��Ż�� \n(5) ����ȭ������ ���ư���\n\nChoice >  ");
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
			System.out.println("\n�߸��� �Է�!");
			no = choice();
		}
		
		request.put("MyPageMenu_selectNo", no);
	}

}
