package view;

import java.util.List;

import model.EpisodeDAO;
import model.EpisodeDTO;
import model.MovieDAO;
import model.MovieDTO;

public class InsertEpisodeView implements View {

	public int choice() {
		out.print(" 등록할 episode의 Movie ID :");
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
		out.print("(1) episode 등록 \n(2) 돌아가기 : \n\nChoice >");
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

		out.println("----- episode 등록 -----");

		System.out.println("### 전체 영상물 리스트 ###");
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
			if ((int) dto.getId() == num && dto.getType().toString().equals("TV Series")) {
				movie_id_exist = true;
				break;
			}
		}

		if (movie_id_exist == true) {
			while (true) {
				EpisodeDAO epiDAO = new EpisodeDAO();
				List<EpisodeDTO> epiList = epiDAO.get_list(num);

				System.out.println(" [에피소드 목록]");
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

				int no = choice3();

				while (no < 0 || no > 2) {
					out.println("잘못된 입력!");
					no = choice3();
				}
				scan.nextLine();

				if (no == 1) {
					boolean epi_success = true;
					int season_num = 0;
					int episode_num = 0;
					String episode_title;
					int episode_runtime = 0;

					out.print(" 시즌 번호 : ");
					try {
						season_num = scan.nextInt();
						scan.nextLine();
					} catch (Exception e) {
						scan.nextLine();
					}
					out.print(" 에피소드 번호 : ");
					try {
						episode_num = scan.nextInt();
						scan.nextLine();
					} catch (Exception e) {
						scan.nextLine();
					}

					out.print(" 에피소드 제목 : ");
					episode_title = scan.nextLine();

					out.print(" 에피소드 런타임(필수/ 분) : ");
					try {
						episode_runtime = scan.nextInt();
						scan.nextLine();
					} catch (Exception e) {
						scan.nextLine();
					}

					for (EpisodeDTO dto : epiList) {
						if (dto.getEpisodeNum() == episode_num && dto.getSeason() == season_num) {
							System.out.println("이미 해당 시즌 해당 회차의 에피소드가 있습니다.");
							epi_success = false;
						}
					}

					if (episode_runtime <= 0)
						epi_success = false;

					if (episode_title.length() > 50 || episode_title.replaceAll(" ", "").equals("")) {
						epi_success = false;
					}

					if (epi_success == true) {
						if(epiDAO.insert_episode(num, season_num, episode_num, episode_title, episode_runtime) == true) {
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
			out.println("해당 ID의 TV Series가 존재하지 않습니다.\n");
			out.println(" 확인 (Enter) > ");
			scan.nextLine();
		}
	}
}
