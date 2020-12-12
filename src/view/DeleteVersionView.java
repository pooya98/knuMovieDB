package view;

import java.util.List;

import model.EpisodeDAO;
import model.EpisodeDTO;
import model.MovieDAO;
import model.MovieDTO;
import model.NationalityDAO;
import model.NationalityDTO;
import model.VersionDAO;
import model.VersionDTO;

public class DeleteVersionView implements View {

	public int choice() {
		out.print(" ������ Version�� Movie ID :");
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

		out.println("----- Version ���� -----");

		System.out.println("### ��ü ���� ����Ʈ ###");
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println(
				"|  ID |                      TITLE                         |         TYPE         |      GENRE      | RUNTIME | START_YEAR | RATING |");

		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------------------------");
		for (MovieDTO dto : movie_list) {
			count++;
			System.out.printf("| %3d | %-50s | %-20s | %-15s |   %3d   |    %s    |  %4.1f  |\n", dto.getId(),
					dto.getTitle(), dto.getType(), dto.getGenre(), dto.getRuntime(),
					dto.getStart_date().toString().substring(0, 4), dto.getRating());
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

		while (number < 0  || number >2) {
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
			if ((int) dto.getId() == num) {
				movie_id_exist = true;
				break;
			}
		}

		if (movie_id_exist == true) {
			while (true) {

				VersionDAO verDAO = new VersionDAO();
				List<VersionDTO> verList = verDAO.get_list(num);

				System.out.println(" [���� ���]");
				System.out.println(
						"-------------------------------------------------------------------------------------------------------------------");
				System.out.println(
						"|           Movie Title          | version short_name |         Version title          | Is_original |");
				System.out.println(
						"-------------------------------------------------------------------------------------------------------------------");

				for (VersionDTO dto : verList) {
					count++;
					System.out.printf("| %-30s |        %3s         | %-30s |    %5s    |\n", dto.getMovie_title(),
							dto.getNationality_short(), dto.getVersion_title(), dto.getIs_original());
					System.out.println(
							"-------------------------------------------------------------------------------------------------------------------");
				}

				number = choice4();

				while (number < 0  || number >2) {
					out.println("�߸��� �Է�!");
					number = choice();
				}

				scan.nextLine();

				if (number == 2) {
					return;
				}

				boolean epi_success = false;
				String version_short;

				out.print(" ������ Versiond�� ���� ���� ( ");
				NationalityDAO natDAO = new NationalityDAO();

				natDAO.show_all();
				out.print(" �� �� 1) : ");

				version_short = scan.nextLine();

				for (VersionDTO dto : verList) {
					if (dto.getNationality_short().equals(version_short)) {
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

					if (no == 1) {
						if (verDAO.dropVersion(num, version_short) == true) {
							System.out.println("Version ���� �Ϸ�");
							return;
						} else {
							System.out.println("Version ���� ����");
							return;
						}
					}
				} else {
					System.out.println("�ش� ������ ���� ���� �ʽ��ϴ�.");
					System.out.println(" Ȯ�� (Enter) >");
					scan.nextLine();
				}
			}

		} else {
			out.println("�ش� ID�� ������ �������� �ʽ��ϴ�.\n");
			out.println(" Ȯ�� (Enter) > ");
			scan.nextLine();
		}
	}

}
