package view;

public class UserMainMenu implements View {
	
	public int choice() {
		out.print("\n#### ����� ���� ####\n");
		out.print("(1) ��ü ���� ��ȸ \n(2) �������� �˻� \n(3) ���� �˻� \n(4) ���� �򰡳��� ��ȸ \n(5) ���������� \n(6) �α׾ƿ�\n\nChoice >  ");
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
			System.out.println("\n�߸��� �Է�!");
			no = choice();
		}
		
		request.put("UserMainMenu_selectNo", no);
	}

}
