package view;

public class ShowMyInfoView implements View {

	@Override
	public void show() {
		out.print("\n--- ���� ȸ������ ��ȸ ---\n");
		
		out.println("�� ��     : "+request.get("client_name").toString());
		out.println("�� ��     : "+request.get("client_sex").toString());
		out.println("����ó    : "+request.get("client_contact").toString());
		out.println("�� ��     : "+request.get("client_address").toString());
		out.println("�������   : "+request.get("client_birth").toString());
		out.println("����      : "+request.get("client_job").toString());
		if(request.get("client_type").toString().equals("U")) {
			out.println("����� ��� : "+request.get("client_membership").toString());
		
		}
		out.println("\nȮ�� �Ϸ�(Enter) >");
		scan.nextLine();

	}
	

}
