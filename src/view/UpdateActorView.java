package view;

import java.util.List;

import model.ActorDAO;
import model.ActorDTO;
import model.DirectorDAO;
import model.DirectorDTO;
import model.MovieDAO;
import model.MovieDTO;

public class UpdateActorView implements View {

	public int choice() {
		out.print(" 배우를 추가 또는 삭제하려는 Movie의 ID :");
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
		out.print("(1) 추가/삭제 진행 \n(2) 추가/삭제 취소  \n\nChoice >");
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
	
	public int choice6() {
		out.print("(1) 배우 추가 \n(2) 배우 삭제 \n\n Choice > ");
		try {
			return scan.nextInt();
		} catch (Exception e) {
			scan.nextLine();
			return 0;
		}
	}
	
	public int choice7() {
		out.print(" 추가할 배우의 ID : ");
		try {
			return scan.nextInt();
		} catch (Exception e) {
			scan.nextLine();
			return 0;
		}
	}
	
	public int choice8() {
		out.print(" 삭제할 배우의 ID : ");
		try {
			return scan.nextInt();
		} catch (Exception e) {
			scan.nextLine();
			return 0;
		}
	}
	
	public int choice10() {
		out.println("정말 삭제하시겠습니까?");
		out.print("(1) 예 \n(2) 아니요 \n\nChoice > ");
		try {
			return scan.nextInt();
		} catch (Exception e) {
			scan.nextLine();
			return 0;
		}
	}
	
	public int choice11() {
		out.println("정말 추가하시겠습니까?");
		out.print("(1) 예 \n(2) 아니요 \n\nChoice > ");
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

		out.println("----- Actor 추가/삭제 -----");

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

		while (number < 0 || number >2) {
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

		for (MovieDTO dto : movie_list) {
			if ((int) dto.getId() == num) {
				movie_id_exist = true;
				break;
			}
		}

		if (movie_id_exist == true) {
			
			ActorDAO actDAO = new ActorDAO();
			List <ActorDTO> actList = actDAO.get_list_this_movie(num);
			
			out.println("이 영화의 출연진으로 등록되어 있는 배우 리스트");
			for (ActorDTO dto : actList) {
				count++;
				System.out.printf("| %3d |      %-20s       |     %s      |       %s       |\n", dto.getId(),
						dto.getName(), dto.getBirth().substring(0, 10), dto.getSex());
				System.out.println(
						"-------------------------------------------------------------------------------------------------------------------");
			}
			
			number = choice4();

			while (number < 0 || number > 2) {
				out.println("잘못된 입력!");
				number = choice();
			}

			scan.nextLine();

			if (number == 2) {
				return;
			}
			
			
			int select_no = choice6();
			
			while(select_no <0 || select_no>2) {
				out.println("잘못된 입력");
				select_no = choice6();
			}
			
			if(select_no == 1) {
				
				boolean insert_actor_exist = false;
				
				List <ActorDTO> ActList = actDAO.get_list_not_exist(num);
				
				for (ActorDTO dto : ActList) {
					count++;
					System.out.printf("| %3d |      %-20s       |     %s      |       %s       |\n", dto.getId(),
							dto.getName(), dto.getBirth().substring(0, 10), dto.getSex());
					System.out.println(
							"-------------------------------------------------------------------------------------------------------------------");
				}
				
				int insert_id = choice7();
				while(insert_id<0) {
					out.println("잘못된 입력!");
					insert_id = choice7();
				}
				
				
				for (ActorDTO dto : ActList) {
					if(dto.getId() == insert_id) {
						insert_actor_exist = true;
						break;
					}
				}
				
				
				if(insert_actor_exist == true) {
					int num11 = choice11();
					
					while(num11 < 0 || num11> 2) {
						out.println("잘못된 입력!");
						num11 = choice10();
					}
					
					if(num11 == 1) {
						if(actDAO.insert_participate(num, insert_id) == true) {
							out.println("추가 되었습니다.");
							return;
						}
						else {
							out.println("추가 실패");
							return;
						}
					}
				}else {
					out.println(" 해당 ID가 유효하지 않습니다.");
				}
				
				
				
			}else {
				boolean delete_actor_exist = false;
				
				int delete_id = choice8();
				while(delete_id<0) {
					out.println("잘못된 입력!");
					delete_id = choice8();
				}
				
				
				for (ActorDTO dto : actList) {
					if(dto.getId() == delete_id) {
						delete_actor_exist = true;
						break;
					}		
				}
				
				if(delete_actor_exist == true) {
					int num10 = choice10();
					
					while(num10 < 0 || num10> 2) {
						out.println("잘못된 입력!");
						num10 = choice10();
					}
					
					if(num10 == 1) {
						if(actDAO.delete_from_movie(num, delete_id) == true) {
							out.println("삭제 되었습니다.");
							return;
						}
						else {
							out.println("삭제 실패.");
							return;
						}
					}
				}else {
					out.println(" 해당 ID의 배우는 이 영화의 출연진으로 저장되어 있지 않습니다.");
				}
			
			}
			

		} else {
			out.println("해당 ID의 Movie가 존재하지 않습니다.\n");
			out.println(" 확인 (Enter) > ");
			scan.nextLine();
		}
	}
}
