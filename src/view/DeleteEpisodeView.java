package view;

import java.util.List;

import model.EpisodeDAO;
import model.EpisodeDTO;
import model.MovieDAO;
import model.MovieDTO;

public class DeleteEpisodeView implements View {

	public int choice() {
		out.print(" ������ episode�� Movie ID :");
		try {
			return scan.nextInt();
		} catch (Exception e) {
			scan.nextLine();
			return 0;
		}
	}

	public int choice2() {
		out.print("(1) ���Է� \n(2) ���ư��� : \n\nChoice >");
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

		out.println("----- episode ���� -----");

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

		if (number == 2) {
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
			if ((int) dto.getId() == num && dto.getType().toString().equals("TV Series")) {
				movie_id_exist = true;
				break;
			}
		}

		if (movie_id_exist == true) {
			while (true) {
				EpisodeDAO epiDAO = new EpisodeDAO();
				List<EpisodeDTO> epiList = epiDAO.get_list(num);

				System.out.println(" [���Ǽҵ� ���]");
				System.out.println(
						"-------------------------------------------------------------------------------------------------------------------");
				System.out.println(
						"|           series Title         | Season number | episode num |         episode title          | episode runtime |");
				System.out.println(
						"-------------------------------------------------------------------------------------------------------------------");

				for (EpisodeDTO dto : epiList) {
					count++;
					System.out.printf("| %-30s |      %2d       |     %2d      | %-30s |       %3d       |\n",
							dto.getEpisodeTitle(), dto.getSeason(), dto.getEpisodeNum(), dto.getEpisodeTitle(),
							dto.getEpisodeRuntime());
					System.out.println(
							"-------------------------------------------------------------------------------------------------------------------");
				}

				number = choice4();

				while (number < 0 || number >2) {
					out.println("�߸��� �Է�!");
					number = choice();
				}

				scan.nextLine();

				if (number == 2) {
					return;
				}

				boolean epi_success = false;
				int season_num = 0;
				int episode_num = 0;
				String episode_title;
				int episode_runtime = 0;

				out.print(" ������ episode�� ���� ��ȣ : ");
				try {
					season_num = scan.nextInt();
					scan.nextLine();
				} catch (Exception e) {
					scan.nextLine();
				}
				out.print(" ������ episode�� ȸ�� ��ȣ : ");
				try {
					episode_num = scan.nextInt();
					scan.nextLine();
				} catch (Exception e) {
					scan.nextLine();
				}

				for (EpisodeDTO dto : epiList) {
					if (dto.getEpisodeNum() == episode_num && dto.getSeason() == season_num) {
						epi_success = true;
					}
				}

				if (epi_success == true) {
					out.println("���� �����Ͻðڽ��ϱ�?");
					
					int no = choice3();

					while (no < 0 || no > 2) {
						out.println("�߸��� �Է�!");
						no = choice3();
					}
					scan.nextLine();
					
					if(no == 1) {
						if (epiDAO.dropEpisode(num, season_num, episode_num) == true) {
							System.out.println("���Ǽҵ� ���� �Ϸ�");
							return;
						} else {
							System.out.println("���Ǽҵ� ���� ����");
							return;
						}
					}
					
				} else {
					System.out.println("�ش� ���� �ش� ȸ���� episode�� ���� ���� �ʽ��ϴ�.");
					System.out.println(" Ȯ�� (Enter) >");
					scan.nextLine();
				}

			}

		} else {
			out.println("�ش� ID�� TV Series�� �������� �ʽ��ϴ�.\n");
			out.println(" Ȯ�� (Enter) > ");
			scan.nextLine();
		}
	}

}
