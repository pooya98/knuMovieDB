package view;

import java.util.List;

import model.RatingDTO;

public class ShowMyReviewView implements View {

	public int choice() {
		out.println("\n--- ���� �򰡳��� ��ȸ ---");
		out.print("(1) �� ���� ���� \n(2) ���ư��� \n\nChoice >  ");
		try {
			return scan.nextInt();
		} catch (Exception e) {
			scan.nextLine();
			return 0;
		}
	}

	public int choice2() {
		out.println("\n ���� ID �Է� : ");
		try {
			return scan.nextInt();
		} catch (Exception e) {
			scan.nextLine();
			return 0;
		}
	}

	public int choice3() {
		out.println("�Է��� ID�� �򰡰� �������� �ʽ��ϴ�.");
		out.println("\n(1) ���Է� \n(2) ��� \n\nChoice > ");
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
			out.println("\n--- ���� �򰡳��� ��ȸ ---\n");
			System.out.println(
					"---------------------------------------------------------------------------------------------------");
			System.out.println(
					"|       ID        |   MOVIE_ID   |                       TITLE                        | MY_RATING |");
			System.out.println(
					"---------------------------------------------------------------------------------------------------");
			for (RatingDTO dto : list) {
				System.out.printf("| %-15s |     %3d      | %-50s |     %2.0f    | \n",
						request.get("client_username").toString(), dto.getMovie_id(), dto.getMovie_title(),
						dto.getMy_rating());
				System.out.println(
						"---------------------------------------------------------------------------------------------------");
			}

			int no = choice();

			while (no < 1 || no > 2) {
				System.out.println("\n�߸��� �Է�!");
				no = choice();
			}
			if (no == 1) {
				while (true) {
					int num = choice2();

					while (num < 1) {
						out.println("�߸��� �Է�!");
						num = choice2();
					}

					int count = 0;

					for (RatingDTO dto : list) {
						if (dto.getMovie_id() == num) {
							count++;
							out.println("--------------------- �� �� ��ȸ ----------------------");

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
							out.println("�߸��� �Է�!");
							num2 = choice3();
						}

						if (num2 == 2) {
							break;
						}

					} else {
						out.println("\n Ȯ�� (Enter) >\n");
						scan.nextLine();
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
