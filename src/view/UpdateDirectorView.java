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
		out.print(" ������ ������ Movie�� ID :");
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
		out.print("(1) ���� ���� \n(2) ���� ���  \n\nChoice >");
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

	@Override
	public void show() {
		int count = 0;
		MovieDAO movieDao = new MovieDAO();
		List<MovieDTO> movie_list = movieDao.list_for_all_with_director();

		out.println("----- Director �Է�/���� -----");

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

		while (number < 0) {
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
				out.println("�߸��� �Է�!");
				number = choice();
			}

			scan.nextLine();

			if (number == 2) {
				return;
			}
			
			
			int select_no = choice5();
			
			while(select_no <0) {
				out.println("�߸��� �Է� �Դϴ�.");
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
					out.println("���� ���� ����");
				}else {
					out.println("���� ���� ����");
				}
			}
			else {
				out.println("�ش� ID�� ������ �������� �ʽ��ϴ�.");
			}
			

		} else {
			out.println("�ش� ID�� Movie�� �������� �ʽ��ϴ�.\n");
			out.println(" Ȯ�� (Enter) > ");
			scan.nextLine();
		}
	}

}
