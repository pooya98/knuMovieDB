package view;

public class SignInView implements View {
	
	@Override
	public void show() {
		
		String id;
		String pw;
		
		out.println("\n--- Sign in ---");
		
		
		out.print("ID : ");
		
		id = scan.nextLine();
		
		out.print("PW : ");
		
		pw = scan.nextLine();
		
		request.put("id", id);
		request.put("pw", pw);
		
		out.print("(Loading....)");
	}
}
