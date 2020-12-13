package controller;

import java.util.List;

import model.MovieDAO;
import model.MovieDTO;
import resource.R;

public class SearchByTitleController implements R {

	String title;

	public void process() {
/*
		while (true) {
			searchByTitleView.show();

			title = request.get("title_to_search").toString();

			System.out.println(title);

			MovieDAO dao = new MovieDAO();
			List<MovieDTO> list = dao.list_for_title_search(title);

			if (list.size() == 0) {
				searchByTitleResultView.noResultMenu();
				scan.nextLine();

				if ((int) request.get("noResultMenu_selectNo") == 2) {
					break;
				}
			} else {
				while (true) {
					searchByTitleResultView.list(title);
					searchByTitleResultView.yesResultMenu(title);
					scan.nextLine();

					if ((int) request.get("YesResultMenu_selectNo") == 3) {
						return;
					}

					if ((int) request.get("YesResultMenu_selectNo") == 1) {
						showMovieDetailController.process(title);
						
						if((boolean)request.get("rate_success")  == true && request.get("client_type").equals("U")) {
							return;
						}
					}
					
					if ((int) request.get("YesResultMenu_selectNo") == 2) {
						break;
					}
				}
			}

		}*/
	}

}
