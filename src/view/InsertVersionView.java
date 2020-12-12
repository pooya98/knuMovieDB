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
		out.print(" 등록할 Version의 Movie ID :");
		try {
			return scan.nextInt();
		} catch (Exception e) {
			scan.nextLine();
			return 0;
		}
	}

	public int choice2() {
		out.print("(1) 재입력 \n(2) 돌아가기 : \n\nChoice >");
		try {
			return scan.nextInt();
		} catch (Exception e) {
			scan.nextLine();
			return 0;
		}
	}

	public int choice3() {
		out.print("(1) Version 등록 \n(2) 돌아가기 : \n\nChoice >");
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

		out.println("----- Version 등록 -----");

		System.out.println("### 전체 영상물 리스트 ###");
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
					"|                                                      등록된 영상물 없음                                                                |");
			System.out.println(
					"-------------------------------------------------------------------------------------------------------------------------------------");
		}

		int num = choice();

		while (num < 0) {
			out.println("잘못된 입력!");
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

				System.out.println(" [버전 목록]");
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
					out.println("잘못된 입력!");
					no = choice3();
				}
				scan.nextLine();

				if (no == 1) {
					boolean epi_success = true;
					String version_short;
					String version_title;

					out.print(" 버전 국가 정보 ( ");
					NationalityDAO natDAO = new NationalityDAO();
					
					natDAO.show_all();
					out.print(" 중 택 1) : ");
					
					version_short = scan.nextLine();
					
					out.print(" 버전 title : ");
					version_title = scan.nextLine();


					for (VersionDTO dto : verList) {
						if (dto.getNationality_short().equals(version_short)) {
							System.out.println("이미 해당 버전이 존재합니다.");
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
						System.out.println("국가 약어[" + version_short + "]가 존재하지 않습니다.");
						epi_success = false;
					}

					if (version_title.length() > 50 || version_title.replaceAll(" ", "").equals("")) {
						epi_success = false;
					}

					
					if (epi_success == true) {
						if(verDAO.insert_version(num, version_short, version_title, "False") == true) {
							System.out.println("에피소드 등록 완료");
						}
						else {
							System.out.println("에피소드 등록 실패");
						}
					} else {

					}

				} else {
					return;
				}
			}

		}
		else {
			out.println("해당 ID의 영상물이 존재하지 않습니다.\n");
			out.println(" 확인 (Enter) > ");
			scan.nextLine();
		}
	}
}
