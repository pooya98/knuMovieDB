package view;

import java.util.List;

import model.DirectorDAO;
import model.DirectorDTO;
import model.EpisodeDAO;
import model.EpisodeDTO;
import model.MovieDAO;
import model.MovieDTO;

public class UpdateDirectorView implements View {

	public int choice() {
		out.print(" 감독을 변경할 Movie의 ID :");
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
	
	public int choice4() {
		out.print("(1) 변경 진행 \n(2) 변경 취소  \n\nChoice >");
		try {
			return scan.nextInt();
		} catch (Exception e) {
			scan.nextLine();
			return 0;
		}
	}
	
	public int choice5() {
		out.print(" 변경할 감독의 ID : ");
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
		List<MovieDTO> movie_list = movieDao.list_for_all_with_director();

		out.println("----- Director 입력/변경 -----");

		System.out.println("### 전체 영상물 리스트 ###");
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println(
				"|  ID |                      TITLE                         |         TYPE         |      GENRE      |   START YEAR  |");

		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------------------------");
		for (MovieDTO dto : movie_list) {
				count++;
				System.out.printf("| %3d | %-50s | %-20s | %-15s | %-20s  |\n", dto.getId(),
						dto.getTitle(), dto.getType(), dto.getGenre(), dto.getStart_date().substring(0, 10));
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
		
		int number = choice4();

		while (number < 0) {
			out.println("잘못된 입력!");
			number = choice();
		}

		scan.nextLine();

		if (number == 2) {
			return;
		}
		
		

		int num = choice();

		while (num < 0) {
			out.println("잘못된 입력!");
			num = choice();
		}

		scan.nextLine();

		boolean movie_id_exist = false;
		boolean was_first = false;

		for (MovieDTO dto : movie_list) {
			if ((int) dto.getId() == num) {
				if(dto.getDirector_name() == null)
					was_first = true;
				movie_id_exist = true;
				break;
			}
		}

		if (movie_id_exist == true) {
			DirectorDAO dirDAO = new DirectorDAO();

			List<DirectorDTO> dirList = dirDAO.get_list();

			for (DirectorDTO dto : dirList) {
				count++;
				System.out.printf("| %3d |      %-20s       |     %s      |       %s       |\n", dto.getId(),
						dto.getName(), dto.getBirth().substring(0, 10), dto.getSex());
				System.out.println(
						"-------------------------------------------------------------------------------------------------------------------");
			}
			
			
			number = choice4();

			while (number < 0) {
				out.println("잘못된 입력!");
				number = choice();
			}

			scan.nextLine();

			if (number == 2) {
				return;
			}
			
			
			int select_no = choice5();
			
			while(select_no <0) {
				out.println("잘못된 입력 입니다.");
				select_no = choice5();
			}
			
			boolean dir_exist = false;
			
			for (DirectorDTO dto : dirList) {
				if(dto.getId() == select_no) {
					dir_exist = true;
				}
			}
			
			if(dir_exist == true) {
				if(dirDAO.update_produce(num, select_no, was_first) == true)
				{
					out.println("감독 변경 성공");
				}else {
					out.println("감독 변경 실패");
				}
			}
			else {
				out.println("해당 ID의 감독이 존재하지 않습니다.");
			}
			

		} else {
			out.println("해당 ID의 Movie가 존재하지 않습니다.\n");
			out.println(" 확인 (Enter) > ");
			scan.nextLine();
		}
	}

}
