package controller;

import model.MovieDAO;
import resource.R;

public class InsertMovieController implements R {

	public int choice() {
		System.out.print("(1) �ٽ� ����ϱ� \n(2) ���ư��� \n\nChoice > ");
		try {
			return scan.nextInt();
		} catch (Exception e) {
			scan.nextLine();
			return 0;
		}
	}
	
	public int choice2() {
		System.out.print("(1) �߰� ����ϱ� \n(2) ���ư��� \n\nChoice > ");
		try {
			return scan.nextInt();
		} catch (Exception e) {
			scan.nextLine();
			return 0;
		}
	}

	public void process() {
		while (true) {
			insertMovieView.show();
/*
			if ((boolean) request.get("movie_input") == true) {
				MovieDAO dao = new MovieDAO();

				if (dao.insertMovie() == true) {
					out.println("���� ����� �Ϸ�Ǿ����ϴ�.");
					

					int num = choice2();

					while (num < 0 || num > 2) {
						out.println("�߸��� �Է��Դϴ�.");
						num = choice2();
					}
					
					scan.nextLine();
					if(num == 2) {
						break;
					}
				} else {
					out.println("���� ��Ͽ� �����Ͽ����ϴ�.");
					

					int num = choice();

					while (num < 0 || num > 2) {
						out.println("�߸��� �Է��Դϴ�.");
						num = choice();
					}
					scan.nextLine();
					if(num == 2) {
						break;
					}
				}
			} else {
				//out.println("���� ����� ����Ͽ����ϴ�.");
				
				out.println();
				int num = choice();

				while (num < 0 || num > 2) {
					out.println("�߸��� �Է��Դϴ�.");
					num = choice();
				}
				scan.nextLine();
				if(num == 2) {
					break;
				}
			}*/
		}
	}
}
