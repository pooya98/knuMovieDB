package view;

public class ManagerMainMenu implements View {
	
	public int choice() {
		out.print("\n#### ������ ���� ####\n");
		out.print("(1) ��ü ���� ��ȸ \n(2) �������� �˻� \n(3) ���� �˻� \n(4) ��ü �򰡳��� ��ȸ \n(5) ���� ���� ��� \n(6) ���� ���� ���� \n(7) ���� ���� ���� ���� \n(8) ���� ��� ���� ���� \n(9) ���������� \n(10) �α׾ƿ� \n\nChoice >  ");
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
			System.out.println("\n�߸��� �Է�!");
			no = choice();
		}
		
		request.put("ManagerMainMenu_selectNo", no);
	}
}
