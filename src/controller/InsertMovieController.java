package controller;

import model.MovieDAO;
import resource.R;

public class InsertMovieController implements R {

	public int choice() {
		System.out.print("(1) 다시 등록하기 \n(2) 돌아가기 \n\nChoice > ");
		try {
			return scan.nextInt();
		} catch (Exception e) {
			scan.nextLine();
			return 0;
		}
	}
	
	public int choice2() {
		System.out.print("(1) 추가 등록하기 \n(2) 돌아가기 \n\nChoice > ");
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
					out.println("영상물 등록이 완료되었습니다.");
					

					int num = choice2();

					while (num < 0 || num > 2) {
						out.println("잘못된 입력입니다.");
						num = choice2();
					}
					
					scan.nextLine();
					if(num == 2) {
						break;
					}
				} else {
					out.println("영상물 등록에 실패하였습니다.");
					

					int num = choice();

					while (num < 0 || num > 2) {
						out.println("잘못된 입력입니다.");
						num = choice();
					}
					scan.nextLine();
					if(num == 2) {
						break;
					}
				}
			} else {
				//out.println("영상물 등록을 취소하였습니다.");
				
				out.println();
				int num = choice();

				while (num < 0 || num > 2) {
					out.println("잘못된 입력입니다.");
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
