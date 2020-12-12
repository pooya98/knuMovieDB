package view;

public class InitMenu implements View{
	
	public int choice() {
		out.println("### Welcome to KnuMovieDB ###");
		out.print("(1) Sign in \n(2) Sign up \n(3) Exit \n\nChoice >  ");
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
		while(no<1 || no>4) {
			System.out.println("\n잘못된 입력!");
			no = choice();
		}
		
		request.put("initMenu_selectNo", no);
	}
}
