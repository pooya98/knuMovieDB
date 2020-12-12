package view;

import java.util.List;

import model.MovieDAO;
import model.MovieDTO;

public class ShowMovieDetailView implements View {

	public int choice() {
		out.println("������ ���� ID��ȣ :");
		try {
			return scan.nextInt();
		} catch (Exception e) {
			scan.nextLine();
			return 0;
		}
	}

	public int choice2() {
		out.println("(1) ���ϱ� \n(2) ���ư��� \n\nChoice >");
		try {
			return scan.nextInt();
		} catch (Exception e) {
			scan.nextLine();
			return 0;
		}
	}

	public int choice3() {
		out.println("(1) ���Է� \n(2) ���ư��� \n\nChoice >");
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
						"\n============================================== ���� �� ���� ================================================\n");
				out.println(" [����]      : " + dto.getTitle());
				out.println(" [�帣]      : " + dto.getGenre());
				out.println(" [������]     : " + dto.getStart_date().toString().subSequence(0, 9));
				out.println(" [���� Ÿ��] : " + dto.getType());
				out.println(" [��� �ð�]  : " + dto.getRuntime());
				out.println(" [����]      : " + dto.getRating());

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
					out.println("�߸��� �Է�!");
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
				
				System.out.println("�˻� ����� �ش� ID�� ��ȭ�� �����ϴ�.");
				//searchByTitleResultView.list(title);
				int num = choice3();

				while (num < 1 || num > 2) {
					System.out.println("�˻� ����� �ش� ID�� ��ȭ�� �����ϴ�.");
					//searchByTitleResultView.list(title);
					out.println("�߸��� �Է�!");
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
