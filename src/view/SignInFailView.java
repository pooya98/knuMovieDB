package view;

public class SignInFailView implements View{
	
	public int choice() {
		System.out.println("��ϵ��� ���� ����� �Դϴ�.");
		System.out.print("(1) ���Է� \n(2) �ʱ�ȭ������ ���ư��� \n\nChoice > ");
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
			System.out.println("\n�߸��� �Է�!");
			no = choice();
		}
		
		request.put("SignInFail_selectNo", no);
	}
	
}