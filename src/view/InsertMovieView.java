package view;

import java.util.Calendar;
import java.util.List;

import model.GenreDAO;
import model.GenreDTO;
import model.MovieDTO;
import model.NationalityDAO;
import model.NationalityDTO;

public class InsertMovieView implements View {
	
	public int choice() {
		out.println("\n ����Ͻðڽ��ϱ�? ");
		out.print("(1) �� \n(2) �ƴϿ� \n\nChoice >  ");
		try {
			return scan.nextInt();
		} catch (Exception e) {
			scan.nextLine();
			return 0;
		}
	}

	@Override
	public void show() {

		String title;
		String type;
		int runtime = 0;
		String start_date;
		String genre;
		boolean movie_input = true;
		String nationality;

		System.out.println("---- ���� ��� ----");
		System.out.print(" title(�ʼ�/ �ִ� 50��) : ");
		title = scan.nextLine();
		request.put("i_title", title);
		System.out.print(" type(�ʼ�/ Movie, TV Series, KnuMovieDB Original");
		System.out.print(" �� �Է�) : ");
		type = scan.nextLine();
		request.put("i_type", type);
		System.out.print(" runtime(�ʼ�/ ��) : ");
		try {
			runtime = scan.nextInt();
			scan.nextLine();
			request.put("i_runtime", runtime);
		} catch (Exception e) {
			scan.nextLine();
		}

		System.out.print(" opening_date(�ʼ�/ yyyy-mm-dd) : ");
		start_date = scan.nextLine();
		request.put("i_start_date", start_date);
		System.out.print(" genre(�ʼ�/ ");
		GenreDAO dao = new GenreDAO();
		List<GenreDTO> list = dao.list_for_all();

		for (GenreDTO dto : list) {
			System.out.print(dto.getName() + ", ");
		}
		System.out.print(" �� �Է� ) : ");
		genre = scan.nextLine();
		request.put("i_genre", genre);

		
		
		System.out.print(" original version(�ʼ�/ ");
		NationalityDAO dao2 = new NationalityDAO();
		List<NationalityDTO> list2 = dao2.list_for_all();

		for (NationalityDTO dto2 : list2) {
			System.out.print(dto2.getShort_name()+ ", ");
		}
		System.out.print(" �� �Է� ) : ");
		nationality = scan.nextLine();
		request.put("i_original_version", nationality);
		
		
		
		
		if (title.replaceAll(" ", "").length() == 0 || title.length() > 50) {
			out.println("(����)��ȿ���� ���� title�Դϴ�.");
			movie_input = false;
		}
		if (!type.equals("Movie") && !type.equals("TV Series") && !type.equals("KnuMovieDB Original")) {
			out.println("(����)��ȿ���� ���� type�Դϴ�.");
			movie_input = false;
		}
		if (runtime <= 0) {
			out.println("(����)��ȿ���� ���� runtime�Դϴ�.");
			movie_input = false;
		}

		boolean genre_check = false;
		for (GenreDTO dto : list) {
			if (dto.getName().toString().equals(genre)) {
				genre_check = true;
			}
		}

		if (genre_check == false) {
			out.println("(����)��ȿ���� ���� genre�Դϴ�.");
			movie_input = false;
		}
		
		
		boolean version_check = false;
		for (NationalityDTO dto : list2) {
			if (dto.getShort_name().toString().equals(nationality)) {
				version_check = true;
			}
		}

		if (version_check == false) {
			out.println("(����)��ȿ���� ���� original version�Դϴ�.");
			movie_input = false;
		}
		
		
		
		
		boolean date_consistent = true;
		int year=0, month=0, day=0;

		if (start_date.length() != 10 || (start_date.length() > 4 && start_date.charAt(4) != '-')
				|| (start_date.length() > 7 && start_date.charAt(7) != '-')) {
			out.println("(����)��ȿ���� ���� opening date�Դϴ�.");
			movie_input = false;
			date_consistent = false;
		}

		if (start_date.length() >= 10) {
			for (int i = 0; i <= 9; i++) {
				if (i == 4 | i == 7)
					continue;

				if (start_date.charAt(i) <= '9' && start_date.charAt(i) >= '0') {
				} else {
					out.println("(����)��ȿ���� ���� opening date�Դϴ�.");
					date_consistent = false;
					movie_input = false;
				}
				if (i == 9) {
					if (date_consistent == true) {
						year = Integer.valueOf(start_date.substring(0, 4));
						month = Integer.valueOf(start_date.substring(5, 7));
						day = Integer.valueOf(start_date.substring(8));
					}
				}
			}

			if (start_date.length() >= 10 && date_consistent == true) {

				//out.println("+++" + year + " " + month + " " + day);

				if (year < 1900) {
					out.println("(����)��ȿ���� ���� opening date�Դϴ�.");
					movie_input = false;
				}
				if (month < 1 || month > 12) {
					out.println("(����)��ȿ���� ���� opening date�Դϴ�.");
					movie_input = false;
				}
				if (day < 1 || day > 31) {
					out.println("(����)��ȿ���� ���� opening date�Դϴ�.");
					movie_input = false;
				}
				
				Calendar check_date;
				Calendar cur_date;
				
				check_date = Calendar.getInstance();
				cur_date = Calendar.getInstance();

				check_date.set(Calendar.YEAR, year);
				check_date.set(Calendar.MONTH, month);
				check_date.set(Calendar.DATE, day);

				if (check_date.compareTo(cur_date) > 0) {
					out.println(check_date.getTime() + " " + cur_date.getTime());
					out.println("(����)��ȿ���� ���� opening date�Դϴ�.");
					movie_input = false;
				}
			}
		}
		
		if (movie_input == true) {
			
			int num = choice();
			
			while(num<1 || num>2) {
				System.out.println("\n�߸��� �Է�!");
				num = choice();
			}
			
			if(num == 1)
				request.put("movie_input", true);
			else
				request.put("movie_input", false);
		} else {
			request.put("movie_input", false);
		}
	}

}
