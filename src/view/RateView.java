package view;

import model.RatingDAO;

public class RateView implements View {

	public int choice() {
		out.print("(1) 재입력 \n(2) 평가 취소 \n\nChoice >  ");
		try {
			return scan.nextInt();
		} catch (Exception e) {
			scan.nextLine();
			return 0;
		}
	}

	@Override
	public void show() {}
	
	public boolean show2() {
		while (true) {
			int rating = -1;
			String comments;
			boolean success_flag = true;

			out.println("----- 평가하기 -----");
			out.print(" 평점(0 ~ 10)   : ");

			try {
				rating = scan.nextInt();
				scan.nextLine();
			} catch (Exception e) {
				scan.nextLine();
			}

			out.print(" 후기(최대 100자) : ");
			comments = scan.nextLine();

			if (rating < 0 || rating > 10) {
				success_flag = false;
			}

			if (comments.length() > 100) {
				success_flag = false;
			}

			if (success_flag == true) {
				RatingDAO dao = new RatingDAO();
/*
				if (dao.insertRate(rating, comments) == true) {
					System.out.println("평가가 성공적으로 완료되었습니다.");
					return true;
				} else {
					System.out.println("평가 저장에 실패했습니다.");
					return false;
				}
*/
			} else {
				out.println("입력된 평점이 범위 내에 있지 않거나 후기가 100자 이상입니다.");
				int num = choice();

				while (num < 1 || num > 2) {
					System.out.println("\n잘못된 입력!");
					out.println("입력된 평점이 범위 내에 있지 않거나 후기가 100자 이상입니다.");
					num = choice();
				}
				
				if(num == 2) {
					return false;
				}
			}
		}
	}
}
