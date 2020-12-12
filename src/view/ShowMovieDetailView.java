package view;

import java.util.List;

import model.MovieDAO;
import model.MovieDTO;

public class ShowMovieDetailView implements View {

	public int choice() {
		out.println("선택할 영상물 ID번호 :");
		try {
			return scan.nextInt();
		} catch (Exception e) {
			scan.nextLine();
			return 0;
		}
	}

	public int choice2() {
		out.println("(1) 평가하기 \n(2) 돌아가기 \n\nChoice >");
		try {
			return scan.nextInt();
		} catch (Exception e) {
			scan.nextLine();
			return 0;
		}
	}

	public int choice3() {
		out.println("(1) 재입력 \n(2) 돌아가기 \n\nChoice >");
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

	public void show2(List<MovieDTO> list, String title) {
		while (true) {
			int no = choice();
			boolean search_flag = false;

			for (MovieDTO dto : list) {
				if (dto.getId() == no) {
					search_flag = true;
				}
			}

			if (search_flag == true) {
				MovieDAO dao = new MovieDAO();

				MovieDTO dto = dao.detailInfo(no);
				out.println(
						"\n============================================== 영상물 상세 정보 ================================================\n");
				out.println(" [제목]      : " + dto.getTitle());
				out.println(" [장르]      : " + dto.getGenre());
				out.println(" [개봉일]     : " + dto.getStart_date().toString().subSequence(0, 9));
				out.println(" [영상물 타입] : " + dto.getType());
				out.println(" [재생 시간]  : " + dto.getRuntime());
				out.println(" [평점]      : " + dto.getRating());

				dao.showDirector(no);
				dao.showActors(no);
				dao.showVersion(no);

				if (dto.getType().toString().equals("TV Series")) {
					dao.showEpisode(no);
				}

				out.println(
						"\n===========================================================================================================\n");

				int num = choice2();

				while (num < 1 || num > 2) {
					out.println("잘못된 입력!");
					num = choice2();
				}

				if (num == 1) {
					request.put("iwillrate", true);
					request.put("selectnumOfMovie", no);
					return;
				} else {
					request.put("iwillrate", false);
					return ;
				}
			} else {
				
				System.out.println("검색 결과에 해당 ID의 영화가 없습니다.");
				//searchByTitleResultView.list(title);
				int num = choice3();

				while (num < 1 || num > 2) {
					System.out.println("검색 결과에 해당 ID의 영화가 없습니다.");
					//searchByTitleResultView.list(title);
					out.println("잘못된 입력!");
					num = choice3();
				}

				if (num == 2) {
					request.put("iwillrate", false);
					return;
				}
			}

		}
	}
}
