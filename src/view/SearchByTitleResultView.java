package view;

import java.util.List;

import model.MovieDAO;
import model.MovieDTO;
import resource.R;

public class SearchByTitleResultView implements R {
	
	public int choice() {
		System.out.print("(1) ���Է� \n(2) ���ư��� \n\nChoice > ");
		try {
			return scan.nextInt();
		}
		catch(Exception e) {
			scan.nextLine();
			return 0;
		}
	}
	
	public int choice2() {
		System.out.print("(1) ���� ���� \n(2) ���Է� \n(3) ���ư��� \n\nChoice > ");
		try {
			return scan.nextInt();
		}
		catch(Exception e) {
			scan.nextLine();
			return 0;
		}
	}

	public void list(String title) {
		/*
		MovieDAO dao = new MovieDAO();
		List<MovieDTO> list = dao.list_for_title_search(title);
		
		int count = 0;

		System.out.println("\n### �˻� ��� ����Ʈ ###");

		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("|  ID |                      TITLE                         |         TYPE         |      GENRE      | RUNTIME | START_YEAR | RATING |");

		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
		for (MovieDTO dto : list) {
			count++;
			System.out.printf("| %3d | %-50s | %-20s | %-15s |   %3d   |    %s    |  %4.1f  |\n", dto.getId(), dto.getTitle(), dto.getType(), dto.getGenre(),
					dto.getRuntime(), dto.getStart_date().toString().substring(0, 4), dto.getRating());
		}
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
		
		if(count == 0) {
			System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("|                                                             �˻� ����� �����ϴ�.                                                       |");
			System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
		}
	}
	
	public void noResultMenu() {
		
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("|  ID |                      TITLE                         |         TYPE         |      GENRE      | RUNTIME | START_YEAR | RATING |");

		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
		
		System.out.println("|                                                             �˻� ����� �����ϴ�.                                                       |");
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
		
		int no = choice();
		while(no<1 || no>2) {
			System.out.println("\n�߸��� �Է�!");
			System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("|  ID |                      TITLE                         |         TYPE         |      GENRE      | RUNTIME | START_YEAR | RATING |");

			System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
			
			System.out.println("|                                                             �˻� ����� �����ϴ�.                                                       |");
			System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
			no = choice();
		}
		
		request.put("noResultMenu_selectNo", no);
	}
	
	public void yesResultMenu(String title) {
		
		MovieDAO dao = new MovieDAO();
		List<MovieDTO> list = dao.list_for_title_search(title);
		
		int no = choice2();
		while(no<1 || no>3) {
			System.out.println("\n�߸��� �Է�!");
			this.list(title);
			no = choice2();
		}
		
		request.put("YesResultMenu_selectNo", no);*/
	}

}
