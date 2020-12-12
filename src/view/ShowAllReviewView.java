package view;

import java.util.List;

import model.RatingDTO;

public class ShowAllReviewView implements View {

	public int choice() {
		out.println("\n--- 전체 평가내역 조회 ---");
		out.print("(1) 평가 내역 선택 \n(2) 돌아가기 \n\nChoice >  ");
		try {
			return scan.nextInt();
		} catch (Exception e) {
			scan.nextLine();
			return 0;
		}
	}

	public int choice3() {
		out.println("입력한 사용자 ID와 영상물 ID의 평가가 존재하지 않습니다.");
		out.println("\n(1) 재입력 \n(2) 취소 \n\nChoice > ");
		try {
			return scan.nextInt();
		} catch (Exception e) {
			scan.nextLine();
			return 0;
		}
	}

	@Override
	public void show() {

	}

	public void show2(List<RatingDTO> list) {
		int select_no = 0;
		while (true) {
			out.println("\n--- 전체 평가내역 조회 ---\n");
			System.out.println(
					"-----------------------------------------------------------------------------------------------------");
			System.out.println(
					"|       ID        |   MOVIE_ID   |                       TITLE                        | USER_RATING |");
			System.out.println(
					"-----------------------------------------------------------------------------------------------------");
			for (RatingDTO dto : list) {
				System.out.printf("| %-15s |     %3d      | %-50s |      %2.0f     | \n",
						dto.getAccount_username(), dto.getMovie_id(), dto.getMovie_title(),
						dto.getMy_rating());
				System.out.println(
						"-----------------------------------------------------------------------------------------------------");
			}

			int no = choice();

			while (no < 1 || no > 2) {
				System.out.println("\n잘못된 입력!");
				no = choice();
			}
			
			scan.nextLine();
			if (no == 1) {
				while (true) {
					
					String user_id;
					int movie_id = 0;
					
					out.print(" 회원 ID : ");
					user_id = scan.nextLine();
					out.print(" 영상물 ID : ");
					try {
						movie_id = scan.nextInt();
						scan.nextLine();
					}
					catch(Exception e) {
						scan.nextLine();
					}

					int count = 0;

					for (RatingDTO dto : list) {
						if (dto.getMovie_id() == movie_id && dto.getAccount_username().toString().equals( user_id )) {
							count++;
							out.println("--------------------- 평가 상세 조회 ----------------------");

							out.print(" [title]          : ");
							out.println(dto.getMovie_title());
							out.print(" [type ]          : ");
							out.println(dto.getMovie_type());
							out.print(" [genre]          : ");
							out.println(dto.getMovie_genre());
							out.print(" [Opening date]   : ");
							out.println(dto.getMovie_start_date().subSequence(0, 10));
							out.print(" [runtime]        : ");
							out.println(dto.getMovie_runtime());
							out.print(" [average rating] : ");
							out.println(dto.getMovie_rating());

							out.print("\n [my rating]      : ");
							out.println(dto.getMy_rating());
							out.print(" [my comments]    : ");
							out.println(dto.getMy_comments());
							out.println("-------------------------------------------------------");
							break;
						}

					}
					
					if (count == 0) {
						int num2 = choice3();

						while (num2 < 1 || num2 > 2) {
							out.println("잘못된 입력!");
							num2 = choice3();
						}

						if (num2 == 2) {
							break;
						}

					} else {
						out.println("\n 확인 (Enter) >\n");
						scan.nextLine();
						break;
					}
				}
			}
			if (no == 2) {
				return;
			}

		}
	}

}
