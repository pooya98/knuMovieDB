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

public class InsertVersionView implements View {

	public int choice() {
		out.print(" ����� Version�� Movie ID :");
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
		out.print("(1) Version ��� \n(2) ���ư��� : \n\nChoice >");
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

		out.println("----- Version ��� -----");

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
					System.out.printf("| %-30s |        %3s         | %-30s |    %5s    |\n",
							dto.getMovie_title(), dto.getNationality_short(), dto.getVersion_title(), dto.getIs_original());
					System.out.println(
							"-------------------------------------------------------------------------------------------------------------------");
				}

				int no = choice3();

				while (no < 0 || no > 2) {
					out.println("�߸��� �Է�!");
					no = choice3();
				}
				scan.nextLine();

				if (no == 1) {
					boolean epi_success = true;
					String version_short;
					String version_title;

					out.print(" ���� ���� ���� ( ");
					NationalityDAO natDAO = new NationalityDAO();
					
					natDAO.show_all();
					out.print(" �� �� 1) : ");
					
					version_short = scan.nextLine();
					
					out.print(" ���� title : ");
					version_title = scan.nextLine();


					for (VersionDTO dto : verList) {
						if (dto.getNationality_short().equals(version_short)) {
							System.out.println("�̹� �ش� ������ �����մϴ�.");
							epi_success = false;
						}
					}
					
					List <NationalityDTO> natDTO = natDAO.list_for_all();
					
					boolean short_name_success = false;
					
					for (NationalityDTO dto : natDTO) {
						if (dto.getShort_name().equals(version_short)) {
							short_name_success = true;
							break;
						}
					}
					
					if(short_name_success == false) {
						System.out.println("���� ���[" + version_short + "]�� �������� �ʽ��ϴ�.");
						epi_success = false;
					}

					if (version_title.length() > 50 || version_title.replaceAll(" ", "").equals("")) {
						epi_success = false;
					}

					
					if (epi_success == true) {
						if(verDAO.insert_version(num, version_short, version_title, "False") == true) {
							System.out.println("���Ǽҵ� ��� �Ϸ�");
						}
						else {
							System.out.println("���Ǽҵ� ��� ����");
						}
					} else {

					}

				} else {
					return;
				}
			}

		}
		else {
			out.println("�ش� ID�� ������ �������� �ʽ��ϴ�.\n");
			out.println(" Ȯ�� (Enter) > ");
			scan.nextLine();
		}
	}
}
