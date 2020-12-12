package controller;

import model.AccountDAO;
import resource.R;

public class ModifyMyInfoController implements R {
	public void process() {

		while (true) {
			modifyMyInfoView.show();

			scan.nextLine();

			switch ((int) request.get("ModifyMyInfoView_selectNo")) {

			case 1:
				if(modifyMyInfoView.name() == true) {
					AccountDAO dao = new AccountDAO();
					
					if(dao.modify_info("NAME", request.get("new_name").toString())) {
						request.put("client_name", request.get("new_name"));
						out.println("[���ο� �̸� : "+request.get("new_name")+"]");
						out.println("�̸� ���� ����!");
						
						out.println("\n Ȯ��(Enter) >");
						
						scan.nextLine();
					}
					else {
						out.println("�̸� ���� ����!");
						
						out.println("\n Ȯ��(Enter) >");
						
						scan.nextLine();
					}
				}
				else {
					out.println("�̸� ���� ���");
					out.println(" Ȯ�� (Enter) >");
					scan.nextLine();
				}
				break;

			case 2:
				if(modifyMyInfoView.contact() == true) {
					AccountDAO dao = new AccountDAO();
					
					if(dao.modify_info("CONTACT", request.get("new_contact").toString())) {
						request.put("client_contact", request.get("new_contact"));
						out.println("[���ο� ����ó : "+request.get("new_contact")+"]");
						out.println("����ó ���� ����!");
						
						out.println("\n Ȯ��(Enter) >");
						
						scan.nextLine();
					}
					else {
						out.println("����ó ���� ����!");
						
						out.println("\n Ȯ��(Enter) >");
						
						scan.nextLine();
					}
				}
				else {
					out.println("����ó ���� ���");
					out.println("Ȯ�� (Enter) >");
					scan.nextLine();
				}
				break;
				
			case 3:
				if(modifyMyInfoView.address() == true) {
					AccountDAO dao = new AccountDAO();
					
					if(dao.modify_info("ADDRESS", request.get("new_address").toString())) {
						request.put("client_address", request.get("new_address"));
						out.println("[���ο� �ּ� : "+request.get("new_address")+"]");
						out.println("�ּ� ���� ����!");
						
						out.println("\n Ȯ��(Enter) >");
						
						scan.nextLine();
					}
					else {
						out.println("�ּ� ���� ����!");
						
						out.println("\n Ȯ��(Enter) >");
						
						scan.nextLine();
					}
				}
				else {
					out.println("�ּ� ���� ���");
					out.println("Ȯ�� (Enter) >");
					scan.nextLine();
				}
				break;
				
			case 4:
				if(modifyMyInfoView.sex() == true) {
					AccountDAO dao = new AccountDAO();
					
					if(dao.modify_info("SEX", request.get("new_sex").toString())) {
						request.put("client_sex", request.get("new_sex"));
						out.println("[���ο� ���� : "+request.get("new_sex")+"]");
						out.println("���� ���� ����!");
						
						out.println("\n Ȯ��(Enter) >");
						
						scan.nextLine();
					}
					else {
						out.println("���� ���� ����!");
						
						out.println("\n Ȯ��(Enter) >");
						
						scan.nextLine();
					}
				}
				else {
					out.println("���� ���� ���");
					out.println(" Ȯ�� (Enter) >");
					scan.nextLine();
				}
				break;
				
			case 5:
				if(modifyMyInfoView.birth()) {
					AccountDAO dao = new AccountDAO();
					
					if(dao.modify_info("BIRTH", request.get("new_birth").toString())) {
						request.put("client_birth", request.get("new_birth"));
						out.println("[���ο� ������� : "+request.get("new_birth")+"]");
						out.println("������� ���� ����!");
						
						out.println("\n Ȯ��(Enter) >");
						
						scan.nextLine();
					}
					else {
						out.println("������� ���� ����!");
						
						out.println("\n Ȯ��(Enter) >");
						
						scan.nextLine();
					}
				}
				else {
					out.println("������� ���� ���");
					out.println(" Ȯ�� (Enter) >");
					scan.nextLine();
				}
				break;

			case 6:
				if(modifyMyInfoView.job()) {
					AccountDAO dao = new AccountDAO();
					
					if(dao.modify_info("JOB", request.get("new_job").toString())) {
						request.put("client_job", request.get("new_job"));
						out.println("[���ο� ���� : "+request.get("new_job")+"]");
						out.println("���� ���� ����!");
						
						out.println("\n Ȯ��(Enter) >");
						
						scan.nextLine();
					}
					else {
						out.println("���� ���� ����!");
						
						out.println("\n Ȯ��(Enter) >");
						
						scan.nextLine();
					}
				}
				else {
					out.println("���� ���� ���");
					out.println("Ȯ�� (Enter) >");
					scan.nextLine();
				}
				break;
				
			case 7:
				return;
			}
		}
	}
}
