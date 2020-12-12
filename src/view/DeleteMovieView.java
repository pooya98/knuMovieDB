package view;

import java.util.List;

import model.EpisodeDAO;
import model.EpisodeDTO;
import model.MovieDAO;
import model.MovieDTO;

public class DeleteMovieView implements View {

	public int choice() {
		out.print(" ������ Movie ID :");
		try {
			return scan.nextInt();
		} catch (Exception e) {
			scan.nextLine();
			return 0;
		}
	}

	public int choice2() {
		out.print("(1) ���Է� \n(2) ���ư���  \n\nChoice >");
		try {
			return scan.nextInt();
		} catch (Exception e) {
			scan.nextLine();
			return 0;
		}
	}

	public int choice3() {
		out.print("(1) �� \n(2) �ƴϿ�  \n\nChoice >");
		try {
			return scan.nextInt();
		} catch (Exception e) {
			scan.nextLine();
			return 0;
		}
	}
	
	public int choice4() {
		out.print("(1) ���� ���� \n(2) ���� ���  \n\nChoice >");
		try {
			return scan.nextInt();
		} catch (Exception e) {
			scan.nextLine();
			return 0;
		}
	}

	@Override
	public void show() {
		int count = 0;
		MovieDAO movieDao = new MovieDAO();
		List<MovieDTO> movie_list = movieDao.list_for_all();

		out.println("----- Movie ���� -----");

		System.out.println("### ��ü ���� ����Ʈ ###");
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println(
				"|  ID |                      TITLE                         |         TYPE         |      GENRE      | RUNTIME | START_YEAR | RATING |");

		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------------------------");
		for (MovieDTO dto : movie_list) {
			if (dto.getType().toString().equals("TV Series")) {
				count++;
				System.out.printf("| %3d | %-50s | %-20s | %-15s |   %3d   |    %s    |  %4.1f  |\n", dto.getId(),
						dto.getTitle(), dto.getType(), dto.getGenre(), dto.getRuntime(),
						dto.getStart_date().toString().substring(0, 4), dto.getRating());
			}
		}
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------------------------");

		if (count == 0) {
			System.out.println(
					"-------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println(
					"|                                                      ��ϵ� ���� ����                                                                |");
			System.out.println(
					"-------------------------------------------------------------------------------------------------------------------------------------");
		}

		int number = choice4();
		
		while (number < 0 || number >2) {
			out.println("�߸��� �Է�!");
			number = choice();
		}

		scan.nextLine();
		
		if(number == 2) {
			return;
		}
		int num = choice();

		while (num < 0) {
			out.println("�߸��� �Է�!");
			num = choice();
		}

		scan.nextLine();

		boolean movie_id_exist = false;

		for (MovieDTO dto : movie_list) {
			if ((int) dto.getId() == num) {
				movie_id_exist = true;
				break;
			}
		}

		if (movie_id_exist == true) {
			out.println("���� �����Ͻðڽ��ϱ�?");

			int no = choice3();

			while (no < 0 || no > 2) {
				out.println("�߸��� �Է�!");
				no = choice3();
			}
			scan.nextLine();

			if (no == 1) {
				if (movieDao.dropMovie(num) == true) {
					out.println(" ������ �Ϸ� �Ǿ����ϴ�. ");
				} else {
					out.println(" ������ �����߽��ϴ�. ");
				}

			} else {
				System.out.println(" ������ ����Ͽ����ϴ�. ");
				return;
			}

		} else {
			out.println("�ش� ID�� Movie�� �������� �ʽ��ϴ�.\n");
			out.println(" Ȯ�� (Enter) > ");
			scan.nextLine();
		}
	}

}
