package view;

import java.util.List;

import model.MovieDTO;

public class ShowAllMovieView {
	public void list(List<MovieDTO> list) {
		int count=0;

		System.out.println("### 전체 영상물 리스트 ###");
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("|  ID |                      TITLE                         |         TYPE         |      GENRE      | RUNTIME | START_YEAR | RATING |");

		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
		for (MovieDTO dto : list) {
			count++;
			System.out.printf("| %3d | %-50s | %-20s | %-15s |   %3d   |    %s    |  %4.1f  |\n", dto.getId(), dto.getTitle(), dto.getType(), dto.getGenre(),
					dto.getRuntime(), dto.getStart_date().toString().substring(0, 4), dto.getRating());
		}
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
		
		if(count == 0) {
			System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("|                                                      등록된 영상물 없음                                                                |");
			System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
		}
	}
}
