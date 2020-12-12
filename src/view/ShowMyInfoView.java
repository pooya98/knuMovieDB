package view;

public class ShowMyInfoView implements View {

	@Override
	public void show() {
		out.print("\n--- 나의 회원정보 조회 ---\n");
		
		out.println("이 름     : "+request.get("client_name").toString());
		out.println("성 별     : "+request.get("client_sex").toString());
		out.println("연락처    : "+request.get("client_contact").toString());
		out.println("주 소     : "+request.get("client_address").toString());
		out.println("생년월일   : "+request.get("client_birth").toString());
		out.println("직업      : "+request.get("client_job").toString());
		if(request.get("client_type").toString().equals("U")) {
			out.println("멤버쉽 등급 : "+request.get("client_membership").toString());
		
		}
		out.println("\n확인 완료(Enter) >");
		scan.nextLine();

	}
	

}
