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
		out.print(" ��츦 �߰� �Ǵ� �����Ϸ��� Movie�� ID :");
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
		out.print("(1) episode ��� \n(2) ���ư��� : \n\nChoice >");
		try {
			return scan.nextInt();
		} catch (Exception e) {
			scan.nextLine();
			return 0;
		}
	}
	
	public int choice4() {
		out.print("(1) �߰�/���� ���� \n(2) �߰�/���� ���  \n\nChoice >");
		try {
			return scan.nextInt();
		} catch (Exception e) {
			scan.nextLine();
			return 0;
		}
	}
	
	public int choice5() {
		out.print(" ������ ������ ID : ");
		try {
			return scan.nextInt();
		} catch (Exception e) {
			scan.nextLine();
			return 0;
		}
	}
	
	public int choice6() {
		out.print("(1) ��� �߰� \n(2) ��� ���� \n\n Choice > ");
		try {
			return scan.nextInt();
		} catch (Exception e) {
			scan.nextLine();
			return 0;
		}
	}
	
	public int choice7() {
		out.print(" �߰��� ����� ID : ");
		try {
			return scan.nextInt();
		} catch (Exception e) {
			scan.nextLine();
			return 0;
		}
	}
	
	public int choice8() {
		out.print(" ������ ����� ID : ");
		try {
			return scan.nextInt();
		} catch (Exception e) {
			scan.nextLine();
			return 0;
		}
	}
	
	public int choice10() {
		out.println("���� �����Ͻðڽ��ϱ�?");
		out.print("(1) �� \n(2) �ƴϿ� \n\nChoice > ");
		try {
			return scan.nextInt();
		} catch (Exception e) {
			scan.nextLine();
			return 0;
		}
	}
	
	public int choice11() {
		out.println("���� �߰��Ͻðڽ��ϱ�?");
		out.print("(1) �� \n(2) �ƴϿ� \n\nChoice > ");
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

		out.println("----- Actor �߰�/���� -----");

		System.out.println("### ��ü ���� ����Ʈ ###");
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
			if ((int) dto.getId() == num) {
				movie_id_exist = true;
				break;
			}
		}

		if (movie_id_exist == true) {
			
			ActorDAO actDAO = new ActorDAO();
			List <ActorDTO> actList = actDAO.get_list_this_movie(num);
			
			out.println("�� ��ȭ�� �⿬������ ��ϵǾ� �ִ� ��� ����Ʈ");
			for (ActorDTO dto : actList) {
				count++;
				System.out.printf("| %3d |      %-20s       |     %s      |       %s       |\n", dto.getId(),
						dto.getName(), dto.getBirth().substring(0, 10), dto.getSex());
				System.out.println(
						"-------------------------------------------------------------------------------------------------------------------");
			}
			
			number = choice4();

			while (number < 0 || number > 2) {
				out.println("�߸��� �Է�!");
				number = choice();
			}

			scan.nextLine();

			if (number == 2) {
				return;
			}
			
			
			int select_no = choice6();
			
			while(select_no <0 || select_no>2) {
				out.println("�߸��� �Է�");
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
					out.println("�߸��� �Է�!");
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
						out.println("�߸��� �Է�!");
						num11 = choice10();
					}
					
					if(num11 == 1) {
						if(actDAO.insert_participate(num, insert_id) == true) {
							out.println("�߰� �Ǿ����ϴ�.");
							return;
						}
						else {
							out.println("�߰� ����");
							return;
						}
					}
				}else {
					out.println(" �ش� ID�� ��ȿ���� �ʽ��ϴ�.");
				}
				
				
				
			}else {
				boolean delete_actor_exist = false;
				
				int delete_id = choice8();
				while(delete_id<0) {
					out.println("�߸��� �Է�!");
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
						out.println("�߸��� �Է�!");
						num10 = choice10();
					}
					
					if(num10 == 1) {
						if(actDAO.delete_from_movie(num, delete_id) == true) {
							out.println("���� �Ǿ����ϴ�.");
							return;
						}
						else {
							out.println("���� ����.");
							return;
						}
					}
				}else {
					out.println(" �ش� ID�� ���� �� ��ȭ�� �⿬������ ����Ǿ� ���� �ʽ��ϴ�.");
				}
			
			}
			

		} else {
			out.println("�ش� ID�� Movie�� �������� �ʽ��ϴ�.\n");
			out.println(" Ȯ�� (Enter) > ");
			scan.nextLine();
		}
	}
}
